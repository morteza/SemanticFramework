package org.yaoqiang.model.bpmn.elements.events;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.activities.SubProcess;
import org.yaoqiang.model.bpmn.elements.process.data.Properties;

/**
 * Event
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class Event extends FlowNode {

	private static final long serialVersionUID = 4420172447198557330L;

	public Event(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		Properties refProperties = new Properties(this);

		super.fillStructure();
		add(refProperties);
	}

	public final Properties getProperties() {
		return (Properties) get("properties");
	}
	
	public List<XMLElement> getAccessibleProperties() {
		List<XMLElement> properties = getProperties().getXMLElements();
		if (getParent().getParent() instanceof SubProcess) {
			properties.addAll(((SubProcess) getParent().getParent()).getAccessibleProperties());
		} else if (getParent().getParent() instanceof BPMNProcess) {
			properties.addAll(((BPMNProcess) getParent().getParent()).getAccessibleProperties());
		}
		return properties;
	}
	
	public final Properties setProperties(Properties properties) {
		getProperties().clear();
		getProperties().addAll(properties.getXMLElements());
		return properties;
	}
	
	public final EventDefinitions getEventDefinitions() {
		return (EventDefinitions) get("eventDefinitions");
	}
	
	public final EventDefinitions setEventDefinitions(EventDefinitions eventDefinitions){
		getEventDefinitions().clear();
		getEventDefinitions().addAll(eventDefinitions.getXMLElements());
		return eventDefinitions;
	}
	
	public final EventDefinition getEventDefinition() {
		if (getAllEventDefinitionList().isEmpty()) {
			return null;
		} else {
			return (EventDefinition) getAllEventDefinitionList().get(0);
		}
	}

	public final EventDefinition getRefEventDefinition() {
		if (getRefEventDefinitionList().isEmpty()) {
			return null;
		} else {
			return (EventDefinition) getRefEventDefinitionList().get(0);
		}
	}

	public final XMLTextElements getEventDefinitionRefs() {
		return (XMLTextElements) get("eventDefinitionRef");
	}

	public final XMLTextElements setEventDefinitionRefs(XMLTextElements eventDefinitionRefs){
		getEventDefinitionRefs().clear();
		getEventDefinitionRefs().addAll(eventDefinitionRefs.getXMLElements());
		return eventDefinitionRefs;
	}
	
	public final List<XMLElement> getEventDefinitionRefList() {
		return getEventDefinitionRefs().getXMLElements();
	}

	public final List<XMLElement> getAllEventDefinitionList() {
		List<XMLElement> els = new ArrayList<XMLElement>();
		els.addAll(getEventDefinitionList());
		els.addAll(getRefEventDefinitionList());
		return els;
	}
	
	public final List<XMLElement> getEventDefinitionList() {
		return getEventDefinitions().getXMLElements();
	}
	
	public final List<XMLElement> getRefEventDefinitionList() {
		List<XMLElement> els = new ArrayList<XMLElement>();
		for (XMLElement edRef: getEventDefinitionRefList()) {
			EventDefinition ed = BPMNModelUtils.getDefinitions(parent).getEventDefinition(edRef.toValue());
			if (ed != null) {
				ed = (EventDefinition) ed.clone();
				ed.setParent(getEventDefinitions());
				els.add(ed);
			}
		}
		return els;
	}

	public boolean hasEventDefinition(String id) {
		return getEventDefinitions().contains(id);
	}
	
	public boolean hasEventDefinitionRef(String ref) {
		for (XMLElement edRef: getEventDefinitionRefList()) {
			if (edRef.toValue().equals(ref)) {
				return true;
			}
		}
		return false;
	}
	
	public void addEventDefinitionRef(String ref) {
		for (XMLElement edRef: getEventDefinitionRefList()) {
			if (edRef.toValue().equals(ref)) {
				return;
			}
		}
		XMLElement eventDefinitionRef = getEventDefinitionRefs().generateNewElement();
		eventDefinitionRef.setValue(ref);
		getEventDefinitionRefs().add(eventDefinitionRef);
	}
	
	public final EventDefinition generateEventDefinition(String type) {
		EventDefinitions eventDefinitions = getEventDefinitions();
		eventDefinitions.setType(type);
		EventDefinition el = (EventDefinition)eventDefinitions.generateNewElement();
		return el;
	}
	
	public final void addEventDefinition(EventDefinition eventDefinition) {
		if (eventDefinition != null && !getEventDefinitions().contains(eventDefinition.getId())) {
			eventDefinition.setId(getEventDefinitions().createId(getId() + "_ED"));
			getEventDefinitions().add(eventDefinition);
		}
	}

	public void removeEventDefinition(String id) {
		if (getEventDefinitions().contains(id)) {
			getEventDefinitions().remove(id);
		} else {
			for (XMLElement edRef: getEventDefinitionRefList()) {
				if (edRef.toValue().equals(id)) {
					getEventDefinitionRefs().remove(id);
				}
			}
		}
	}
	
}

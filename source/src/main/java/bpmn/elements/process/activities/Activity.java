package org.yaoqiang.model.bpmn.elements.process.activities;

import java.util.List;
import java.util.Set;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.data.DataInputAssociation;
import org.yaoqiang.model.bpmn.elements.process.data.DataInputAssociations;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutputAssociation;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutputAssociations;
import org.yaoqiang.model.bpmn.elements.process.data.InputOutputSpecification;
import org.yaoqiang.model.bpmn.elements.process.data.Properties;

/**
 * Activity
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class Activity extends FlowNode {

	private static final long serialVersionUID = -4546869324197772950L;

	public Activity(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrIsForCompensation = new XMLAttribute(this, "isForCompensation", Boolean.FALSE.toString());
		XMLAttribute attrStartQuantity = new XMLAttribute(this, "startQuantity", "1");
		XMLAttribute attrCompletionQuantity = new XMLAttribute(this, "completionQuantity", "1");
		XMLAttribute attrDefault = new XMLAttribute(this, "default");
		InputOutputSpecification refInputOutputSpecification = new InputOutputSpecification(this);
		Properties refProperties = new Properties(this);
		DataInputAssociations refDataInputAssociations = new DataInputAssociations(this);
		DataOutputAssociations refDataOutputAssociations = new DataOutputAssociations(this);
		ResourceRoles refResourceRoles = new ResourceRoles(this);
		LoopTypes refLoopTypes = new LoopTypes(this);

		super.fillStructure();
		add(attrIsForCompensation);
		add(attrStartQuantity);
		add(attrCompletionQuantity);
		add(attrDefault);
		add(refInputOutputSpecification);
		add(refProperties);
		add(refDataInputAssociations);
		add(refDataOutputAssociations);
		add(refResourceRoles);
		add(refLoopTypes);
	}

	public final boolean isForCompensation() {
		return Boolean.parseBoolean(get("isForCompensation").toValue());
	}

	public final boolean getIsForCompensation() {
		return isForCompensation();
	}

	public final void setIsForCompensation(boolean isForCompensation) {
		set("isForCompensation", String.valueOf(isForCompensation));
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

	public final InputOutputSpecification getIoSpecification() {
		return (InputOutputSpecification) get("ioSpecification");
	}

	public final DataInputAssociations getDataInputAssociations() {
		return (DataInputAssociations) get("dataInputAssociations");
	}

	public final DataOutputAssociations getDataOutputAssociations() {
		return (DataOutputAssociations) get("dataOutputAssociations");
	}

	public final List<XMLElement> getDataInOuts() {
		List<XMLElement> dio = getIoSpecification().getDataInputs().getXMLElements();
		dio.addAll(getIoSpecification().getDataOutputs().getXMLElements());
		return dio;
	}

	public final List<XMLElement> getDataInOutAssociations() {
		List<XMLElement> dio = getDataInputAssociations().getXMLElements();
		dio.addAll(getDataOutputAssociations().getXMLElements());
		return dio;
	}

	public final Properties setProperties(Properties properties) {
		getProperties().clear();
		getProperties().addAll(properties.getXMLElements());
		return properties;
	}

	public final void clearDataInOuts() {
		getIoSpecification().clear();
		getDataInputAssociations().clear();
		getDataOutputAssociations().clear();
	}

	public final DataInputAssociation addDataInputAssociation(String id, String sourceId, String dataInputId) {
		DataInputAssociation dia = (DataInputAssociation) getDataInputAssociations().generateNewElement();
		dia.setId(id);
		dia.addSourceRef(sourceId);
		dia.setTargetRef(dataInputId);
		getDataInputAssociations().add(dia);
		return dia;
	}

	public final DataOutputAssociation addDataOutputAssociation(String id, String dataOutputId, String targetId) {
		DataOutputAssociation doa = (DataOutputAssociation) getDataOutputAssociations().generateNewElement();
		doa.setId(id);
		doa.addSourceRef(dataOutputId);
		doa.setTargetRef(targetId);
		getDataOutputAssociations().add(doa);
		return doa;
	}

	public String getLoopType() {
		LoopCharacteristics loopType = getLoopCharacteristics();
		String type = "None";
		if (loopType instanceof StandardLoopCharacteristics) {
			type = "Standard";
		} else if (loopType instanceof MultiInstanceLoopCharacteristics) {
			type = "Multi-Instance";
		}
		return type;
	}

	public void setLoopType(String type) {
		if ("None".equals(type)) {
			setLoopCharacteristics("");
		} else if ("Standard".equals(type)) {
			setLoopCharacteristics(LoopTypes.STANDARD_LOOPCHARACTERISTICS);
		} else if ("Multi-Instance".equals(type)) {
			setLoopCharacteristics(LoopTypes.MULTI_INSTANCE_LOOPCHARACTERISTICS);
		}
	}

	public boolean isTestBefore() {
		return ((StandardLoopCharacteristics) getLoopCharacteristics()).isTestBefore();
	}

	public void setTestBefore(boolean testBefore) {
		((StandardLoopCharacteristics) getLoopCharacteristics()).setTestBefore(testBefore);
	}

	public String getLoopMaximum() {
		return ((StandardLoopCharacteristics) getLoopCharacteristics()).getLoopMaximum();
	}

	public void setLoopMaximum(String loopMaximum) {
		((StandardLoopCharacteristics) getLoopCharacteristics()).setLoopMaximum(loopMaximum);
	}

	public String getLoopCondition() {
		return ((StandardLoopCharacteristics) getLoopCharacteristics()).getLoopCondition();
	}

	public void setLoopCondition(String loopCondition) {
		((StandardLoopCharacteristics) getLoopCharacteristics()).setLoopCondition(loopCondition);
	}

	public boolean getIsSequential() {
		return ((MultiInstanceLoopCharacteristics) getLoopCharacteristics()).isSequential();
	}

	public void setIsSequential(boolean isSequential) {
		((MultiInstanceLoopCharacteristics) getLoopCharacteristics()).setIsSequential(isSequential);
	}
	
	public final LoopTypes getLoopTypes() {
		return (LoopTypes) get("loopCharacteristics");
	}

	public final LoopCharacteristics getLoopCharacteristics() {
		List<XMLElement> loopTypes = getLoopTypes().getXMLElements();
		if (loopTypes.isEmpty()) {
			return null;
		} else {
			return (LoopCharacteristics) loopTypes.get(0);
		}

	}

	public final LoopCharacteristics setLoopCharacteristics(LoopCharacteristics loopCharacteristics) {
		getLoopTypes().clear();
		getLoopTypes().add(loopCharacteristics);
		return loopCharacteristics;
	}

	public final LoopCharacteristics setLoopCharacteristics(String loopType) {
		getLoopTypes().setType(loopType);
		LoopCharacteristics loopCharacteristics = (LoopCharacteristics) getLoopTypes().generateNewElement();
		getLoopTypes().clear();
		getLoopTypes().add(loopCharacteristics);
		return loopCharacteristics;
	}

	public final ResourceRoles getResourceRoles() {
		return (ResourceRoles) get("resources");
	}

	public final ResourceRoles setResourceRoles(ResourceRoles resourceRoles) {
		getResourceRoles().clear();
		getResourceRoles().addAll(resourceRoles.getXMLElements());
		return resourceRoles;
	}

	public final String getDefault() {
		return get("default").toValue();
	}

	public final void setDefault(String _default) {
		set("default", _default);
	}

	public SequenceFlow getDefaultSequenceFlow() {
		return (SequenceFlow) getParent().getFlowElement(getDefault());
	}

	public final Set<BoundaryEvent> getBoundaryEventRefs() {
		return getParent().getBoundaryEventMap().get(getId());
	}

}

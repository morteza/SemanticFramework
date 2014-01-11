package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;
import org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities.CallChoreography;
import org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities.ChoreographyTask;
import org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities.SubChoreography;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;
import org.yaoqiang.model.bpmn.elements.events.CompensateEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.EndEvent;
import org.yaoqiang.model.bpmn.elements.events.Event;
import org.yaoqiang.model.bpmn.elements.events.EventDefinition;
import org.yaoqiang.model.bpmn.elements.events.ImplicitThrowEvent;
import org.yaoqiang.model.bpmn.elements.events.IntermediateCatchEvent;
import org.yaoqiang.model.bpmn.elements.events.IntermediateThrowEvent;
import org.yaoqiang.model.bpmn.elements.events.LinkEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.StartEvent;
import org.yaoqiang.model.bpmn.elements.gateways.ComplexGateway;
import org.yaoqiang.model.bpmn.elements.gateways.EventBasedGateway;
import org.yaoqiang.model.bpmn.elements.gateways.ExclusiveGateway;
import org.yaoqiang.model.bpmn.elements.gateways.InclusiveGateway;
import org.yaoqiang.model.bpmn.elements.gateways.ParallelGateway;
import org.yaoqiang.model.bpmn.elements.process.activities.AdHocSubProcess;
import org.yaoqiang.model.bpmn.elements.process.activities.BusinessRuleTask;
import org.yaoqiang.model.bpmn.elements.process.activities.CallActivity;
import org.yaoqiang.model.bpmn.elements.process.activities.ReceiveTask;
import org.yaoqiang.model.bpmn.elements.process.activities.ScriptTask;
import org.yaoqiang.model.bpmn.elements.process.activities.SendTask;
import org.yaoqiang.model.bpmn.elements.process.activities.ServiceTask;
import org.yaoqiang.model.bpmn.elements.process.activities.SubProcess;
import org.yaoqiang.model.bpmn.elements.process.activities.Task;
import org.yaoqiang.model.bpmn.elements.process.activities.Transaction;
import org.yaoqiang.model.bpmn.elements.process.data.DataObject;
import org.yaoqiang.model.bpmn.elements.process.data.DataObjectReference;
import org.yaoqiang.model.bpmn.elements.process.data.DataStoreReference;
import org.yaoqiang.model.bpmn.elements.process.humaninteraction.ManualTask;
import org.yaoqiang.model.bpmn.elements.process.humaninteraction.UserTask;

/**
 * FlowElements
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class FlowElements extends XMLFactoryElement {

	private static final long serialVersionUID = 4693634794536484495L;
	
	public static final String TYPE_BOUNDARY_EVENT = "boundaryEvent";
	public static final String TYPE_END_EVENT = "endEvent";
	public static final String TYPE_START_EVENT = "startEvent";
	public static final String TYPE_INTERMEDIATE_CATCH_EVENT = "intermediateCatchEvent";
	public static final String TYPE_INTERMEDIATE_THROW_EVENT = "intermediateThrowEvent";
	public static final String TYPE_IMPLICIT_THROW_EVENT = "implicitThrowEvent";

	public static final String TYPE_TASK = "task";
	public static final String TYPE_BUSINESS_RULE_TASK = "businessRuleTask";
	public static final String TYPE_MANUAL_TASK = "manualTask";
	public static final String TYPE_RECEIVE_TASK = "receiveTask";
	public static final String TYPE_SCRIPT_TASK = "scriptTask";
	public static final String TYPE_SEND_TASK = "sendTask";
	public static final String TYPE_SERVICE_TASK = "serviceTask";
	public static final String TYPE_USER_TASK = "userTask";
	public static final String TYPE_CALL_ACTIVITY = "callActivity";

	public static final String TYPE_CALL_CHOREOGRAPHY = "callChoreography";
	public static final String TYPE_CHOREOGRAPHY_TASK = "choreographyTask";
	public static final String TYPE_SUBCHOREOGRAPHY = "subChoreography";

	public static final String TYPE_SUBPROCESS = "subProcess";
	public static final String TYPE_ADHOC_SUBPROCESS = "adHocSubProcess";
	public static final String TYPE_TRANSACTION = "transaction";

	public static final String TYPE_DATAOBJECT = "dataObject";
	public static final String TYPE_DATAOBJECT_REFERENCE = "dataObjectReference";
	public static final String TYPE_DATASTORE_REFERENCE = "dataStoreReference";

	public static final String TYPE_COMPLEX_GATEWAY = "complexGateway";
	public static final String TYPE_EVENT_BASED_GATEWAY = "eventBasedGateway";
	public static final String TYPE_EXCLUSIVE_GATEWAY = "exclusiveGateway";
	public static final String TYPE_INCLUSIVE_GATEWAY = "inclusiveGateway";
	public static final String TYPE_PARALLEL_GATEWAY = "parallelGateway";

	public static final String TYPE_SEQUENCE_FLOW = "sequenceFlow";

	public FlowElements(XMLElement parent) {
		super(parent, "flowElements");
	}

	public XMLElement generateFlowElement(String type) {
		setType(type);
		XMLElement el = generateNewElement();
		return el;
	}

	public XMLElement generateNewElement() {
		if (type.equals(TYPE_BOUNDARY_EVENT)) {
			return new BoundaryEvent(this);
		} else if (type.equals(TYPE_END_EVENT)) {
			return new EndEvent(this);
		} else if (type.equals(TYPE_START_EVENT)) {
			return new StartEvent(this);
		} else if (type.equals(TYPE_INTERMEDIATE_CATCH_EVENT)) {
			return new IntermediateCatchEvent(this);
		} else if (type.equals(TYPE_INTERMEDIATE_THROW_EVENT)) {
			return new IntermediateThrowEvent(this);
		} else if (type.equals(TYPE_IMPLICIT_THROW_EVENT)) {
			return new ImplicitThrowEvent(this);
		} else if (type.equals(TYPE_TASK)) {
			return new Task(this);
		} else if (type.equals(TYPE_BUSINESS_RULE_TASK)) {
			return new BusinessRuleTask(this);
		} else if (type.equals(TYPE_MANUAL_TASK)) {
			return new ManualTask(this);
		} else if (type.equals(TYPE_RECEIVE_TASK)) {
			return new ReceiveTask(this);
		} else if (type.equals(TYPE_SCRIPT_TASK)) {
			return new ScriptTask(this);
		} else if (type.equals(TYPE_SEND_TASK)) {
			return new SendTask(this);
		} else if (type.equals(TYPE_SERVICE_TASK)) {
			return new ServiceTask(this);
		} else if (type.equals(TYPE_USER_TASK)) {
			return new UserTask(this);
		} else if (type.equals(TYPE_CALL_ACTIVITY)) {
			return new CallActivity(this);
		} else if (type.equals(TYPE_CALL_CHOREOGRAPHY)) {
			return new CallChoreography(this);
		} else if (type.equals(TYPE_CHOREOGRAPHY_TASK)) {
			return new ChoreographyTask(this);
		} else if (type.equals(TYPE_SUBCHOREOGRAPHY)) {
			return new SubChoreography(this);
		} else if (type.equals(TYPE_SUBPROCESS)) {
			return new SubProcess(this);
		} else if (type.equals(TYPE_ADHOC_SUBPROCESS)) {
			return new AdHocSubProcess(this);
		} else if (type.equals(TYPE_TRANSACTION)) {
			return new Transaction(this);
		} else if (type.equals(TYPE_DATAOBJECT)) {
			DataObject dataObject = new DataObject(this);
			String id = ((BaseElement) getParent()).getId();
			dataObject.setId(createId("DO" + (id.startsWith("_") ? "" : "_") + id));
			return dataObject;
		} else if (type.equals(TYPE_DATAOBJECT_REFERENCE)) {
			DataObjectReference dataObjectRef = new DataObjectReference(this);
			String id = ((BaseElement) getParent()).getId();
			dataObjectRef.setId(createId("DO" + (id.startsWith("_") ? "" : "_") + id));
			return dataObjectRef;
		} else if (type.equals(TYPE_DATASTORE_REFERENCE)) {
			return new DataStoreReference(this);
		} else if (type.equals(TYPE_COMPLEX_GATEWAY)) {
			return new ComplexGateway(this);
		} else if (type.equals(TYPE_EVENT_BASED_GATEWAY)) {
			return new EventBasedGateway(this);
		} else if (type.equals(TYPE_EXCLUSIVE_GATEWAY)) {
			return new ExclusiveGateway(this);
		} else if (type.equals(TYPE_INCLUSIVE_GATEWAY)) {
			return new InclusiveGateway(this);
		} else if (type.equals(TYPE_PARALLEL_GATEWAY)) {
			return new ParallelGateway(this);
		} else if (type.equals(TYPE_SEQUENCE_FLOW)) {
			return new SequenceFlow(this);
		}
		return null;
	}

	public XMLElement getFlowElement(String id) {
		int index = id.indexOf(":");
		if (index != -1) {
			id = id.substring(index + 1);
		}
		return getCollectionElement(id);
	}

	public Map<String,Set<BoundaryEvent>> getBoundaryEventMap() {
		Map<String,Set<BoundaryEvent>> boundaryEvents = new HashMap<String,Set<BoundaryEvent>>();
		for (XMLElement el : getXMLElements()) {
			if (el instanceof BoundaryEvent) {
				String act = ((BoundaryEvent) el).getAttachedToRef();
				Set<BoundaryEvent> events = boundaryEvents.get(act);
				if (events == null) {
					events = new HashSet<BoundaryEvent>();
				}
				events.add((BoundaryEvent) el);
				boundaryEvents.put(act, events);
			}
		}
		return boundaryEvents;
	}

	public List<XMLElement> getActivitiesForCompensation() {
		List<XMLElement> acts = new ArrayList<XMLElement>();
		for (XMLElement el : getXMLElements()) {
			if (el instanceof BoundaryEvent && ((BoundaryEvent) el).getEventDefinition() instanceof CompensateEventDefinition) {
				acts.add(getFlowElement(((BoundaryEvent) el).getAttachedToRef()));
			} else if (el instanceof SubProcess && ((SubProcess) el).hasCompensationEventSubProcess()) {
				acts.add(el);
			}
		}
		return acts;
	}

	public List<XMLElement> getLinkEventDefinition(Event event) {
		List<XMLElement> links = new ArrayList<XMLElement>();
		for (XMLElement el : getXMLElements()) {
			if (el instanceof Event && !event.getClass().isInstance(el)) {
				EventDefinition ed = ((Event) el).getEventDefinition();
				if (ed instanceof LinkEventDefinition && ((LinkEventDefinition) ed).getName().equals(event.getName())) {
					links.add(ed);
				}
			}
		}
		return links;
	}

	public List<DataObjectReference> getDataObjectRefs(String dataObjectId) {
		List<DataObjectReference> dataObjectRefs = new ArrayList<DataObjectReference>();
		for (XMLElement el : getXMLElements()) {
			if (el instanceof DataObjectReference && ((DataObjectReference) el).getDataObjectRef().equals(dataObjectId)) {
				dataObjectRefs.add((DataObjectReference) el);
			} else if (el instanceof SubProcess) {
				dataObjectRefs.addAll(((SubProcess) el).getFlowElements().getDataObjectRefs(dataObjectId));
			}
		}
		return dataObjectRefs;
	}

	public List<String> getDataObjectRefIds(String dataObjectId) {
		List<String> dataObjectRefs = new ArrayList<String>();
		for (DataObjectReference el : getDataObjectRefs(dataObjectId)) {
			dataObjectRefs.add(el.getId());
		}
		return dataObjectRefs;
	}

	public List<XMLElement> getDataObjects() {
		List<XMLElement> dataObjects = new ArrayList<XMLElement>();
		dataObjects.addAll(getDataObjects(false));
		dataObjects.addAll(getDataObjects(true));
		return dataObjects;
	}

	public List<XMLElement> getDataObjects(boolean isCollection) {
		List<XMLElement> dataObjects = new ArrayList<XMLElement>();
		for (XMLElement el : getXMLElements()) {
			if (el instanceof DataObject && ((DataObject) el).isCollection() == isCollection) {
				dataObjects.add(el);
			}
		}
		return dataObjects;
	}

	public List<XMLElement> getAccessibleDataObjects() {
		List<XMLElement> dataObjects = new ArrayList<XMLElement>();
		dataObjects.addAll(getAccessibleDataObjects(false));
		dataObjects.addAll(getAccessibleDataObjects(true));
		return dataObjects;

	}

	public List<DataObject> getAccessibleDataObjects(boolean isCollection) {
		List<DataObject> dataObjects = new ArrayList<DataObject>();
		for (XMLElement el : getXMLElements()) {
			if (el instanceof DataObject && ((DataObject) el).isCollection() == isCollection) {
				dataObjects.add((DataObject) el);
			}
		}
		if (getParent() instanceof SubProcess) {
			dataObjects.addAll(((FlowElements) getParent().getParent()).getAccessibleDataObjects(isCollection));
		}
		return dataObjects;
	}

	public List<String> getAccessibleDataObjectNames(boolean isCollection) {
		List<String> dataObjects = new ArrayList<String>();
		for (DataObject el : getAccessibleDataObjects(isCollection)) {
			dataObjects.add(el.getName());
		}
		return dataObjects;
	}

	public String getAccessibleDataObjectId(String name, boolean isCollection) {
		for (DataObject el : getAccessibleDataObjects(isCollection)) {
			if (el.getName().equals(name)) {
				return el.getId();
			}
		}
		return "";
	}

	public Object clone() {
		XMLCollectionElement d = (XMLCollectionElement) super.clone();
		d.clear();
		return d;
	}
}

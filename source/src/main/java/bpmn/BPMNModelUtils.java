package org.yaoqiang.model.bpmn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLConstants;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.artifacts.Artifacts;
import org.yaoqiang.model.bpmn.elements.artifacts.Association;
import org.yaoqiang.model.bpmn.elements.artifacts.Category;
import org.yaoqiang.model.bpmn.elements.artifacts.CategoryValue;
import org.yaoqiang.model.bpmn.elements.bpmndi.BPMNEdge;
import org.yaoqiang.model.bpmn.elements.bpmndi.BPMNShape;
import org.yaoqiang.model.bpmn.elements.choreography.Choreography;
import org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities.ChoreographyActivity;
import org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities.ChoreographyTask;
import org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities.SubChoreography;
import org.yaoqiang.model.bpmn.elements.collaboration.Collaboration;
import org.yaoqiang.model.bpmn.elements.collaboration.MessageFlow;
import org.yaoqiang.model.bpmn.elements.collaboration.Participant;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElementsContainer;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.core.common.ItemDefinition;
import org.yaoqiang.model.bpmn.elements.core.common.Resource;
import org.yaoqiang.model.bpmn.elements.core.common.ResourceParameter;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.Documentation;
import org.yaoqiang.model.bpmn.elements.core.infrastructure.Definitions;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;
import org.yaoqiang.model.bpmn.elements.events.CatchEvent;
import org.yaoqiang.model.bpmn.elements.events.Event;
import org.yaoqiang.model.bpmn.elements.events.StartEvent;
import org.yaoqiang.model.bpmn.elements.events.ThrowEvent;
import org.yaoqiang.model.bpmn.elements.gateways.EventBasedGateway;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.Lane;
import org.yaoqiang.model.bpmn.elements.process.LaneSet;
import org.yaoqiang.model.bpmn.elements.process.activities.Activity;
import org.yaoqiang.model.bpmn.elements.process.activities.CallActivity;
import org.yaoqiang.model.bpmn.elements.process.activities.SubProcess;
import org.yaoqiang.model.bpmn.elements.process.data.DataObject;
import org.yaoqiang.model.bpmn.elements.process.data.DataObjectReference;
import org.yaoqiang.model.bpmn.elements.process.data.DataStore;
import org.yaoqiang.model.bpmn.elements.process.data.DataStoreReference;
import org.yaoqiang.model.bpmn.elements.process.data.Properties;
import org.yaoqiang.model.util.XMLModelUtils;

/**
 * BPMNModelUtils
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNModelUtils {

	public static Definitions parseBPMN(String location) {
		Definitions bpmnModel = new Definitions();
		Document document = XMLModelUtils.parseXml(location);
		if (document != null) {
			new BPMNModelCodec().decode(document.getDocumentElement(), bpmnModel);
		}
		return bpmnModel;
	}

	public static Definitions getDefinitions(XMLElement el) {
		if (el == null)
			return null;
		while (!(el instanceof Definitions)) {
			el = el.getParent();
			if (el == null)
				break;
		}
		return (Definitions) el;
	}

	public static boolean hasAttachments(BaseElement el) {
		boolean hasAttachments = false;
		for (XMLElement doc : el.getDocumentations().getXMLElements()) {
			String format = ((Documentation) doc).getTextFormat();
			if (format.length() != 0 && !format.equals("text/plain")) {
				return true;
			}
		}
		return hasAttachments;
	}

	public static void refreshTypes(Definitions defs) {
		defs.resetTypes();
		for (XMLElement el : defs.getItemDefinitions()) {
			ItemDefinition itemDefinition = (ItemDefinition) el;
			defs.addType(itemDefinition.getStructureRef());
		}
	}

	public static void fillAllFlowNodeSequenceFlowRefs(Definitions defs) {
		for (BPMNProcess p : defs.getProcesses()) {
			fillFlowNodeSequenceFlowRefs(p);
		}
	}

	public static void fillFlowNodeSequenceFlowRefs(FlowElementsContainer container) {
		for (SequenceFlow sf : container.getSequenceFlows()) {
			FlowElement source = container.getFlowElement(sf.getSourceRef());
			if (source != null && source instanceof FlowNode) {
				((FlowNode) source).addOutgoing(sf.getId());
			}
			FlowElement target = container.getFlowElement(sf.getTargetRef());
			if (target != null && target instanceof FlowNode) {
				((FlowNode) target).addIncoming(sf.getId());
			}
		}

		for (FlowNode node : container.getFlowNodes()) {
			if (node instanceof FlowElementsContainer) {
				fillFlowNodeSequenceFlowRefs((FlowElementsContainer) node);
			}
		}
	}

	public static List<Object> getAllItemDefinitions(XMLElement el) {
		List<Object> items = new ArrayList<Object>();
		Definitions defs = getDefinitions(el);
		if (defs == null) {
			return items;
		} else {
			String prefix = defs.getNamespacePrefix(XMLConstants.XMLNS_XSD);
			items.addAll(XMLModelUtils.getXmlBuiltinTypes(prefix));
			items.addAll(defs.getItemDefinitions());
		}
		return items;
	}

	public static String getCategoryValueId(Definitions defs, String label) {
		String[] catvalue = label.split(":");
		if (catvalue.length != 2) {
			catvalue = new String[] { "", label };
		}
		for (XMLElement category : defs.getCategories()) {
			String catName = ((Category) category).getName();
			if (catvalue[0].equals(catName)) {
				for (XMLElement categoryValue : ((Category) category).getCategoryValueList()) {
					String catValue = ((CategoryValue) categoryValue).getValue();
					if (catvalue[1].equals(catValue)) {
						return ((CategoryValue) categoryValue).getId();
					}
				}
			}
		}
		return "";
	}

	public static Object[] getAllCategoryValueNames(Definitions defs) {
		List<String> categories = new ArrayList<String>();
		for (XMLElement category : defs.getCategories()) {
			String catName = ((Category) category).getName();
			for (XMLElement categoryValue : ((Category) category).getCategoryValueList()) {
				String catValue = ((CategoryValue) categoryValue).getValue();
				if (catName.length() == 0) {
					categories.add(catValue);
				} else {
					categories.add(catName + ":" + catValue);
				}
			}
		}
		return categories.toArray();
	}

	public static String getCategoryValueString(Definitions defs, String categoryValueId) {
		CategoryValue categoryValue = defs.getCategoryValue(categoryValueId);
		if (categoryValue == null) {
			return "";
		} else {
			String catName = categoryValue.getParent().getParent().getName();
			String catValue = categoryValue.getValue();
			if (catName.length() == 0) {
				return catValue;
			} else {
				return catName + ":" + catValue;
			}
		}
	}

	public static List<String> getCategoryValueList(Definitions defs, String flowElementId) {
		List<String> categoryValues = new ArrayList<String>();
		for (String id : getCachedCategoryValueIds(defs, flowElementId)) {
			categoryValues.add(getCategoryValueString(defs, id));
		}
		return categoryValues;
	}

	public static Set<String> getAllCategoryValueIds(Category category) {
		Set<String> ids = new HashSet<String>();
		for (XMLElement categoryValue : category.getCategoryValueList()) {
			ids.add(((CategoryValue) categoryValue).getId());
		}
		return ids;
	}

	public static Set<String> getCachedCategoryValueIds(Definitions defs, String flowElementId) {
		Set<String> categoryValues = new HashSet<String>();
		for (XMLElement cat : defs.getCategories()) {
			for (XMLElement catValue : ((Category) cat).getCategoryValueList()) {
				for (XMLElement el : ((CategoryValue) catValue).getCategorizedFlowElements(false)) {
					if (((FlowElement) el).getId().equals(flowElementId))
						categoryValues.add(((CategoryValue) catValue).getId());
				}
			}
		}
		return categoryValues;
	}

	public static List<XMLElement> getCategorizedFlowElements(CategoryValue categoryValue) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		String id = categoryValue.getId();
		Definitions defs = getDefinitions(categoryValue);
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, id, null));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllDataObjects(Definitions defs, String itemId) {
		List<XMLElement> result = new ArrayList<XMLElement>();

		List<XMLElement> dataObjects = new ArrayList<XMLElement>();
		for (XMLElement p : getAllNoneEmptyProcesses(defs)) {
			BPMNProcess process = (BPMNProcess) p;
			dataObjects.addAll(process.getDataInOuts());
			for (XMLElement f : getFlowElements(process, null, null)) {
				if (f instanceof DataObject) {
					dataObjects.add(f);
				} else if (f instanceof Activity) {
					dataObjects.addAll(((Activity) f).getDataInOuts());
				} else if (f instanceof CatchEvent) {
					dataObjects.addAll(((CatchEvent) f).getDataOutputList());
				} else if (f instanceof ThrowEvent) {
					dataObjects.addAll(((ThrowEvent) f).getDataInputList());
				}
			}
		}

		if (itemId != null && itemId.length() != 0) {
			for (XMLElement o : dataObjects) {
				String itemRef = ((XMLComplexElement) o).get("itemSubjectRef").toValue();
				if (itemRef.length() == 0) {
					continue;
				}
				int index = itemRef.indexOf(":");
				if (index != -1) {
					itemRef = itemRef.substring(index + 1);
				}
				index = itemId.indexOf(":");
				if (index != -1) {
					itemId = itemId.substring(index + 1);
				}
				if (itemRef.equals(itemId)) {
					result.add(o);
				}
			}
		} else {
			return dataObjects;
		}

		return result;
	}

	public static Object[] getAllDataStoreNames(Definitions defs) {
		List<String> dataStores = new ArrayList<String>();
		for (XMLElement dataStore : defs.getDataStores()) {
			dataStores.add(((DataStore) dataStore).getName());
		}
		return dataStores.toArray();
	}

	public static String getDataStoreId(Definitions defs, String label) {
		for (XMLElement dataStore : defs.getDataStores()) {
			if (((DataStore) dataStore).getName().equals(label)) {
				return ((DataStore) dataStore).getId();
			}
		}
		return "";
	}

	public static FlowNode getInitialFlowNode(Definitions defs) {
		FlowNode initial = null;
		for (BPMNProcess p : defs.getProcesses()) {
			for (XMLElement flowElement : p.getFlowElementList()) {
				if (flowElement instanceof FlowNode) {
					if (((FlowNode) flowElement).getIncomings().isEmpty()) {
						initial = (FlowNode) flowElement;
						break;
					}
				}
			}
		}
		return initial;
	}

	public static List<XMLElement> getAllConditionalSequenceFlows(Definitions defs) {
		List<XMLElement> sfList = new ArrayList<XMLElement>();
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, SequenceFlow.class));
		}
		for (XMLElement sf : flowElements) {
			if (!((SequenceFlow) sf).getConditionExpression().isEmpty()) {
				sfList.add(sf);
			}
		}
		return sfList;
	}

	public static List<XMLElement> getAllFlowElements(XMLElement element) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		Definitions defs = getDefinitions(element);
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, null));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllSubProcesses(XMLElement element) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		Definitions defs = getDefinitions(element);
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, SubProcess.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllEvents(XMLElement element) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		Definitions defs = getDefinitions(element);
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, Event.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllCallActivities(Definitions defs) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, CallActivity.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllEventGateways(Definitions defs) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, EventBasedGateway.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllBoundaryEvents(Definitions defs) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, BoundaryEvent.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllDataStoreRefs(XMLElement element) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		Definitions defs = getDefinitions(element);
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, DataStoreReference.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllDataObjectRefs(XMLElement element) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		Definitions defs = getDefinitions(element);
		for (XMLElement rootElement : defs.getRootElementList()) {
			flowElements.addAll(getFlowElements(rootElement, null, DataObjectReference.class));
		}
		return flowElements;
	}

	public static List<XMLElement> getAllProperties(Definitions defs) {
		List<XMLElement> propertyList = new ArrayList<XMLElement>();
		List<XMLElement> els = new ArrayList<XMLElement>();
		els.addAll(defs.getProcesses());
		for (BPMNProcess p : defs.getProcesses()) {
			els.addAll(getFlowElements(p, null, Event.class));
			els.addAll(getFlowElements(p, null, Activity.class));
		}
		for (XMLElement el : els) {
			Properties properties = (Properties) ((BaseElement) el).get("properties");
			if (properties != null) {
				propertyList.addAll(properties.getXMLElements());
			}
		}
		return propertyList;
	}

	public static List<XMLElement> getFlowElements(XMLElement element, String id, Class<?> type) {
		List<XMLElement> flowElements = new ArrayList<XMLElement>();
		if (element instanceof FlowElementsContainer) {
			for (XMLElement el : ((FlowElementsContainer) element).getFlowElements().getXMLElements()) {
				FlowElement flowElement = (FlowElement) el;
				if (id == null && type == null || type != null && type.isAssignableFrom(flowElement.getClass())
						|| flowElement.getCategoryValueRefSet().contains(id)) {
					flowElements.add(flowElement);
				}
				if (flowElement instanceof FlowElementsContainer) {
					flowElements.addAll(getFlowElements(flowElement, id, type));
				}
			}
		}
		return flowElements;
	}

	public static FlowElement getFlowElement(FlowElementsContainer container, String id) {
		FlowElement flowElement = container.getFlowElement(id);
		if (flowElement == null) {
			for (XMLElement el : container.getFlowNodes()) {
				if (el instanceof FlowElementsContainer) {
					flowElement = getFlowElement((FlowElementsContainer) el, id);
				}
			}
		}
		return flowElement;
	}

	public static StartEvent getStartEvent(FlowElementsContainer container) {
		for (FlowNode flowNode : container.getFlowNodes()) {
			if (flowNode instanceof StartEvent) {
				return (StartEvent) flowNode;
			}
		}
		return null;
	}

	public static List<XMLElement> getDataInOuts(XMLElement actOrEvent, String type) {
		if (actOrEvent instanceof Activity) {
			if ("selectDataInput".equals(type)) {
				return ((Activity) actOrEvent).getIoSpecification().getDataInputList();
			} else {
				return ((Activity) actOrEvent).getIoSpecification().getDataOutputList();
			}
		} else if (actOrEvent instanceof ThrowEvent) {
			return ((ThrowEvent) actOrEvent).getDataInputList();
		} else if (actOrEvent instanceof CatchEvent) {
			return ((CatchEvent) actOrEvent).getDataOutputList();
		} else {
			return new ArrayList<XMLElement>();
		}
	}

	public static int getEventDefinitionRefNumbers(XMLElement element, String ref) {
		int count = 0;
		for (XMLElement el : getAllEvents(element)) {
			if (((Event) el).hasEventDefinitionRef(ref)) {
				count++;
			}
		}
		return count;
	}

	public static ResourceParameter getResourceParameter(Definitions defs, String paramRef) {
		ResourceParameter param = null;
		for (XMLElement el : defs.getResources()) {
			param = ((Resource) el).getResourceParameter(paramRef);
			if (param != null) {
				return param;
			}
		}
		return param;
	}

	public static BaseElement getDefaultFlowElementsContainer(Definitions defs) {
		BaseElement container = getChoreography(defs);
		if (container == null) {
			container = getCollaboration(defs);
			if (container == null) {
				container = getDefaultProcess(defs);
			}
		}
		return container;
	}

	public static Artifacts getArtifacts(Definitions defs) {
		return getArtifacts(defs, true);
	}

	public static Artifacts getArtifacts(Definitions defs, boolean create) {
		Artifacts artifacts = null;
		Collaboration collaboration = getCollaboration(defs);
		Choreography choreography = getChoreography(defs);
		BPMNProcess process = getDefaultProcess(defs);
		if (collaboration != null) {
			artifacts = collaboration.getArtifacts();
		} else if (choreography != null) {
			artifacts = choreography.getArtifacts();
		} else if (process != null) {
			artifacts = process.getArtifacts();
		} else if (create) {
			process = defs.createProcess(true);
			artifacts = process.getArtifacts();
		}
		return artifacts;
	}

	public static Collaboration getCollaboration(Definitions defs) {
		for (XMLElement root : defs.getRootElementList()) {
			if (root instanceof Collaboration && !(root instanceof Choreography)) {
				return (Collaboration) root;
			}
		}
		return null;
	}

	public static Choreography getChoreography(Definitions defs) {
		for (XMLElement root : defs.getRootElementList()) {
			if (root instanceof Choreography) {
				return (Choreography) root;
			}
		}
		return null;
	}

	public static Choreography getParentChoreography(XMLElement el) {
		if (el == null)
			return null;
		while (!(el instanceof Choreography)) {
			el = el.getParent();
			if (el == null)
				break;
		}
		return (Choreography) el;
	}

	public static List<XMLElement> getAllNoneEmptyProcesses(Definitions defs) {
		List<XMLElement> processes = new ArrayList<XMLElement>();
		for (XMLElement root : defs.getRootElementList()) {
			if (root instanceof BPMNProcess && !((BPMNProcess) root).isEmptyProcess()) {
				processes.add(root);
			}
		}
		return processes;
	}

	public static BPMNProcess getDefaultProcess(Definitions defs) {
		for (XMLElement root : defs.getRootElementList()) {
			if (root instanceof BPMNProcess) {
				Participant participant = getParticipantByProcessId(((BPMNProcess) root).getId(), defs);
				if (participant == null && !hasProcessRef(defs, ((BPMNProcess) root).getId())) {
					return (BPMNProcess) root;
				}
			}
		}
		return null;
	}

	public static BPMNProcess getParentProcess(XMLElement el) {
		if (el == null)
			return null;
		while (!(el instanceof BPMNProcess)) {
			el = el.getParent();
			if (el == null)
				break;
		}
		return (BPMNProcess) el;
	}

	public static FlowElementsContainer getParentFlowElementsContainer(XMLElement el) {
		if (el == null)
			return null;
		if (el instanceof FlowElementsContainer) {
			el = el.getParent();
		}
		while (!(el instanceof FlowElementsContainer)) {
			el = el.getParent();
			if (el == null)
				break;
		}
		return (FlowElementsContainer) el;
	}

	public static Participant getParticipantByProcessId(String processId, Definitions defs) {
		for (XMLElement root : defs.getRootElementList()) {
			if (root instanceof Collaboration) {
				for (XMLElement part : ((Collaboration) root).getParticipantList()) {
					String processRef = ((Participant) part).getProcessRef();
					if (processRef == null || processRef.length() == 0) {
						continue;
					}
					int index = processRef.indexOf(":");
					if (index > 0) {
						processRef = processRef.substring(index + 1);
					}
					if (processRef.equals(processId)) {
						return (Participant) part;
					}
				}
			}
		}
		return null;
	}

	public static boolean hasMessageFlowRef(FlowElementsContainer container, String messageFlowId) {
		boolean has = false;
		for (XMLElement flowElement : container.getFlowElements().getXMLElements()) {
			if (flowElement instanceof ChoreographyTask) {
				for (XMLElement mfRef : ((ChoreographyTask) flowElement).getMessageFlowRefList()) {
					if (messageFlowId.equals(mfRef.toValue())) {
						return true;
					}
				}
			} else if (flowElement instanceof SubChoreography) {
				has = hasMessageFlowRef((SubChoreography) flowElement, messageFlowId);
			}
		}
		return has;
	}

	public static boolean hasChoreographyActivity(Definitions defs) {
		Choreography choreography = BPMNModelUtils.getChoreography(defs);
		if (choreography == null) {
			return false;
		}
		for (XMLElement flowElement : choreography.getFlowElementList()) {
			if (flowElement instanceof ChoreographyActivity) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasParticipantRef(XMLElement owner, String participantId) {
		Choreography choreography = BPMNModelUtils.getChoreography(BPMNModelUtils.getDefinitions(owner));
		if (choreography == null) {
			return false;
		}
		Set<ChoreographyActivity> acts = getChoreographyActivityByParticipantRef(choreography, participantId);
		acts.remove(owner);
		if (acts.size() > 0) {
			return true;
		}
		return false;
	}

	public static boolean hasProcessRef(Definitions defs, String id) {
		boolean has = false;
		for (XMLElement el : getAllNoneEmptyProcesses(defs)) {
			has = hasProcessRef((FlowElementsContainer) el, id);
		}
		return has;
	}

	public static boolean hasProcessRef(FlowElementsContainer container, String id) {
		boolean has = false;
		for (XMLElement f : container.getFlowElements().getXMLElements()) {
			if (f instanceof CallActivity) {
				if (((CallActivity) f).getCalledElement().equals(id)) {
					return true;
				}
			} else if (f instanceof SubProcess) {
				has = hasProcessRef((FlowElementsContainer) f, id);
			}
		}
		return has;
	}

	public static Set<ChoreographyActivity> getChoreographyActivityByParticipantRef(Definitions defs, String participantId) {
		Set<ChoreographyActivity> acts = new HashSet<ChoreographyActivity>();
		Choreography choreography = BPMNModelUtils.getChoreography(defs);
		if (choreography == null) {
			return acts;
		}
		acts.addAll(getChoreographyActivityByParticipantRef(choreography, participantId));

		return acts;
	}

	public static Set<ChoreographyActivity> getChoreographyActivityByParticipantRef(FlowElementsContainer container, String participantId) {
		Set<ChoreographyActivity> acts = new HashSet<ChoreographyActivity>();
		for (XMLElement flowElement : container.getFlowElements().getXMLElements()) {
			if (flowElement instanceof ChoreographyTask) {
				for (String participant : ((ChoreographyTask) flowElement).getParticipantList()) {
					if (participantId.equals(participant)) {
						acts.add((ChoreographyTask) flowElement);
					}
				}
			} else if (flowElement instanceof SubChoreography) {
				for (String participant : ((SubChoreography) flowElement).getParticipantList()) {
					if (participantId.equals(participant)) {
						acts.add((SubChoreography) flowElement);
					}
				}
				acts.addAll(getChoreographyActivityByParticipantRef((SubChoreography) flowElement, participantId));
			}
		}
		return acts;
	}

	public static List<XMLElement> getLanes(LaneSet laneSet) {
		List<XMLElement> lanes = new ArrayList<XMLElement>();
		if (laneSet == null) {
			return lanes;
		}

		for (XMLElement lane : laneSet.getLaneList()) {
			LaneSet childLaneSet = ((Lane) lane).getChildLaneSet();
			if (childLaneSet.getLaneList().size() == 0) {
				lanes.add(lane);
			} else {
				lanes.add(lane);
				lanes.addAll(getLanes(((Lane) lane).getChildLaneSet()));
			}
		}
		return lanes;
	}

	public static Set<String> getFlowNodeRefs(Lane lane) {
		Set<String> refs = new HashSet<String>();
		refs.addAll(lane.getFlowNodeRefs());
		LaneSet childLaneSet = lane.getChildLaneSet();
		for (XMLElement childLane : childLaneSet.getLaneList()) {
			refs.addAll(getFlowNodeRefs((Lane) childLane));
		}
		return refs;
	}

	public static void removeEmptyProcess(Definitions definitions, XMLElement bpmnElement) {
		BPMNProcess process = getParentProcess(bpmnElement);
		if (process != null && process.isEmptyProcess() && !hasProcessRef(definitions, process.getId())) {
			((XMLCollectionElement) process.getParent()).remove(process.getId());
			Participant participant = getParticipantByProcessId(process.getId(), definitions);
			if (participant != null) {
				participant.setProcessRef("");
			}
		}
		Collaboration collaboration = BPMNModelUtils.getCollaboration(definitions);
		if (collaboration != null && collaboration.isEmpty()) {
			((XMLCollectionElement) collaboration.getParent()).remove(collaboration.getId());
		}
	}

	public static void generateBPMNDI(Definitions definitions, Collaboration collaboration, Map<String, XMLElement> bpmnElementMap, List<XMLElement> shapes,
			List<XMLElement> edges) {
		int num = 2;
		int count = 0;
		for (XMLElement e : collaboration.getParticipantList()) {
			BaseElement element = (BaseElement) e;
			if (element instanceof Participant) {
				String id = element.getId();
				if (id.length() == 0) {
					id = "_" + num;
					while (bpmnElementMap.containsKey(id)) {
						id = "_" + ++num;
					}
					element.setId(id);
					bpmnElementMap.put(id, element);
				}
				BPMNShape shape = new BPMNShape(null);
				shape.setBpmnElement(id);
				shape.setHorizontal(true);
				shape.getBounds().setX(0);
				shape.getBounds().setY(count++ * 250);
				shape.getBounds().setHeight(200);
				BPMNProcess process = definitions.getProcess(((Participant) element).getProcessRef());
				if (process != null) {
					generateBPMNDI(process, bpmnElementMap, shapes, edges);
				}
				shapes.add(0, shape);
			}
		}

		for (XMLElement e : collaboration.getMessageFlowList()) {
			BaseElement element = (BaseElement) e;
			if (element instanceof MessageFlow) {
				String id = element.getId();
				if (id.length() == 0) {
					id = "_" + num;
					while (bpmnElementMap.containsKey(id)) {
						id = "_" + ++num;
					}
					element.setId(id);
					bpmnElementMap.put(id, element);
				}
				BPMNEdge edge = new BPMNEdge(null);
				edge.setBpmnElement(id);
				edges.add(edge);
			}
		}
	}

	public static void generateBPMNDI(FlowElementsContainer container, Map<String, XMLElement> bpmnElementMap, List<XMLElement> shapes, List<XMLElement> edges) {
		int num = 2;
		List<XMLElement> laneShapes = new ArrayList<XMLElement>();
		List<XMLElement> elements = new ArrayList<XMLElement>();
		elements.addAll(container.getFlowElements().getXMLElements());
		elements.addAll(container.getArtifacts().getXMLElements());
		if (container instanceof BPMNProcess) {
			elements.addAll(((BPMNProcess) container).getLanes());
		}
		for (XMLElement e : elements) {
			BaseElement element = (BaseElement) e;
			if (element instanceof FlowElementsContainer) {
				generateBPMNDI((FlowElementsContainer) element, bpmnElementMap, shapes, edges);
			}
			String id = element.getId();
			if (id.length() == 0) {
				id = "_" + num;
				while (bpmnElementMap.containsKey(id)) {
					id = "_" + ++num;
				}
				element.setId(id);
				bpmnElementMap.put(id, element);
			}
			if (element instanceof SequenceFlow || element instanceof Association) {
				BPMNEdge edge = new BPMNEdge(null);
				edge.setBpmnElement(id);
				edges.add(edge);
			} else if (!(element instanceof DataObject)) {
				BPMNShape shape = new BPMNShape(null);
				shape.setBpmnElement(id);
				if (element instanceof Lane) {
					shape.setHorizontal(true);
					shape.getBounds().setHeight(200);
				}
				if (element instanceof BoundaryEvent) {
					shapes.add(shape);
				} else if (element instanceof Lane) {
					laneShapes.add(0, shape);
				} else {
					shapes.add(0, shape);
				}
			}
		}
		for (XMLElement shape : laneShapes) {
			shapes.add(0, shape);
		}
	}

}

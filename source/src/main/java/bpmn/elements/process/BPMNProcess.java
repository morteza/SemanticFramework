package org.yaoqiang.model.bpmn.elements.process;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.artifacts.Artifacts;
import org.yaoqiang.model.bpmn.elements.core.common.CallableElement;
import org.yaoqiang.model.bpmn.elements.core.common.CorrelationSubscriptions;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElementsContainer;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;
import org.yaoqiang.model.bpmn.elements.process.activities.ResourceRoles;
import org.yaoqiang.model.bpmn.elements.process.data.Properties;

/**
 * BPMNProcess
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNProcess extends CallableElement implements FlowElementsContainer {

	private static final long serialVersionUID = -8015487087996076750L;

	public class Type {
		public static final String NONE = "None";
		public static final String PRIVATE = "Private";
		public static final String PUBLIC = "Public";
	}

	public BPMNProcess(XMLElement parent) {
		super(parent, "process");
	}

	protected void fillStructure() {
		XMLAttribute attrProcessType = new XMLAttribute(this, "processType", Type.NONE);
		XMLAttribute attrIsClosed = new XMLAttribute(this, "isClosed", Boolean.FALSE.toString());
		XMLAttribute attrIsExecutable = new XMLAttribute(this, "isExecutable");
		XMLAttribute attrDefinitionalCollaborationRef = new XMLAttribute(this, "definitionalCollaborationRef");
		Auditing refAuditing = new Auditing(this);
		Monitoring refMonitoring = new Monitoring(this);
		Properties refProperties = new Properties(this);
		LaneSets refLaneSets = new LaneSets(this);
		FlowElements refFlowElements = new FlowElements(this);
		Artifacts refArtifacts = new Artifacts(this);
		ResourceRoles refResourceRoles = new ResourceRoles(this);
		CorrelationSubscriptions refCorrelationSubscriptions = new CorrelationSubscriptions(this);
		XMLTextElements refSupports = new XMLTextElements(this, "supports");

		super.fillStructure();
		add(attrProcessType);
		add(attrIsClosed);
		add(attrIsExecutable);
		add(attrDefinitionalCollaborationRef);
		add(refAuditing);
		add(refMonitoring);
		add(refProperties);
		add(refLaneSets);
		add(refFlowElements);
		add(refArtifacts);
		add(refResourceRoles);
		add(refCorrelationSubscriptions);
		add(refSupports);
	}

	public final String getProcessType() {
		return get("processType").toValue();
	}

	public final boolean isExecutable() {
		return Boolean.parseBoolean(get("isExecutable").toValue());
	}

	public final boolean isClosed() {
		return Boolean.parseBoolean(get("isClosed").toValue());
	}

	public final List<XMLElement> getLanes() {
		List<XMLElement> lanes = new ArrayList<XMLElement>();
		for (XMLElement laneSet : ((LaneSets) get("laneSets")).getXMLElements()) {
			lanes.addAll(BPMNModelUtils.getLanes((LaneSet) laneSet));
		}
		return lanes;
	}

	public final LaneSets getLaneSets() {
		return (LaneSets) get("laneSets");
	}

	public final void removeFlowElement(String id) {
		getFlowElements().remove(id);
	}

	public final FlowElement getFlowElement(String id) {
		return (FlowElement) getFlowElements().getCollectionElement(id);
	}

	public final List<XMLElement> getFlowElementList() {
		return getFlowElements().getXMLElements();
	}

	public final FlowElements getFlowElements() {
		return (FlowElements) get("flowElements");
	}

	public final List<FlowNode> getFlowNodes() {
		List<FlowNode> flowNodes = new ArrayList<FlowNode>();
		for (XMLElement flowElement : getFlowElementList()) {
			if (flowElement instanceof FlowNode) {
				flowNodes.add((FlowNode) flowElement);
			}
		}
		return flowNodes;
	}

	public final List<FlowNode> getStartingFlowNodes() {
		List<FlowNode> flowNodes = new ArrayList<FlowNode>();
		for (FlowNode flowNode : getFlowNodes()) {
			if (flowNode.getIncomingSequenceFlows().isEmpty() && !(flowNode instanceof BoundaryEvent)) {
				flowNodes.add(flowNode);
			}
		}
		return flowNodes;
	}

	public final List<SequenceFlow> getSequenceFlows() {
		List<SequenceFlow> sequenceFlows = new ArrayList<SequenceFlow>();
		for (XMLElement flowElement : getFlowElementList()) {
			if (flowElement instanceof SequenceFlow) {
				sequenceFlows.add((SequenceFlow) flowElement);
			}
		}
		return sequenceFlows;
	}

	public final Artifacts getArtifacts() {
		return (Artifacts) get("artifacts");
	}

	public final Properties getProperties() {
		return (Properties) get("properties");
	}

	public List<XMLElement> getAccessibleProperties() {
		List<XMLElement> properties = getProperties().getXMLElements();
		return properties;
	}

	public final ResourceRoles getResourceRoles() {
		return (ResourceRoles) get("resources");
	}

	public final Properties setProperties(Properties properties) {
		getProperties().clear();
		getProperties().addAll(properties.getXMLElements());
		return properties;
	}

	public boolean isEmptyProcess() {
		boolean isEmpty = true;
		for (XMLElement el : getXMLElements()) {
			isEmpty = isEmpty && el.isEmpty();
		}
		return isEmpty;
	}

	public final void setProcessType(String processType) {
		set("processType", processType);
	}

	public final void setIsExecutable(boolean isExecutable) {
		set("isExecutable", String.valueOf(isExecutable));
	}

	public final void setIsClosed(boolean isClosed) {
		set("isClosed", String.valueOf(isClosed));
	}

	public final void addLane(Lane lane) {
		LaneSet laneSet = null;
		if (getLaneSets().size() == 0) {
			laneSet = (LaneSet) getLaneSets().generateNewElement();
			getLaneSets().add(laneSet);
		} else {
			laneSet = (LaneSet) getLaneSets().getXMLElements().get(0);
		}
		laneSet.addLane(lane);
	}

	public final Lane addLane(String id, String name) {
		LaneSet laneSet = null;
		if (getLaneSets().size() == 0) {
			laneSet = (LaneSet) getLaneSets().generateNewElement();
			getLaneSets().add(laneSet);
		} else {
			laneSet = (LaneSet) getLaneSets().getXMLElements().get(0);
		}
		return laneSet.addLane(id, name);
	}

	public final XMLElement generateFlowElement(String type) {
		return getFlowElements().generateFlowElement(type);
	}

	public final void addFlowElement(XMLElement el) {
		getFlowElements().add(el);
	}

	public final void addFlowElements(FlowElements flowElements) {
		for (XMLElement flowElement : flowElements.getXMLElements()) {
			getFlowElements().add(flowElement);
		}
		flowElements.clear();
	}

	public final void addArtifacts(Artifacts artifacts) {
		for (XMLElement arti : artifacts.getXMLElements()) {
			getArtifacts().add(arti);
		}
		artifacts.clear();
	}

	public final void addArtifact(XMLElement artifact) {
		getArtifacts().add(artifact);
	}

}

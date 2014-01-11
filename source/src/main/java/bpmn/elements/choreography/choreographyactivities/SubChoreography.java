package org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.artifacts.Artifacts;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElementsContainer;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;

/**
 * SubChoreography
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class SubChoreography extends ChoreographyActivity implements FlowElementsContainer {

	private static final long serialVersionUID = 6596126698962015470L;

	public SubChoreography(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public SubChoreography(FlowElements parent) {
		super(parent, "subChoreography");
	}

	protected void fillStructure() {
		FlowElements refFlowElements = new FlowElements(this);
		Artifacts refArtifacts = new Artifacts(this);
		
		super.fillStructure();
		add(refFlowElements);
		add(refArtifacts);
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
	
	public final XMLElement generateFlowElement(String type) {
		FlowElements flowElements = getFlowElements();
		flowElements.setType(type);
		XMLElement el = flowElements.generateNewElement();
		return el;
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

	public final void addFlowElement(XMLElement el) {
		getFlowElements().add(el);
	}
	
}

package org.yaoqiang.model.bpmn.elements.choreography;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.collaboration.Collaboration;
import org.yaoqiang.model.bpmn.elements.collaboration.MessageFlow;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElementsContainer;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;

/**
 * Choreography
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Choreography extends Collaboration implements FlowElementsContainer {

	private static final long serialVersionUID = 7397036700528113962L;

	public Choreography(RootElements parent) {
		super(parent, "choreography");
		super.remove("choreographyRef");
	}

	public Choreography(RootElements parent, String name) {
		super(parent, name);
		super.remove("choreographyRef");
	}

	protected void fillStructure() {
		FlowElements refFlowElements = new FlowElements(this);

		super.fillStructure();
		add(refFlowElements);
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

	public final XMLElement generateFlowElement(String type) {
		FlowElements flowElements = getFlowElements();
		flowElements.setType(type);
		XMLElement el = flowElements.generateNewElement();
		return el;
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

	public final void removeUnusedMessageFlows() {
		for (XMLElement mf : getMessageFlowList()) {
			MessageFlow messageFlow = (MessageFlow) mf;
			if (!getParticipants().contains(messageFlow.getSourceRef()) || !getParticipants().contains(messageFlow.getTargetRef())) {
				getMessageFlows().remove(messageFlow.getId());
			}
		}
	}

}

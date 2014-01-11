package org.yaoqiang.model.bpmn.elements.process.activities;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.artifacts.Artifacts;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElementsContainer;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;
import org.yaoqiang.model.bpmn.elements.events.BoundaryEvent;
import org.yaoqiang.model.bpmn.elements.events.CompensateEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.StartEvent;
import org.yaoqiang.model.bpmn.elements.process.LaneSets;

/**
 * SubProcess
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class SubProcess extends Activity implements FlowElementsContainer {

	private static final long serialVersionUID = -1614514029751956052L;

	public SubProcess(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public SubProcess(String name, boolean triggeredByEvent) {
		this((FlowElements) null);
		setName(name);
		setTriggeredByEvent(triggeredByEvent);
	}

	public SubProcess(FlowElements parent) {
		super(parent, "subProcess");
	}

	public SubProcess(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrTriggeredByEvent = new XMLAttribute(this, "triggeredByEvent", Boolean.FALSE.toString());
		LaneSets refLaneSets = new LaneSets(this);
		FlowElements refFlowElements = new FlowElements(this);
		Artifacts refArtifacts = new Artifacts(this);

		super.fillStructure();
		add(attrTriggeredByEvent);
		add(refLaneSets);
		add(refFlowElements);
		add(refArtifacts);
	}

	public final boolean isTriggeredByEvent() {
		return Boolean.parseBoolean(get("triggeredByEvent").toValue());
	}

	public final FlowElement getFlowElement(String id) {
		return (FlowElement) getFlowElements().getFlowElement(id);
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

	public boolean hasCompensationEventSubProcess() {
		for (XMLElement el : getFlowElementList()) {
			if (el instanceof SubProcess && ((SubProcess) el).isTriggeredByEvent()) {
				for (XMLElement e : ((SubProcess) el).getFlowElementList()) {
					if (e instanceof StartEvent && ((StartEvent) e).getEventDefinition() instanceof CompensateEventDefinition) {
						return true;
					}
				}
			}
		}
		return false;
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

	public final void setTriggeredByEvent(boolean triggeredByEvent) {
		set("triggeredByEvent", String.valueOf(triggeredByEvent));
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

	public final void addArtifact(XMLElement artifact) {
		getArtifacts().add(artifact);
	}

}

package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.activities.SubProcess;

/**
 * SequenceFlow
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class SequenceFlow extends FlowElement {

	private static final long serialVersionUID = -5376896158928448255L;

	public SequenceFlow(FlowElements parent) {
		super(parent, "sequenceFlow");
	}

	protected void fillStructure() {
		XMLAttribute attrSourceRef = new XMLAttribute(this, "sourceRef");
		XMLAttribute attrTargetRef = new XMLAttribute(this, "targetRef");
		XMLAttribute attrIsImmediate = new XMLAttribute(this, "isImmediate");
		Expression refConditionExpression = new Expression(this, "conditionExpression");

		super.fillStructure();
		add(attrSourceRef);
		add(attrTargetRef);
		add(attrIsImmediate);
		add(refConditionExpression);
	}

	public List<XMLElement> getAccessibleProperties() {
		List<XMLElement> properties = new ArrayList<XMLElement>();
		if (getParent().getParent() instanceof SubProcess) {
			properties.addAll(((SubProcess) getParent().getParent()).getAccessibleProperties());
		} else if (getParent().getParent() instanceof BPMNProcess) {
			properties.addAll(((BPMNProcess) getParent().getParent()).getAccessibleProperties());
		}
		return properties;
	}

	public final FlowNode getSourceFlowNode() {
		return (FlowNode) getParent().getFlowElement(get("sourceRef").toValue());
	}

	public final FlowNode getTargetFlowNode() {
		return (FlowNode) getParent().getFlowElement(get("targetRef").toValue());
	}

	public final String getSourceRef() {
		return get("sourceRef").toValue();
	}

	public final String getTargetRef() {
		return get("targetRef").toValue();
	}

	public final void setSourceRef(String sourceRef) {
		set("sourceRef", sourceRef);
	}

	public final void setTargetRef(String targetRef) {
		set("targetRef", targetRef);
	}

	public final Expression getConditionExpression() {
		return (Expression) get("conditionExpression");
	}

	public final void setConditionExpression(String expression) {
		getConditionExpression().setValue(expression);
	}

	public String toString() {
		return "[" + getSourceFlowNode() + " --> " + getTargetFlowNode() + "]";
	}
}

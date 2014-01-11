package org.yaoqiang.model.bpmn.elements.gateways;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;

/**
 * ComplexGateway
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ComplexGateway extends Gateway {

	private static final long serialVersionUID = -2515624868807369812L;

	public ComplexGateway(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ComplexGateway(FlowElements parent) {
		super(parent, "complexGateway");
	}

	protected void fillStructure() {
		XMLAttribute attrDefault = new XMLAttribute(this, "default");
		Expression refActivationCondition = new Expression(this, "activationCondition");

		super.fillStructure();
		add(attrDefault);
		add(refActivationCondition);
	}

	public SequenceFlow getDefaultSequenceFlow() {
		return (SequenceFlow) getParent().getFlowElement(get("default").toValue());
	}

}

package org.yaoqiang.model.bpmn.elements.gateways;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;

/**
 * ExclusiveGateway
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExclusiveGateway extends Gateway {

	private static final long serialVersionUID = 4156339722251011079L;

	public ExclusiveGateway(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ExclusiveGateway(FlowElements parent) {
		super(parent, "exclusiveGateway");
		setGatewayDirection(Gateway.Direction.DIVERGING);
	}

	protected void fillStructure() {
		XMLAttribute attrDefault = new XMLAttribute(this, "default");

		super.fillStructure();
		add(attrDefault);
	}

	public final String getDefault() {
		return get("default").toValue();
	}

	public final void setDefault(String _default) {
		set("default", _default);
	}

	public SequenceFlow getDefaultSequenceFlow() {
		return (SequenceFlow) getParent().getFlowElement(get("default").toValue());
	}
}

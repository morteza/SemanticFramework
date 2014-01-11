package org.yaoqiang.model.bpmn.elements.gateways;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.SequenceFlow;

/**
 * InclusiveGateway
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class InclusiveGateway extends Gateway {

	private static final long serialVersionUID = -1394446186915533089L;

	public InclusiveGateway(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public InclusiveGateway(FlowElements parent) {
		super(parent, "inclusiveGateway");
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
		return (SequenceFlow) getParent().getFlowElement(getDefault());
	}

}

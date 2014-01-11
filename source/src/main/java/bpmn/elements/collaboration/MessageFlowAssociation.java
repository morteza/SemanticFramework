package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * MessageFlowAssociation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class MessageFlowAssociation extends BaseElement {

	private static final long serialVersionUID = 2934306729168807597L;

	public MessageFlowAssociation(MessageFlowAssociations parent) {
		super(parent, "messageFlowAssociation");
	}

	protected void fillStructure() {
		XMLAttribute attrInnerMessageFlowRef = new XMLAttribute(this, "innerMessageFlowRef");
		XMLAttribute attrOuterMessageFlowRef = new XMLAttribute(this, "outerMessageFlowRef");

		super.fillStructure();
		add(attrInnerMessageFlowRef);
		add(attrOuterMessageFlowRef);
	}

	public MessageFlowAssociations getParent() {
		return (MessageFlowAssociations) parent;
	}

}

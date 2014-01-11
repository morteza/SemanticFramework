package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.collaboration.ConversationAssociations;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ConversationAssociation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ConversationAssociation extends BaseElement {

	private static final long serialVersionUID = -2866143466130693676L;

	public ConversationAssociation(ConversationAssociations parent) {
		super(parent, "conversationAssociation");
	}

	protected void fillStructure() {
		XMLTextElement attrInnerConversationNodeRef = new XMLTextElement(this, "innerConversationNodeRef");

		XMLTextElements attrOuterConversationNodeRef = new XMLTextElements(this, "outerConversationNodeRef");

		super.fillStructure();
		add(attrInnerConversationNodeRef);
		add(attrOuterConversationNodeRef);
	}

	public ConversationAssociations getParent() {
		return (ConversationAssociations) parent;
	}

}

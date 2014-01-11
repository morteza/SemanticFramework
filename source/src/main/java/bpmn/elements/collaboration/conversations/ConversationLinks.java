package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.collaboration.Collaboration;

/**
 * ConversationLinks
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ConversationLinks extends XMLCollectionElement {

	private static final long serialVersionUID = 3089575188883969344L;

	public ConversationLinks(Collaboration parent) {
		super(parent, "conversationLinks");
	}

	public XMLElement generateNewElement() {
		return new ConversationLink(this);
	}

	public String getElementName() {
		return "conversationLink";
	}
	
}

package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.collaboration.conversations.ConversationAssociation;

/**
 * ConversationAssociations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ConversationAssociations extends XMLCollectionElement {

	private static final long serialVersionUID = 9078058072019386906L;

	public ConversationAssociations(Collaboration parent) {
		super(parent, "conversationAssociations");
	}

	public XMLElement generateNewElement() {
		return new ConversationAssociation(this);
	}

	public String getElementName() {
		return "conversationAssociation";
	}
	
}

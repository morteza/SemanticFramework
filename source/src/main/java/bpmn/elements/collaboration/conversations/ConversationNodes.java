package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;

/**
 * Conversations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ConversationNodes extends XMLFactoryElement {

	private static final long serialVersionUID = -508174063359255374L;
	
	public static final String TYPE_CONVERSATION = "conversation";
	public static final String TYPE_CALL_CONVERSATION = "callConversation";
	public static final String TYPE_SUBCONVERSATION = "subConversation";
	
	public ConversationNodes(XMLElement parent) {
		super(parent, "conversationNodes");
	}

	public XMLElement generateNewElement() {
		if (type.equals(TYPE_CONVERSATION)) {
			return new Conversation(this);
		} else if (type.equals(TYPE_CALL_CONVERSATION)) {
			return new CallConversation(this);
		} else if (type.equals(TYPE_SUBCONVERSATION)) {
			return new SubConversation(this);
		}
		return null;
	}
	
}

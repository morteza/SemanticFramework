package org.yaoqiang.model.bpmn.elements.collaboration.conversations;



/**
 * Conversation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Conversation extends ConversationNode {

	private static final long serialVersionUID = -7453696080399715416L;

	public Conversation(String name) {
		this((ConversationNodes) null);
		setName(name);
	}
	
	public Conversation(ConversationNodes parent) {
		super(parent, "conversation");
	}

}

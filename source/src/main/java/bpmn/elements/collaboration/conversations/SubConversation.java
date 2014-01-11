package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

/**
 * SubConversation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class SubConversation extends ConversationNode {

	private static final long serialVersionUID = 7378514988678723317L;

	public SubConversation(String name) {
		this((ConversationNodes) null);
		setName(name);
	}

	public SubConversation(ConversationNodes parent) {
		super(parent, "subConversation");
	}

	protected void fillStructure() {
		ConversationNodes refConversationNodes = new ConversationNodes(this);

		super.fillStructure();
		add(refConversationNodes);
	}

}

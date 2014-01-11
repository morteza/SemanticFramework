package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.collaboration.ParticipantAssociations;

/**
 * CallConversation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CallConversation extends ConversationNode {

	private static final long serialVersionUID = -3412118398812145631L;

	public CallConversation(String name) {
		this((ConversationNodes) null);
		setName(name);
	}

	public CallConversation(ConversationNodes parent) {
		super(parent, "callConversation");
	}

	protected void fillStructure() {
		XMLAttribute attrCalledCollaboratioinRef = new XMLAttribute(this, "calledCollaboratioinRef");
		ParticipantAssociations refParticipantAssociations = new ParticipantAssociations(this);

		super.fillStructure();
		add(attrCalledCollaboratioinRef);
		add(refParticipantAssociations);
	}

	public final String getCalledCollaboratioinRef() {
		return get("calledCollaboratioinRef").toValue();
	}
}

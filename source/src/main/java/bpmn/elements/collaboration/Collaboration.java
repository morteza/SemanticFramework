package org.yaoqiang.model.bpmn.elements.collaboration;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.artifacts.Artifacts;
import org.yaoqiang.model.bpmn.elements.collaboration.conversations.ConversationLink;
import org.yaoqiang.model.bpmn.elements.collaboration.conversations.ConversationLinks;
import org.yaoqiang.model.bpmn.elements.collaboration.conversations.ConversationNode;
import org.yaoqiang.model.bpmn.elements.collaboration.conversations.ConversationNodes;
import org.yaoqiang.model.bpmn.elements.core.common.CorrelationKeys;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Collaboration
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Collaboration extends BaseElement implements RootElement {

	private static final long serialVersionUID = -5977637447958690788L;

	public Collaboration(RootElements parent) {
		super(parent, "collaboration");
	}

	public Collaboration(RootElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrIsClosed = new XMLAttribute(this, "isClosed", Boolean.FALSE.toString());
		Participants refParticipants = new Participants(this);
		MessageFlows refMessageFlows = new MessageFlows(this);
		Artifacts refArtifacts = new Artifacts(this);
		ConversationNodes refConversations = new ConversationNodes(this);
		ConversationAssociations refConversationAssociations = new ConversationAssociations(this);
		ParticipantAssociations refParticipantAssociations = new ParticipantAssociations(this);
		MessageFlowAssociations refMessageFlowAssociations = new MessageFlowAssociations(this);
		CorrelationKeys refCorrelationKeys = new CorrelationKeys(this);
		XMLTextElements refChoreographyRef = new XMLTextElements(this, "choreographyRef");
		ConversationLinks refConversationLinks = new ConversationLinks(this);

		super.fillStructure();
		add(attrName);
		add(attrIsClosed);
		add(refParticipants);
		add(refMessageFlows);
		add(refArtifacts);
		add(refConversations);
		add(refConversationAssociations);
		add(refParticipantAssociations);
		add(refMessageFlowAssociations);
		add(refCorrelationKeys);
		add(refChoreographyRef);
		add(refConversationLinks);
	}

	public final Participants getParticipants() {
		return (Participants) get("participants");
	}
	
	public final List<XMLElement> getParticipantList() {
		return getParticipants().getXMLElements();
	}
	
	public final MessageFlows getMessageFlows() {
		return (MessageFlows) get("messageFlows");
	}

	public final List<XMLElement> getMessageFlowList() {
		return getMessageFlows().getXMLElements();
	}
	
	public final Artifacts getArtifacts() {
		return (Artifacts) get("artifacts");
	}

	public final ConversationNodes getConversationNodes() {
		return (ConversationNodes) get("conversationNodes");
	}
	
	public final ConversationLinks getConversationLinks() {
		return (ConversationLinks) get("conversationLinks");
	}
	
	public final Participant addParticipant(String id, String name) {
		Participant participant = (Participant) getParticipants().getCollectionElement(id);
		if (participant != null) {
			return participant;
		}
		participant = (Participant) getParticipants().generateNewElement();
		participant.setId(id);
		participant.setName(name);
		getParticipants().add(participant);
		return participant;
	}
	
	public final void addParticipant(Participant participant) {
		getParticipants().add(participant);
	}

	public final void removeParticipant(String partId) {
		getParticipants().remove(partId);
	}

	public final MessageFlow addMessageFlow(String id, String sourceRef, String targetRef) {
		MessageFlow messageFlow = (MessageFlow) getMessageFlows().generateNewElement();
		messageFlow.setId(id);
		messageFlow.setSourceRef(sourceRef);
		messageFlow.setTargetRef(targetRef);
		getMessageFlows().add(messageFlow);
		return messageFlow;
	}
	
	public final ConversationNode addConversationNode(String type, String id, String name) {
		getConversationNodes().setType(type);
		ConversationNode conversationNode = (ConversationNode) getConversationNodes().generateNewElement();
		conversationNode.setId(id);
		conversationNode.setName(name);
		getConversationNodes().add(conversationNode);
		return conversationNode;
	}

	public final void addConversationNode(ConversationNode conversationNode) {
		getConversationNodes().add(conversationNode);
	}
	
	public final ConversationLink addConversationLink(String id, String sourceRef, String targetRef) {
		ConversationLink conversationLink = (ConversationLink) getConversationLinks().generateNewElement();
		conversationLink.setId(id);
		conversationLink.setSourceRef(sourceRef);
		conversationLink.setTargetRef(targetRef);
		getConversationLinks().add(conversationLink);
		return conversationLink;
	}
	
	public final void addArtifacts(Artifacts artifacts) {
		for(XMLElement arti: artifacts.getXMLElements()) {
			getArtifacts().add(arti);
		}
		artifacts.clear();
	}
	
	public final void addArtifact(XMLElement artifact) {
		getArtifacts().add(artifact);
	}

	public boolean isEmpty() {
		boolean isEmpty = true;
		for(XMLElement el: getXMLElements()) {
			if (el instanceof Artifacts) {
				continue;
			}
			isEmpty = isEmpty && el.isEmpty();
		}
		return isEmpty;
	}
}

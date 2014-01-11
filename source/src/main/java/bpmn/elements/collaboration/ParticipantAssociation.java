package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ParticipantAssociation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ParticipantAssociation extends BaseElement {

	private static final long serialVersionUID = 6361001200953393791L;

	public ParticipantAssociation(ParticipantAssociations parent) {
		super(parent, "participantAssociation");
	}

	protected void fillStructure() {
		XMLTextElement attrInnerParticipantRef = new XMLTextElement(this, "innerParticipantRef");
		XMLTextElement attrOuterParticipantRef = new XMLTextElement(this, "outerParticipantRef");

		super.fillStructure();
		add(attrInnerParticipantRef);
		add(attrOuterParticipantRef);
	}

	public ParticipantAssociations getParent() {
		return (ParticipantAssociations) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ParticipantAssociations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ParticipantAssociations extends XMLCollectionElement {

	private static final long serialVersionUID = 4248590205926285447L;

	public ParticipantAssociations(XMLElement parent) {
		super(parent, "participantAssociations");
	}

	public XMLElement generateNewElement() {
		return new ParticipantAssociation(this);
	}

	public String getElementName() {
		return "participantAssociation";
	}
	
}

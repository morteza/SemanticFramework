package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Participants
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Participants extends XMLCollectionElement {

	private static final long serialVersionUID = -8570363649416135500L;

	public Participants(Collaboration parent) {
		super(parent, "participants");
	}

	public XMLElement generateNewElement() {
		return new Participant(this);
	}

	public String getElementName() {
		return "participant";
	}
	
}

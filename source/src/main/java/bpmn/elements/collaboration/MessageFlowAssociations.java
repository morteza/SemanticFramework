package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * MessageFlowAssociations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class MessageFlowAssociations extends XMLCollectionElement {

	private static final long serialVersionUID = 4240911666171136833L;

	public MessageFlowAssociations(Collaboration parent) {
		super(parent, "messageFlowAssociations");
	}

	public XMLElement generateNewElement() {
		return new MessageFlowAssociation(this);
	}

	public String getElementName() {
		return "messageFlowAssociation";
	}

	public Collaboration getParent() {
		return (Collaboration) parent;
	}

}

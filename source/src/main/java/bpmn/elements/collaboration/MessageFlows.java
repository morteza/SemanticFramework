package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * MessageFlows
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class MessageFlows extends XMLCollectionElement {
	
	private static final long serialVersionUID = 5215792707934602920L;

	public MessageFlows(Collaboration parent) {
		super(parent, "messageFlows");
	}

	public XMLElement generateNewElement() {
		return new MessageFlow(this);
	}

	public String getElementName() {
		return "messageFlow";
	}

	public Collaboration getParent() {
		return (Collaboration) parent;
	}

}

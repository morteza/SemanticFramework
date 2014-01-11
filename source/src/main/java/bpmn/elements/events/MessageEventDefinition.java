package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;

/**
 * MessageEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class MessageEventDefinition extends EventDefinition {

	private static final long serialVersionUID = -3062601632201356149L;

	public MessageEventDefinition(XMLElement parent) {
		super(parent, "messageEventDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrMessageRef = new XMLAttribute(this, "messageRef");
		XMLTextElement refOperationRef = new XMLTextElement(this, "operationRef");

		super.fillStructure();
		add(attrMessageRef);
		add(refOperationRef);
	}

	public final String getMessageRef() {
		return get("messageRef").toValue();
	}

	public final String getOperationRef() {
		return get("operationRef").toValue();
	}

	public final void setMessageRef(String messageRef) {
		set("messageRef", messageRef);
	}
	
	public final void setOperationRef(String operationRef) {
		set("operationRef", operationRef);
	}
	
}

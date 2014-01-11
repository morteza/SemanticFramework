package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * MessageFlow
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class MessageFlow extends BaseElement {

	private static final long serialVersionUID = -4531890796143930465L;

	public MessageFlow(MessageFlows parent) {
		super(parent, "messageFlow");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrSourceRef = new XMLAttribute(this, "sourceRef");
		XMLAttribute refTargetRef = new XMLAttribute(this, "targetRef");
		XMLAttribute refMessageRef = new XMLAttribute(this, "messageRef");

		super.fillStructure();
		add(attrName);
		add(attrSourceRef);
		add(refTargetRef);
		add(refMessageRef);
	}

	public MessageFlows getParent() {
		return (MessageFlows) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getSourceRef() {
		return get("sourceRef").toValue();
	}

	public final String getTargetRef() {
		return get("targetRef").toValue();
	}

	public final String getMessageRef() {
		return get("messageRef").toValue();
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setSourceRef(String sourceRef) {
		set("sourceRef", sourceRef);
	}

	public final void setTargetRef(String targetRef) {
		set("targetRef", targetRef);
	}

	public final void setMessageRef(String messageRef) {
		set("messageRef", messageRef);
	}

	public String toString() {
		return "[" + getSourceRef() + " --> " + getTargetRef() + "]";
	}

}

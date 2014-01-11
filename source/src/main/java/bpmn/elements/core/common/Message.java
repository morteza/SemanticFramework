package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Message
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Message extends BaseElement implements RootElement {

	private static final long serialVersionUID = 7469115946905538730L;

	public Message() {
		this((RootElements) null);
	}

	public Message(RootElements parent) {
		super(parent, "message");
	}
	
	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrItemRef = new XMLAttribute(this, "itemRef");
		
		super.fillStructure();
		add(attrName);
		add(attrItemRef);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getItemRef() {
		return get("itemRef").toValue();
	}

	public final void setName(String name) {
		set("name", name);
	}
	
	public final void setItemRef(String itemRef) {
		set("itemRef", itemRef);
	}
	
	public boolean isGraphicalElement() {
		return getId().startsWith("_");
	}

}

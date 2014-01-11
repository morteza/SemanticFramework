package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * StartEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class StartEvent extends CatchEvent {

	private static final long serialVersionUID = -5727999306526845158L;

	public StartEvent(String name) {
		this(name, true);
	}

	public StartEvent(String name, boolean isInterrupting) {
		this((FlowElements) null);
		setName(name);
		setIsInterrupting(isInterrupting);
	}

	public StartEvent(FlowElements parent) {
		super(parent, "startEvent");
	}

	protected void fillStructure() {
		XMLAttribute attrIsInterrupting = new XMLAttribute(this, "isInterrupting", Boolean.TRUE.toString());
		
		super.fillStructure();
		add(attrIsInterrupting);
	}
	
	public final boolean isInterrupting() {
		return Boolean.parseBoolean(get("isInterrupting").toValue());
	}
	
	public final void setIsInterrupting(boolean isInterrupting) {
		set("isInterrupting", String.valueOf(isInterrupting));
	}

}

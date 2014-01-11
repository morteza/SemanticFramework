package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * BoundaryEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BoundaryEvent extends CatchEvent {

	private static final long serialVersionUID = -1912037614678278157L;

	public BoundaryEvent(String name) {
		this(name, true);
	}

	public BoundaryEvent(String name, boolean cancelActivity) {
		this((FlowElements) null);
		setName(name);
		setCancelActivity(cancelActivity);
	}

	public BoundaryEvent(FlowElements parent) {
		super(parent, "boundaryEvent");
	}

	protected void fillStructure() {
		XMLAttribute attrCancelActivity = new XMLAttribute(this, "cancelActivity", Boolean.TRUE.toString());
		XMLAttribute attrAttachedToRef = new XMLAttribute(this, "attachedToRef");

		super.fillStructure();
		add(attrCancelActivity);
		add(attrAttachedToRef);
	}

	public final boolean cancelActivity() {
		return Boolean.parseBoolean(get("cancelActivity").toValue());
	}

	public final String getAttachedToRef() {
		return get("attachedToRef").toValue();
	}

	public final void setCancelActivity(boolean cancelActivity) {
		set("cancelActivity", String.valueOf(cancelActivity));
	}

	public final void setAttachedToRef(String attachedToRef) {
		set("attachedToRef", attachedToRef);
	}

}

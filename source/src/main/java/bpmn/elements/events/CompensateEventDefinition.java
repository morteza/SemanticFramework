package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;

/**
 * CompensateEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CompensateEventDefinition extends EventDefinition {

	private static final long serialVersionUID = 1804512803236133130L;

	public CompensateEventDefinition(XMLElement parent) {
		super(parent, "compensateEventDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrWaitForCompletion = new XMLAttribute(this, "waitForCompletion", Boolean.TRUE.toString());
		XMLAttribute attrActivityRef = new XMLAttribute(this, "activityRef");

		super.fillStructure();
		add(attrWaitForCompletion);
		add(attrActivityRef);
	}

	public final boolean waitForCompletion() {
		return Boolean.parseBoolean(get("waitForCompletion").toValue());
	}
	
	public final String getActivityRef() {
		return get("activityRef").toValue();
	}

	public final void setWaitForCompletion(boolean waitForCompletion) {
		set("waitForCompletion", String.valueOf(waitForCompletion));
	}
	
	public final void setActivityRef(String activityRef) {
		set("activityRef", activityRef);
	}
	
}

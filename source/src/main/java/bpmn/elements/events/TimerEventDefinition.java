package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLElement;

/**
 * TimerEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class TimerEventDefinition extends EventDefinition {

	private static final long serialVersionUID = 5239415370236703622L;

	public TimerEventDefinition(XMLElement parent) {
		super(parent, "timerEventDefinition");
	}

	protected void fillStructure() {
		TimerTypes refTimerTypes = new TimerTypes(this);

		super.fillStructure();
		add(refTimerTypes);
	}

	public final TimerTypes getTimerTypes() {
		return (TimerTypes) get("TimerTypes");
	}
	
}

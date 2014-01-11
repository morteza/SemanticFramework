package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * EndEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class EndEvent extends ThrowEvent {

	private static final long serialVersionUID = -3935308454400624581L;

	public EndEvent(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public EndEvent(FlowElements parent) {
		super(parent, "endEvent");
	}

}

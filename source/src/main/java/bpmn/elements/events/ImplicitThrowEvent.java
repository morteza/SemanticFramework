package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * ImplicitThrowEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ImplicitThrowEvent extends ThrowEvent {

	private static final long serialVersionUID = 516601491609782337L;

	public ImplicitThrowEvent(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ImplicitThrowEvent(FlowElements parent) {
		super(parent, "implicitThrowEvent");
	}

}

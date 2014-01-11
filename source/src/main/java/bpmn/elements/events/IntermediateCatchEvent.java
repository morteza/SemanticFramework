package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * IntermediateCatchEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class IntermediateCatchEvent extends CatchEvent {

	private static final long serialVersionUID = -235832439861322253L;

	public IntermediateCatchEvent(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public IntermediateCatchEvent(FlowElements parent) {
		super(parent, "intermediateCatchEvent");
	}

}

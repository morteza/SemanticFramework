package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * IntermediateThrowEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class IntermediateThrowEvent extends ThrowEvent {

	private static final long serialVersionUID = 4626793349081007494L;

	public IntermediateThrowEvent(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public IntermediateThrowEvent(FlowElements parent) {
		super(parent, "intermediateThrowEvent");
	}

}

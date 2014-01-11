package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.process.activities.Task;

/**
 * ManualTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ManualTask extends Task {

	private static final long serialVersionUID = -914724667962159055L;

	public ManualTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ManualTask(FlowElements parent) {
		super(parent, "manualTask");
	}

}

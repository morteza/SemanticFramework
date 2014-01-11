package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * Task
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Task extends Activity {

	private static final long serialVersionUID = -1931398887430053428L;

	public Task(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public Task(FlowElements parent) {
		super(parent, "task");
	}
	
	public Task(FlowElements parent, String name) {
		super(parent, name);
	}


}

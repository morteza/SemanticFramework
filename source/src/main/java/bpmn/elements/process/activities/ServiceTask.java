package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * ServiceTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ServiceTask extends Task {

	private static final long serialVersionUID = 4843211280587232840L;

	public ServiceTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ServiceTask(FlowElements parent) {
		super(parent, "serviceTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##WebService");
		XMLAttribute attrOperationRef = new XMLAttribute(this, "operationRef");

		super.fillStructure();
		add(attrImplementation);
		add(attrOperationRef);
	}

}

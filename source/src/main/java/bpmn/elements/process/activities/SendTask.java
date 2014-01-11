package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * SendTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class SendTask extends Task {

	private static final long serialVersionUID = -5599534715440292963L;

	public SendTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public SendTask(FlowElements parent) {
		super(parent, "sendTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##WebService");
		XMLAttribute attrMessageRef = new XMLAttribute(this, "messageRef");
		XMLAttribute attrOperationRef = new XMLAttribute(this, "operationRef");

		super.fillStructure();
		add(attrImplementation);
		add(attrMessageRef);
		add(attrOperationRef);
	}

}

package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * ReceiveTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ReceiveTask extends Task {

	private static final long serialVersionUID = 3633548660657037563L;

	public ReceiveTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ReceiveTask(FlowElements parent) {
		super(parent, "receiveTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##WebService");
		XMLAttribute attrInstantiate = new XMLAttribute(this, "instantiate", Boolean.FALSE.toString());
		XMLAttribute attrMessageRef = new XMLAttribute(this, "messageRef");
		XMLAttribute attrOperationRef = new XMLAttribute(this, "operationRef");

		super.fillStructure();
		add(attrImplementation);
		add(attrInstantiate);
		add(attrMessageRef);
		add(attrOperationRef);
	}

	public final boolean isInstantiate() {
		return Boolean.parseBoolean(get("instantiate").toValue());
	}
	
	public final void setInstantiate(boolean instantiate) {
		set("instantiate", String.valueOf(instantiate));
	}
}

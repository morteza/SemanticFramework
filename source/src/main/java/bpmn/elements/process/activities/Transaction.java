package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * Transaction
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Transaction extends SubProcess {

	private static final long serialVersionUID = 5728943115540481916L;

	public Transaction(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public Transaction(FlowElements parent) {
		super(parent, "transaction");
	}

	protected void fillStructure() {
		XMLAttribute attrMethod = new XMLAttribute(this, "method", "##Compensate");

		super.fillStructure();
		add(attrMethod);
	}

	public final String getMethod() {
		return getMethodAttribute().toValue();
	}

	public final XMLAttribute getMethodAttribute() {
		return (XMLAttribute) get("method");
	}

	public final void setMethod(String method) {
		getMethodAttribute().setValue(method);
	}

}

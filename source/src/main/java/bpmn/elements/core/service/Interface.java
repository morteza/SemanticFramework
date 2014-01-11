package org.yaoqiang.model.bpmn.elements.core.service;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.CallableElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Interface
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Interface extends BaseElement implements RootElement {

	private static final long serialVersionUID = 4536503106198516487L;

	public Interface(RootElements parent) {
		super(parent, "interface");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrImplementationRef = new XMLAttribute(this, "implementationRef");
		Operations refOperations = new Operations(this);
		CallableElements refCallableElements = new CallableElements(this);

		super.fillStructure();
		add(attrName);
		add(attrImplementationRef);
		add(refOperations);
		add(refCallableElements);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getImplementationRef() {
		return get("implementationRef").toValue();
	}

	public final Operations getOperations() {
		return (Operations) get("operations");
	}

	public final Operation addOperation(String prefix, String name) {
		Operation op = (Operation) getOperations().generateNewElement();
		op.setName(name);
		op.setImplementationRef(prefix + ":" + name);
		getOperations().add(op);
		return op;
	}

	public final List<XMLElement> getOperationList() {
		return getOperations().getXMLElements();
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setImplementationRef(String implementationRef) {
		set("implementationRef", implementationRef);
	}

}

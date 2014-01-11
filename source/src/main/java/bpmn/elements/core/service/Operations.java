package org.yaoqiang.model.bpmn.elements.core.service;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Operations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Operations extends XMLCollectionElement {

	private static final long serialVersionUID = 6726008363333976951L;

	public Operations(Interface parent) {
		super(parent, "operations");
	}

	public XMLElement generateNewElement() {
		Operation operation = new Operation(this);
		operation.setId(createId(getParent().getId() + "_O"));
		return operation;
	}

	public String getElementName() {
		return "operation";
	}

	public Interface getParent() {
		return (Interface) parent;
	}

}

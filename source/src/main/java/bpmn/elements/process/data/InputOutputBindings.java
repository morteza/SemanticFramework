package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.CallableElement;

/**
 * InputOutputBindings
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class InputOutputBindings extends XMLCollectionElement {

	private static final long serialVersionUID = -99614374532217644L;

	public InputOutputBindings(CallableElement parent) {
		super(parent, "ioBindings");
	}

	public XMLElement generateNewElement() {
		return new InputOutputBinding(this);
	}

	public String getElementName() {
		return "ioBinding";
	}

	public CallableElement getParent() {
		return (CallableElement) parent;
	}

}

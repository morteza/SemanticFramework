package org.yaoqiang.model.bpmn.elements.core.service;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.core.common.BPMNError;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Operation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Operation extends BaseElement {

	private static final long serialVersionUID = 6382089128000564602L;

	public Operation(Operations parent) {
		super(parent, "operation");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrImplementationRef = new XMLAttribute(this, "implementationRef");
		XMLTextElement refInMessageRef = new XMLTextElement(this, "inMessageRef");
		XMLTextElement refOutMessageRef = new XMLTextElement(this, "outMessageRef");
		XMLTextElements refErrorRef = new XMLTextElements(this, "errorRef");

		super.fillStructure();
		add(attrName);
		add(attrImplementationRef);
		add(refInMessageRef);
		add(refOutMessageRef);
		add(refErrorRef);
	}

	public Operations getParent() {
		return (Operations) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getImplementationRef() {
		return get("implementationRef").toValue();
	}

	public final XMLTextElements getErrorRefs() {
		return (XMLTextElements) get("errorRef");
	}

	public final List<XMLElement> getErrorRefList() {
		return getErrorRefs().getXMLElements();
	}

	public final List<XMLElement> getRefErrorList() {
		List<XMLElement> els = new ArrayList<XMLElement>();
		for (XMLElement erRef : getErrorRefList()) {
			BPMNError er = BPMNModelUtils.getDefinitions(parent).getError(erRef.toValue());
			if (er != null) {
				els.add(er);
			}
		}
		return els;
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setImplementationRef(String implementationRef) {
		set("implementationRef", implementationRef);
	}

	public final void setInMessageRef(String inMessageRef) {
		set("inMessageRef", inMessageRef);
	}

	public final String getInMessageRef() {
		return get("inMessageRef").toValue();
	}

	public final void setOutMessageRef(String outMessageRef) {
		set("outMessageRef", outMessageRef);
	}

	public final String getOutMessageRef() {
		return get("outMessageRef").toValue();
	}

	public final void addErrorRef(String errorRef) {
		XMLElement error = getErrorRefs().generateNewElement();
		error.setValue(errorRef);
		getErrorRefs().add(error);
	}

}

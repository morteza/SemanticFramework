package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * InputSet
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class InputSet extends BaseElement {

	private static final long serialVersionUID = -6593414615600425263L;

	public InputSet(XMLElement parent) {
		super(parent, "inputSet");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refDataInputRefs = new XMLTextElements(this, "dataInputRefs");
		XMLTextElements refOptionalInputRefs = new XMLTextElements(this, "optionalInputRefs");
		XMLTextElements refWhileExecutingInputRefs = new XMLTextElements(this, "whileExecutingInputRefs");
		XMLTextElements refOutputSetRefs = new XMLTextElements(this, "outputSetRefs");

		super.fillStructure();
		add(attrName);
		add(refDataInputRefs);
		add(refOptionalInputRefs);
		add(refWhileExecutingInputRefs);
		add(refOutputSetRefs);
	}

	public final XMLTextElements getDataInputRefs() {
		return (XMLTextElements) get("dataInputRefs");
	}

}

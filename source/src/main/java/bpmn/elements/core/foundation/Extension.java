package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;

/**
 * Extension
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Extension extends XMLComplexElement {

	private static final long serialVersionUID = 3170791277499717429L;

	public Extension(Extensions parent) {
		super(parent, "extension");
	}

	protected void fillStructure() {
		XMLAttribute attrMustUnderstand = new XMLAttribute(this, "mustUnderstand", Boolean.FALSE.toString());
		XMLAttribute attrDefinition = new XMLAttribute(this, "definition");

		add(attrMustUnderstand);
		add(attrDefinition);
	}

	public Extensions getParent() {
		return (Extensions) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;

/**
 * Documentation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Documentation extends BaseElement {

	private static final long serialVersionUID = 3828441952954658246L;

	public Documentation(Documentations parent) {
		super(parent, "documentation");
	}

	protected void fillStructure() {
		XMLAttribute attrTextFormat = new XMLAttribute(this, "textFormat");

		super.fillStructure();
		add(attrTextFormat);
	}

	public Documentations getParent() {
		return (Documentations) parent;
	}

	public final String getTextFormat() {
		return get("textFormat").toValue();
	}

	public final void setTextFormat(String textFormat) {
		set("textFormat", textFormat);
	}

}

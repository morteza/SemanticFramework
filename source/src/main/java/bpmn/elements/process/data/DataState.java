package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataState
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataState extends BaseElement {

	private static final long serialVersionUID = -1153995924973733117L;

	public DataState(XMLElement parent) {
		super(parent, "dataState");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");

		super.fillStructure();
		add(attrName);
	}

	public final String getName() {
		return get("name").toValue();
	}
	
	public final void setName(String name) {
		set("name", name);
	}
	
}

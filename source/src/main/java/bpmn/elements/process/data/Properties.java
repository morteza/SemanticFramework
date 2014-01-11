package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Properties
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Properties extends XMLCollectionElement {

	private static final long serialVersionUID = -163205451909389303L;

	public Properties(XMLElement parent) {
		super(parent, "properties");
	}

	public XMLElement generateNewElement() {
		Property property = new Property(this);
		property.setId(createId(((BaseElement) getParent()).getId() + "_P"));
		return property;
	}

	public String getElementName() {
		return "property";
	}
	
}

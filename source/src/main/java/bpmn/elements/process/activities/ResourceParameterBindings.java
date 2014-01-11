package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ResourceParameterBindings
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceParameterBindings extends XMLCollectionElement {

	private static final long serialVersionUID = -6403272241594072847L;

	public ResourceParameterBindings(XMLElement parent) {
		super(parent, "resourceParameterBindings");
	}

	public XMLElement generateNewElement() {
		return new ResourceParameterBinding(this);
	}

	public String getElementName() {
		return "resourceParameterBinding";
	}
	
}

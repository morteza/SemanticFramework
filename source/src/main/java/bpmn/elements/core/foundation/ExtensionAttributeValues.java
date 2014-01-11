package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ExtensionAttributeValues
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExtensionAttributeValues extends XMLCollectionElement {

	private static final long serialVersionUID = -6012441529195658797L;

	public ExtensionAttributeValues(BaseElement parent) {
		super(parent, "extensionValues");
	}

	public XMLElement generateNewElement() {
		return new ExtensionAttributeValue(this);
	}

	public String getElementName() {
		return "extensionAttributeValue";
	}

	public BaseElement getParent() {
		return (BaseElement) parent;
	}

}

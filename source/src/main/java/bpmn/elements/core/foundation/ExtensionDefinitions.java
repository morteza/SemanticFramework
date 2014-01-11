package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ExtensionDefinitions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExtensionDefinitions extends XMLCollectionElement {

	private static final long serialVersionUID = 1431810521025915767L;

	public ExtensionDefinitions(BaseElement parent) {
		super(parent, "extensionDefinitions");
	}
	
	public XMLElement generateNewElement() {
		return new ExtensionDefinition(this);
	}

	public String getElementName() {
		return "extensionDefinition";
	}

	public BaseElement getParent() {
		return (BaseElement) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ExtensionAttributeDefinitions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExtensionAttributeDefinitions extends XMLCollectionElement {

	private static final long serialVersionUID = -8891435409170448201L;

	public ExtensionAttributeDefinitions(ExtensionDefinition parent) {
		super(parent, "extensionAttributeDefinitions");
	}

	public XMLElement generateNewElement() {
		return new ExtensionAttributeDefinition(this);
	}

	public String getElementName() {
		return "extensionAttributeDefinition";
	}

	public ExtensionDefinition getParent() {
		return (ExtensionDefinition) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;

/**
 * ExtensionDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExtensionDefinition extends XMLComplexElement {

	private static final long serialVersionUID = -5818660335703251791L;

	public ExtensionDefinition(ExtensionDefinitions parent) {
		super(parent, "extensionDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		ExtensionAttributeDefinitions refExtensionAttributeDefinitions = new ExtensionAttributeDefinitions(this);

		add(attrName);
		add(refExtensionAttributeDefinitions);
	}

	public ExtensionDefinitions getParent() {
		return (ExtensionDefinitions) parent;
	}

}

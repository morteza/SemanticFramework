package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;

/**
 * ExtensionAttributeValue
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExtensionAttributeValue extends XMLComplexElement {

	private static final long serialVersionUID = 6478848273853379902L;

	public ExtensionAttributeValue(ExtensionAttributeValues parent) {
		super(parent, "extensionAttributeValue");
	}

	protected void fillStructure() {
		XMLAttribute attrValue = new XMLAttribute(this, "value");
		XMLAttribute attrValueRef = new XMLAttribute(this, "valueRef");
		ExtensionAttributeDefinition refExtensionAttributeDefinition = new ExtensionAttributeDefinition(this);

		add(attrValue);
		add(attrValueRef);
		add(refExtensionAttributeDefinition);
	}

	public ExtensionAttributeValues getParent() {
		return (ExtensionAttributeValues) parent;
	}

}

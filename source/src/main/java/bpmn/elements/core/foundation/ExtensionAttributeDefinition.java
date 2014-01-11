package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;

/**
 * ExtensionAttributeDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ExtensionAttributeDefinition extends XMLComplexElement {

	private static final long serialVersionUID = 1870335032128632109L;

	public ExtensionAttributeDefinition(XMLElement parent) {
		super(parent, "extensionAttributeDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrType = new XMLAttribute(this, "type");
		XMLAttribute attrIsReference = new XMLAttribute(this, "isReference", Boolean.FALSE.toString());

		add(attrName);
		add(attrType);
		add(attrIsReference);
	}

}

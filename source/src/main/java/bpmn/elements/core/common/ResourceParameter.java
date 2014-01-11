package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ResourceParameter
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceParameter extends BaseElement {

	private static final long serialVersionUID = 8692053379919667401L;

	public ResourceParameter(ResourceParameters parent) {
		super(parent, "resourceParameter");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrType = new XMLAttribute(this, "type");
		XMLAttribute attrIsRequired = new XMLAttribute(this, "isRequired");

		super.fillStructure();
		add(attrName);
		add(attrType);
		add(attrIsRequired);
	}

	public ResourceParameters getParent() {
		return (ResourceParameters) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}
}

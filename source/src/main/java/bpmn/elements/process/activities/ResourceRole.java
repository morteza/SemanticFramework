package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ResourceRole
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceRole extends BaseElement {

	private static final long serialVersionUID = -8388038478904203285L;

	public ResourceRole(XMLElement parent) {
		super(parent, "resourceRole");
	}

	public ResourceRole(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		ResourceAssignTypes refResourceTypes = new ResourceAssignTypes(this);

		super.fillStructure();
		add(attrName);
		add(refResourceTypes);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getResourceRef() {
		if (getResourceAssignTypes().getChoosen().toName().equals("parameterAssignment")) {
			return ((XMLComplexElement) getResourceAssignTypes().getChoosen()).get("resourceRef").toValue();
		}
		return "";
	}

	public final ResourceAssignTypes getResourceAssignTypes() {
		return (ResourceAssignTypes) get("ResourceAssignTypes");
	}

	public final void setName(String name) {
		set("name", name);
	}

}

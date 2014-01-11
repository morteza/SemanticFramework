package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ResourceRoles
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceRoles extends XMLFactoryElement {

	private static final long serialVersionUID = -7250808834281038332L;

	public ResourceRoles(XMLElement parent) {
		super(parent, "resources");
	}
	
	public XMLElement generateNewElement() {
		ResourceRole resource = new ResourceRole(this);
		resource.setId(createId(((BaseElement) getParent()).getId() + "_RES"));
		if (type.equals("performer")) {
			resource.setElementName("performer");
			return resource;
		} else if (type.equals("humanPerformer")) {
			resource.setElementName("humanPerformer");
			return resource;
		} else if (type.equals("potentialOwner")) {
			resource.setElementName("potentialOwner");
			return resource;
		} else if (type.equals("resourceRole")) {
			resource.setElementName("resourceRole");
			return resource;
		} else {
			return null;
		}
	}

}

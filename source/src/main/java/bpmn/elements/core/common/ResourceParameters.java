package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ResourceParameters
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceParameters extends XMLCollectionElement {

	private static final long serialVersionUID = -350524650469673239L;

	public ResourceParameters(Resource parent) {
		super(parent, "resourceParameters");
	}

	public XMLElement generateNewElement() {
		ResourceParameter resourceParameter = new ResourceParameter(this);
		resourceParameter.setId(createId(((Resource) getParent()).getId() + "_P"));
		return resourceParameter;
	}
	
	public String getElementName() {
		return "resourceParameter";
	}
	
}

package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Resource
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Resource extends BaseElement implements RootElement {

	private static final long serialVersionUID = 7426848756771202611L;

	public Resource(RootElements parent) {
		super(parent, "resource");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		ResourceParameters refResourceParameters = new ResourceParameters(this);

		super.fillStructure();
		add(attrName);
		add(refResourceParameters);
	}
	
	public final String getName() {
		return get("name").toValue();
	}
	
	public final ResourceParameter getResourceParameter(String parameterId) {
		return (ResourceParameter) getResourceParameters().getCollectionElement(parameterId);
	}
	
	public final ResourceParameters getResourceParameters() {
		return (ResourceParameters) get("resourceParameters");
	}

	public final List<XMLElement> getResourceParameterList() {
		return getResourceParameters().getXMLElements();
	}
	
}

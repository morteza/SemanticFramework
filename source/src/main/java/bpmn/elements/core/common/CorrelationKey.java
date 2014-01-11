package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * CorrelationKey
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationKey extends BaseElement {

	private static final long serialVersionUID = 4991426097040656906L;

	public CorrelationKey(CorrelationKeys parent) {
		super(parent, "correlationKey");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refCorrelationPropertyRefs = new XMLTextElements(this, "correlationPropertyRef");

		super.fillStructure();
		add(attrName);
		add(refCorrelationPropertyRefs);
	}

	public CorrelationKeys getParent() {
		return (CorrelationKeys) parent;
	}

}

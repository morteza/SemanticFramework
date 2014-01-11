package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * CorrelationProperty
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationProperty extends BaseElement implements RootElement {

	private static final long serialVersionUID = -5552091723623159740L;

	public CorrelationProperty(RootElements parent) {
		super(parent, "correlationProperty");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrType = new XMLAttribute(this, "type");
		CorrelationPropertyRetrievalExpressions refCorrelationPropertyRetrievalExpressions = new CorrelationPropertyRetrievalExpressions(this);

		super.fillStructure();
		add(attrName);
		add(attrType);
		add(refCorrelationPropertyRetrievalExpressions);
	}

}

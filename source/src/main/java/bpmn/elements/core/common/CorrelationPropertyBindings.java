package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * CorrelationPropertyBindings
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationPropertyBindings extends XMLCollectionElement {

	private static final long serialVersionUID = 3865508600076831684L;

	public CorrelationPropertyBindings(CorrelationSubscription parent) {
		super(parent, "correlationPropertyBindings");
	}
	
	public XMLElement generateNewElement() {
		return new CorrelationPropertyBinding(this);
	}

	public String getElementName() {
		return "correlationPropertyBinding";
	}
	
}

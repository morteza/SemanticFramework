package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * CorrelationPropertyRetrievalExpressions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationPropertyRetrievalExpressions extends XMLCollectionElement {

	private static final long serialVersionUID = 6079139916599265825L;

	public CorrelationPropertyRetrievalExpressions(CorrelationProperty parent) {
		super(parent);
	}

	public XMLElement generateNewElement() {
		return new CorrelationPropertyRetrievalExpression(this);
	}

	public String getElementName() {
		return "correlationPropertyRetrievalExpression";
	}
	
}

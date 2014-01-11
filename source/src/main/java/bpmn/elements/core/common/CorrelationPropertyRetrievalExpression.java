package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * CorrelationPropertyRetrievalExpression
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationPropertyRetrievalExpression extends BaseElement {

	private static final long serialVersionUID = -5994199617311826650L;

	public CorrelationPropertyRetrievalExpression(CorrelationPropertyRetrievalExpressions parent) {
		super(parent, "correlationPropertyRetrievalExpression");
	}

	protected void fillStructure() {
		XMLAttribute attrMessageRef = new XMLAttribute(this, "messageRef");
		FormalExpression refMessagePath = new FormalExpression(this, "messagePath");

		super.fillStructure();
		add(attrMessageRef);
		add(refMessagePath);
	}

	public CorrelationPropertyRetrievalExpressions getParent() {
		return (CorrelationPropertyRetrievalExpressions) parent;
	}

}

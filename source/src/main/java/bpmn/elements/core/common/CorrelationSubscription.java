package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * CorrelationSubscription
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationSubscription extends BaseElement {

	private static final long serialVersionUID = -5166012566443226925L;

	public CorrelationSubscription(CorrelationSubscriptions parent) {
		super(parent, "correlationSubscription");
	}

	protected void fillStructure() {
		XMLAttribute attrCorrelationKeyRef = new XMLAttribute(this, "correlationKeyRef");
		CorrelationPropertyBindings refCorrelationPropertyBindings = new CorrelationPropertyBindings(this);

		super.fillStructure();
		add(attrCorrelationKeyRef);
		add(refCorrelationPropertyBindings);
	}

	public CorrelationSubscriptions getParent() {
		return (CorrelationSubscriptions) parent;
	}

}

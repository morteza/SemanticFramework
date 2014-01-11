package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.bpmn.elements.core.common.FormalExpression;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.events.ImplicitThrowEvent;

/**
 * ComplexBehaviorDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ComplexBehaviorDefinition extends BaseElement {

	private static final long serialVersionUID = -4903134315960102809L;

	public ComplexBehaviorDefinition(ComplexBehaviorDefinitions parent) {
		super(parent, "complexBehaviorDefinition");
	}

	protected void fillStructure() {
		FormalExpression refCondition = new FormalExpression(this, "condition");

		super.fillStructure();
		add(refCondition);
	}
	
	public ComplexBehaviorDefinitions getParent() {
		return (ComplexBehaviorDefinitions) parent;
	}
	
	protected ImplicitThrowEvent event;
	
}

package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;

/**
 * ConditionalEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ConditionalEventDefinition extends EventDefinition {

	private static final long serialVersionUID = -1330595032707835365L;

	public ConditionalEventDefinition(XMLElement parent) {
		super(parent, "conditionalEventDefinition");
	}

	protected void fillStructure() {
		Expression refExpression = new Expression(this, "condition");

		super.fillStructure();
		add(refExpression);
	}
	
	public final String getConditionString() {
		return getConditionExpression().toValue();
	}
	
	public final Expression getConditionExpression() {
		return (Expression) get("condition");
	}
	
	public final void setConditionExpression(String expression) {
		getConditionExpression().setValue(expression);
	}
	
}

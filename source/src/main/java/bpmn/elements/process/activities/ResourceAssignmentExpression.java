package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.core.common.FormalExpression;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ResourceAssignmentExpression
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceAssignmentExpression extends BaseElement {

	private static final long serialVersionUID = 21288001436765111L;

	public ResourceAssignmentExpression(ResourceAssignTypes parent) {
		super(parent, "resourceAssignmentExpression");
	}

	protected void fillStructure() {
		FormalExpression refExpression = new FormalExpression(this);

		super.fillStructure();
		add(refExpression);
	}

	public final Expression getExpressionElement() {
		return (Expression) get("formalExpression");
	}
	
}

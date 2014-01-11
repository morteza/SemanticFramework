package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * AdHocSubProcess
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class AdHocSubProcess extends SubProcess {

	private static final long serialVersionUID = -5004402258221006492L;

	public class Ordering {
		public static final String PARALLEL = "Parallel";
		public static final String SEQUENTIAL = "Sequential";
	}

	public AdHocSubProcess(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public AdHocSubProcess(FlowElements parent) {
		super(parent, "adHocSubProcess");
	}

	protected void fillStructure() {
		XMLAttribute attrCancelRemainingInstances = new XMLAttribute(this, "cancelRemainingInstances", Boolean.TRUE.toString());
		XMLAttribute attrOrdering = new XMLAttribute(this, "ordering", AdHocSubProcess.Ordering.PARALLEL);
		Expression refCompletionCondition = new Expression(this, "completionCondition");

		super.fillStructure();
		add(attrCancelRemainingInstances);
		add(attrOrdering);
		add(refCompletionCondition);
	}

	public final String getOrdering() {
		return getOrderingAttribute().toValue();
	}

	public final XMLAttribute getOrderingAttribute() {
		return (XMLAttribute) get("ordering");
	}

	public final boolean isCancelRemainingInstances() {
		return Boolean.parseBoolean(get("cancelRemainingInstances").toValue());
	}

	public final String getConditionString() {
		return getCompletionCondition().toValue();
	}

	public final Expression getCompletionCondition() {
		return (Expression) get("completionCondition");
	}

	public final void setCompletionCondition(String expression) {
		getCompletionCondition().setValue(expression);
	}

}

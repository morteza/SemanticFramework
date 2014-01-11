package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Assignment
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Assignment extends BaseElement {

	private static final long serialVersionUID = 63259551856955014L;

	public Assignment(Assignments parent) {
		super(parent, "assignment");
	}

	protected void fillStructure() {
		Expression refFrom = new Expression(this, "from");
		Expression refTo = new Expression(this, "to");

		super.fillStructure();
		add(refFrom);
		add(refTo);
	}

	public Assignments getParent() {
		return (Assignments) parent;
	}

}

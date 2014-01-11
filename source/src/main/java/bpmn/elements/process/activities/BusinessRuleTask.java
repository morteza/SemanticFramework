package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * BusinessRuleTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BusinessRuleTask extends Task {

	private static final long serialVersionUID = -3587004970021604177L;

	public BusinessRuleTask(String name) {
		this((FlowElements) null);
		setName(name);
	}
	
	public BusinessRuleTask(FlowElements parent) {
		super(parent, "businessRuleTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##unspecified");

		super.fillStructure();
		add(attrImplementation);
	}

}

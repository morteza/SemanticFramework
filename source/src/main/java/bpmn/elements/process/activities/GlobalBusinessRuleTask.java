package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;

/**
 * GlobalBusinessRuleTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalBusinessRuleTask extends GlobalTask {

	private static final long serialVersionUID = -5128031234560189244L;

	public GlobalBusinessRuleTask(XMLElement parent) {
		super(parent, "globalBusinessRuleTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##unspecified");

		super.fillStructure();
		add(attrImplementation);
	}

}

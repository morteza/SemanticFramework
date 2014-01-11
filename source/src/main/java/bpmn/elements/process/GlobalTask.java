package org.yaoqiang.model.bpmn.elements.process;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.CallableElement;
import org.yaoqiang.model.bpmn.elements.process.activities.ResourceRoles;

/**
 * GlobalTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalTask extends CallableElement {

	private static final long serialVersionUID = 2864730630516261058L;

	public GlobalTask(XMLElement parent) {
		super(parent, "globalTask");
	}

	public GlobalTask(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		ResourceRoles refResourceRoles = new ResourceRoles(this);

		super.fillStructure();
		add(refResourceRoles);
	}

}

package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.events.ConditionalEventDefinition;
import org.yaoqiang.model.bpmn.elements.process.activities.ResourceAssignmentExpression;
import org.yaoqiang.model.bpmn.elements.process.data.Assignment;

/**
 * Expression
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Expression extends BaseElement {

	private static final long serialVersionUID = -1069725665596748762L;

	public Expression(XMLElement parent) {
		super(parent, "expression");
	}

	public Expression(XMLElement parent, String name) {
		super(parent, name);
	}
	
	public boolean isEmpty() {
		if (parent instanceof ResourceAssignmentExpression || parent instanceof Assignment || parent instanceof ConditionalEventDefinition) {
			return false;
		} else {
			return super.isEmpty();
		}
	}
}

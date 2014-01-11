package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * CorrelationPropertyBinding
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationPropertyBinding extends BaseElement {

	private static final long serialVersionUID = 2823770213179363211L;

	public CorrelationPropertyBinding(CorrelationPropertyBindings parent) {
		super(parent, "correlationPropertyBinding");
	}

	protected void fillStructure() {
		XMLAttribute attrCorrelationPropertyRef = new XMLAttribute(this, "correlationPropertyRef");
		FormalExpression refDataPath = new FormalExpression(this, "dataPath");

		super.fillStructure();
		add(attrCorrelationPropertyRef);
		add(refDataPath);
	}

	public CorrelationPropertyBindings getParent() {
		return (CorrelationPropertyBindings) parent;
	}

}

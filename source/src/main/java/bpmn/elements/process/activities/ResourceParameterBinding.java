package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.core.common.FormalExpression;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ResourceParameterBinding
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ResourceParameterBinding extends BaseElement {

	private static final long serialVersionUID = 457330283299021114L;

	public ResourceParameterBinding(ResourceParameterBindings parent) {
		super(parent, "resourceParameterBinding");
	}

	protected void fillStructure() {
		XMLAttribute attrParameterRef = new XMLAttribute(this, "parameterRef");
		FormalExpression refExpression = new FormalExpression(this);

		super.fillStructure();
		add(attrParameterRef);
		add(refExpression);
	}

	public ResourceParameterBindings getParent() {
		return (ResourceParameterBindings) parent;
	}

	public final String getParameterRef() {
		return get("parameterRef").toValue();
	}

	public final void setParameterRef(String parameterRef) {
		set("parameterRef", parameterRef);
	}

	public final Expression getExpressionElement() {
		return (Expression) get("formalExpression");
	}

}

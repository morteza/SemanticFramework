package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;

/**
 * FormalExpression
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class FormalExpression extends Expression {

	private static final long serialVersionUID = -1016752443934934292L;

	public FormalExpression(XMLElement parent) {
		super(parent, "formalExpression");
	}
	
	public FormalExpression(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrLanguage = new XMLAttribute(this, "language");
		// TODO: BPMN 2.0
		//ItemDefinition refEvaluatesToTypeRef = new ItemDefinition(this, "evaluatesToTypeRef");

		super.fillStructure();
		add(attrLanguage);
		//add(refEvaluatesToTypeRef);
	}

}

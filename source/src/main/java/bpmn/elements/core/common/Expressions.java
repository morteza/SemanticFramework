package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;

/**
 * Expressions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Expressions extends XMLFactoryElement {

	private static final long serialVersionUID = -1716624220114617439L;
	
	protected String elementName = null;

	public Expressions(XMLElement parent, String name) {
		super(parent, name);
		this.elementName = name;
	}

	public XMLElement generateNewElement() {
		if (type.equals("formalExpression")) {
			if (elementName == null) {
				return new FormalExpression(this);
			} else {
				return new FormalExpression(this, elementName);
			}
		} else if (type.equals("expression")) {
			if (elementName == null) {
				return new Expression(this);
			} else {
				return new Expression(this, elementName);
			}
		}
		
		return null;
	}
	
}

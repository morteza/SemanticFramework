package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Documentations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Documentations extends XMLCollectionElement {

	private static final long serialVersionUID = 7375585621732124470L;

	public Documentations(BaseElement parent) {
		super(parent, "documentations");
	}

	public XMLElement generateNewElement() {
		Documentation documentation = new Documentation(this);
		documentation.setId(createId(((BaseElement) getParent()).getId() + "_D"));
		return documentation;
	}

	public String getElementName() {
		return "documentation";
	}
	
}

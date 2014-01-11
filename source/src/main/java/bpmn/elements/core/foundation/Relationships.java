package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.infrastructure.Definitions;

/**
 * Relationships
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Relationships extends XMLCollectionElement {

	private static final long serialVersionUID = -1671365838463062140L;

	public Relationships(Definitions parent) {
		super(parent, "relationships");
	}

	public XMLElement generateNewElement() {
		return new Relationship(this);
	}

	public String getElementName() {
		return "relationship";
	}

	public Definitions getParent() {
		return (Definitions) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.artifacts;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * CategoryValues
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CategoryValues extends XMLCollectionElement {

	private static final long serialVersionUID = 4967110588087051460L;

	public CategoryValues(Category parent) {
		super(parent, "categoryValues");
	}

	public Category getParent() {
		return (Category) parent;
	}

	public XMLElement generateNewElement() {
		CategoryValue categoryValue = new CategoryValue(this);
		categoryValue.setId(createId(getParent().getId()));
		return categoryValue;
	}

	public String getElementName() {
		return "categoryValue";
	}

}

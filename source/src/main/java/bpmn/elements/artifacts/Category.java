package org.yaoqiang.model.bpmn.elements.artifacts;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Category
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Category extends BaseElement implements RootElement {

	private static final long serialVersionUID = 2173333922826352726L;

	public Category(RootElements parent) {
		super(parent, "category");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		CategoryValues refCategoryValues = new CategoryValues(this);

		super.fillStructure();
		add(attrName);
		add(refCategoryValues);
	}

	public final String getName() {
		return get("name").toValue();
	}
	
	public final CategoryValues getCategoryValues() {
		return (CategoryValues) get("categoryValues");
	}

	public final List<XMLElement> getCategoryValueList() {
		return getCategoryValues().getXMLElements();
	}
	
	public final CategoryValue getCategoryValue(String id) {
		return (CategoryValue) getCategoryValues().getCollectionElement(id);
	}
	
	public final CategoryValue addCategoryValue(String value) {
		CategoryValue categoryValue = (CategoryValue) getCategoryValues().generateNewElement();
		categoryValue.setValue(value);
		getCategoryValues().add(categoryValue);
		return categoryValue;
	}
}

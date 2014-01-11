package org.yaoqiang.model.bpmn.elements.artifacts;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * CategoryValue
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CategoryValue extends BaseElement {

	private static final long serialVersionUID = -165137552363414885L;

	List<XMLElement> categorizedFlowElements = new ArrayList<XMLElement>();

	public CategoryValue(CategoryValues parent) {
		super(parent, "categoryValue");
	}

	protected void fillStructure() {
		XMLAttribute attrValue = new XMLAttribute(this, "value");

		super.fillStructure();
		add(attrValue);
	}

	public CategoryValues getParent() {
		return (CategoryValues) parent;
	}

	public final String getValue() {
		return get("value").toValue();
	}

	public final void setValue(String value) {
		set("value", value);
	}

	public List<XMLElement> getCategorizedFlowElements() {
		return getCategorizedFlowElements(true);
	}

	public List<XMLElement> getCategorizedFlowElements(boolean refresh) {
		if (refresh) {
			categorizedFlowElements.clear();
			categorizedFlowElements.addAll(BPMNModelUtils.getCategorizedFlowElements(this));
		}
		return categorizedFlowElements;
	}

	public final void setCategorizedFlowElements(List<XMLElement> flowElements) {
		categorizedFlowElements.clear();
		categorizedFlowElements.addAll(flowElements);
	}

	public String toString() {
		Category category = getParent().getParent();
		if (category.getName().length() == 0) {
			return getValue();
		} else {
			return category.getName() + ":" + getValue();
		}
	}

}

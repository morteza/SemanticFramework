package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.HashSet;
import java.util.Set;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.process.Auditing;
import org.yaoqiang.model.bpmn.elements.process.Monitoring;

/**
 * FlowElement
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class FlowElement extends BaseElement {

	private static final long serialVersionUID = -7253844312084888055L;

	public FlowElement(FlowElements parent) {
		super(parent);
	}

	public FlowElement(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		Auditing refAuditing = new Auditing(this);
		Monitoring refMonitoring = new Monitoring(this);
		XMLTextElements refCategoryValueRef = new XMLTextElements(this, "categoryValueRef");

		super.fillStructure();
		add(attrName);
		add(refAuditing);
		add(refMonitoring);
		add(refCategoryValueRef);
	}

	public FlowElements getParent() {
		return (FlowElements) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final XMLTextElements getCategoryValueRefs() {
		return (XMLTextElements) get("categoryValueRef");
	}

	public final Set<String> getCategoryValueRefSet() {
		Set<String> refs = new HashSet<String>();
		for (XMLElement element : getCategoryValueRefs().getXMLElements()) {
			refs.add(element.toValue());
		}
		return refs;
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final XMLTextElements setCategoryValueRefs(XMLTextElements categoryValueRefs) {
		getCategoryValueRefs().clear();
		if (categoryValueRefs != null) {
			getCategoryValueRefs().addAll(categoryValueRefs.getXMLElements());
		}
		return categoryValueRefs;
	}

	public final void addCategoryValueRef(String categoryValueId) {
		XMLElement categoryValueRef = getCategoryValueRefs().generateNewElement();
		categoryValueRef.setValue(categoryValueId);
		getCategoryValueRefs().add(categoryValueRef);
	}

	public void removeCategoryValueRef(String categoryValueId) {
		getCategoryValueRefs().remove(categoryValueId);
	}

	public boolean isGraphicalElement() {
		return true;
	}

}

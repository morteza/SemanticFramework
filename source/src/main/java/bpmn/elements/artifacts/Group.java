package org.yaoqiang.model.bpmn.elements.artifacts;

import org.yaoqiang.model.XMLAttribute;

/**
 * Group
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Group extends Artifact {

	private static final long serialVersionUID = -6736173377709697906L;

	public Group() {
		this((Artifacts) null);
	}
	
	public Group(Artifacts parent) {
		super(parent, "group");
	}

	protected void fillStructure() {
		XMLAttribute attrCategoryValueRef = new XMLAttribute(this, "categoryValueRef");

		super.fillStructure();
		add(attrCategoryValueRef);
	}

	public Artifacts getParent() {
		return (Artifacts) parent;
	}
	
	public final String getCategoryValueRef() {
		return get("categoryValueRef").toValue();
	}

	public final void setCategoryValueRef(String id) {
		set("categoryValueRef", id);
	}
	
}

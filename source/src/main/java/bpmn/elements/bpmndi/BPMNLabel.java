package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;

/**
 * BPMNLabel
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNLabel extends XMLComplexElement {

	private static final long serialVersionUID = 3900599149505379298L;

	public BPMNLabel(BPMNEdge parent) {
		super(parent);
	}

	public BPMNLabel(BPMNShape parent) {
		super(parent);
	}

	protected void fillStructure() {
		XMLAttribute attrId = new XMLAttribute(this, "id");
		XMLAttribute attrLabelStyle = new XMLAttribute(this, "labelStyle");
		Bounds refBounds = new Bounds(this);
		
		add(attrId);
		add(attrLabelStyle);
		add(refBounds);
	}

	public String getId() {
		return get("id").toValue();
	}

	public void setId(String id) {
		set("id", id);
	}

	public String getLabelStyle() {
		return get("labelStyle").toValue();
	}

	public void setLabelStyle(String labelStyle) {
		set("labelStyle", labelStyle);
	}

	public Bounds getBounds() {
		return (Bounds) get("Bounds");
	}
	
}

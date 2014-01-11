package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;

/**
 * BPMNShape
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNShape extends XMLComplexElement {

	private static final long serialVersionUID = -3332793096319871779L;

	public BPMNShape(BPMNShapes parent) {
		super(parent);
	}

	protected void fillStructure() {
		XMLAttribute attrId = new XMLAttribute(this, "id");
		XMLAttribute attrBpmnElement = new XMLAttribute(this, "bpmnElement");
		XMLAttribute attrIsHorizontal = new XMLAttribute(this, "isHorizontal");
		XMLAttribute attrIsMarkerVisible = new XMLAttribute(this, "isMarkerVisible");
		XMLAttribute attrIsExpanded = new XMLAttribute(this, "isExpanded", "true");
		XMLAttribute attrChoreographyActivityShape = new XMLAttribute(this, "choreographyActivityShape");
		XMLAttribute attrParticipantBandKind = new XMLAttribute(this, "participantBandKind");
		Bounds refBounds = new Bounds(this);
		BPMNLabel refBPMNLabel = new BPMNLabel(this);

		add(attrId);
		add(attrBpmnElement);
		add(attrIsHorizontal);
		add(attrIsMarkerVisible);
		add(attrIsExpanded);
		add(attrChoreographyActivityShape);
		add(attrParticipantBandKind);
		add(refBounds);
		add(refBPMNLabel);
	}

	public BPMNShapes getParent() {
		return (BPMNShapes) parent;
	}

	public Bounds getBounds() {
		return (Bounds) get("Bounds");
	}

	public BPMNLabel getBPMNLabel() {
		return (BPMNLabel) get("BPMNLabel");
	}

	public final Bounds getLabelBounds() {
		return (Bounds) getBPMNLabel().get("Bounds");
	}

	public String getId() {
		return get("id").toValue();
	}

	public String getChoreographyActivityShape() {
		return get("choreographyActivityShape").toValue();
	}

	public String getParticipantBandKind() {
		return get("participantBandKind").toValue();
	}

	public final boolean isHorizontal() {
		XMLElement horizontal = get("isHorizontal");
		if (horizontal == null || horizontal.toValue().length() == 0) {
			return true;
		} else {
			return Boolean.parseBoolean(horizontal.toValue());
		}
	}

	public final boolean isMarkerVisible() {
		XMLElement visible = get("isMarkerVisible");
		if (visible == null || visible.toValue().length() == 0) {
			return true;
		} else {
			return Boolean.parseBoolean(visible.toValue());
		}
	}

	public final boolean isExpanded() {
		XMLElement expanded = get("isExpanded");
		if (expanded == null || expanded.toValue().length() == 0) {
			return false;
		} else {
			return Boolean.parseBoolean(expanded.toValue());
		}
	}

	public final void setExpanded(boolean expanded) {
		set("isExpanded", String.valueOf(expanded));
	}

	public final void setHorizontal(boolean horizontal) {
		set("isHorizontal", String.valueOf(horizontal));
	}

	public final String getBpmnElement() {
		return get("bpmnElement").toValue();
	}

	public final void setBpmnElement(String bpmnElement) {
		set("bpmnElement", bpmnElement);
	}

}

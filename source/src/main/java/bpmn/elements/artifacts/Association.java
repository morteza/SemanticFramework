package org.yaoqiang.model.bpmn.elements.artifacts;

import org.yaoqiang.model.XMLAttribute;

/**
 * Association
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Association extends Artifact {

	private static final long serialVersionUID = -3540877095970278706L;

	public class Direction {
		public static final String NONE = "None";
		public static final String ONE = "One";
		public static final String Both = "Both";
	}

	public Association(Artifacts parent) {
		super(parent, "association");
	}

	protected void fillStructure() {
		XMLAttribute attrSourceRef = new XMLAttribute(this, "sourceRef");
		XMLAttribute attrTargetRef = new XMLAttribute(this, "targetRef");
		XMLAttribute attrAssociationDirection = new XMLAttribute(this, "associationDirection", Association.Direction.NONE);

		super.fillStructure();
		add(attrSourceRef);
		add(attrTargetRef);
		add(attrAssociationDirection);
	}

	public Artifacts getParent() {
		return (Artifacts) parent;
	}

	public final String getSourceRef() {
		return get("sourceRef").toValue();
	}

	public final String getTargetRef() {
		return get("targetRef").toValue();
	}

	public final void setSourceRef(String sourceRef) {
		set("sourceRef", sourceRef);
	}

	public final void setTargetRef(String targetRef) {
		set("targetRef", targetRef);
	}

	public final void setAssociationDirection(String associationDirection) {
		set("associationDirection", associationDirection);
	}

}

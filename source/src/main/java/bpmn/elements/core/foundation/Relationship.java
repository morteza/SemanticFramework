package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLTextElements;

/**
 * Relationship
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Relationship extends BaseElement {

	private static final long serialVersionUID = 1360418180177828146L;

	public class Direction {
		public static final String NONE = "None";
		public static final String FORWARD = "Forward";
		public static final String BACKWARD = "Backward";
		public static final String BOTH = "Both";
	}

	public Relationship(Relationships parent) {
		super(parent, "relationship");
	}

	protected void fillStructure() {
		XMLAttribute attrType = new XMLAttribute(this, "type");
		XMLAttribute attrDirection = new XMLAttribute(this, "direction");
		XMLTextElements refSources = new XMLTextElements(this, "source");
		XMLTextElements refTargets = new XMLTextElements(this, "target");

		super.fillStructure();
		add(attrType);
		add(attrDirection);
		add(refSources);
		add(refTargets);
	}

	public Relationships getParent() {
		return (Relationships) parent;
	}

}

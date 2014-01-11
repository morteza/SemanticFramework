package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;

/**
 * Waypoint
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Waypoint extends XMLComplexElement {

	private static final long serialVersionUID = 304015214142068625L;

	public Waypoint(Waypoints parent) {
		super(parent, "waypoint");
	}

	protected void fillStructure() {
		XMLAttribute attrX = new XMLAttribute(this, "x");
		XMLAttribute attrY = new XMLAttribute(this, "y");

		add(attrX);
		add(attrY);
	}

	public Waypoints getParent() {
		return (Waypoints) parent;
	}

	public double getX() {
		try {
			return Double.parseDouble(get("x").toValue());
		} catch (Exception e) {
			return 0;
		}
	}

	public double getY() {
		try {
			return Double.parseDouble(get("y").toValue());
		} catch (Exception e) {
			return 0;
		}
	}

	public void setX(double x) {
		set("x", String.valueOf(x));
	}

	public void setY(double y) {
		set("y", String.valueOf(y));
	}

}

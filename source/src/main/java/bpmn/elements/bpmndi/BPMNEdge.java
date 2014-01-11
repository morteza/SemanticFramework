package org.yaoqiang.model.bpmn.elements.bpmndi;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;

/**
 * BPMNEdge
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNEdge extends XMLComplexElement {

	private static final long serialVersionUID = 7326356879770991639L;

	public BPMNEdge(BPMNEdges parent) {
		super(parent);
	}

	protected void fillStructure() {
		XMLAttribute attrId = new XMLAttribute(this, "id");
		XMLAttribute attrBpmnElement = new XMLAttribute(this, "bpmnElement");
		XMLAttribute attrSourceElement = new XMLAttribute(this, "sourceElement");
		XMLAttribute attrTargetElement = new XMLAttribute(this, "targetElement");
		XMLAttribute attrMessageVisibleKind = new XMLAttribute(this, "messageVisibleKind");
		Waypoints refWaypoints = new Waypoints(this);
		BPMNLabel refBPMNLabel = new BPMNLabel(this);

		add(attrId);
		add(attrBpmnElement);
		add(attrSourceElement);
		add(attrTargetElement);
		add(attrMessageVisibleKind);
		add(refWaypoints);
		add(refBPMNLabel);

	}
	
	public BPMNEdges getParent() {
		return (BPMNEdges) parent;
	}
	
	public final String getId() {
		return get("id").toValue();
	}

	public final String getBpmnElement() {
		return get("bpmnElement").toValue();
	}

	public final String getSourceElement() {
		return get("sourceElement").toValue();
	}
	
	public final String getTargetElement() {
		return get("targetElement").toValue();
	}
	
	public final String getMessageVisibleKind() {
		return get("messageVisibleKind").toValue();
	}
	
	public List<Point> getWaypoints() {
		List<XMLElement> waypoints = ((XMLCollectionElement) get("Waypoints")).getXMLElements();
		Point point = null;
		List<Point> points = new ArrayList<Point>();
		for (XMLElement p : waypoints) {
			point = new Point();
			point.setLocation(((Waypoint) p).getX(), ((Waypoint) p).getY());
			points.add(point);
		}
		return points;
	}

	public final BPMNLabel getBPMNLabel() {
		return (BPMNLabel) get("BPMNLabel");
	}
	
	public final Bounds getLabelBounds() {
		return (Bounds)getBPMNLabel().get("Bounds");
	}
	
	public final void setBpmnElement(String bpmnElement) {
		set("bpmnElement", bpmnElement);
	}
	
}

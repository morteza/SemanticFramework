package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;

/**
 * BPMNDiagram
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNDiagram extends XMLComplexElement {

	private static final long serialVersionUID = -5753725146332654716L;

	public BPMNDiagram(BPMNDiagrams parent) {
		super(parent);
	}

	protected void fillStructure() {
		XMLAttribute attrId = new XMLAttribute(this, "id");
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrDocumentation = new XMLAttribute(this, "documentation");
		XMLAttribute attrResolution = new XMLAttribute(this, "resolution");
		BPMNPlane refBPMNPlane = new BPMNPlane(this);

		add(attrId);
		add(attrName);
		add(attrDocumentation);
		add(attrResolution);
		add(refBPMNPlane);
	}

	public BPMNDiagrams getParent() {
		return (BPMNDiagrams) parent;
	}

	public final BPMNPlane getBPMNPlane() {
		return (BPMNPlane) get("BPMNPlane");
	}

	public final String getId() {
		return get("id").toValue();
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getDocumentation() {
		return get("documentation").toValue();
	}

	public final String getResolution() {
		return get("resolution").toValue();
	}

	public final XMLComplexElement getShapeByBpmnElement(String bpmnElement) {
		for (XMLElement e : getBPMNPlane().getBPMNShapes()) {
			BPMNShape shape = (BPMNShape) e;
			if (shape.getBpmnElement().equals(bpmnElement)) {
				return shape;
			}
		}
		for (XMLElement e : getBPMNPlane().getBPMNEdges()) {
			BPMNEdge edge = (BPMNEdge) e;
			if (edge.getBpmnElement().equals(bpmnElement)) {
				return edge;
			}
		}
		return null;
	}

	public final void setId(String id) {
		set("id", id);
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setDocumentation(String documentation) {
		set("documentation", documentation);
	}

}

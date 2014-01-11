package org.yaoqiang.model.bpmn.elements.bpmndi;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;

/**
 * BPMNPlane
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNPlane extends XMLComplexElement {

	private static final long serialVersionUID = 9170109785031931874L;

	public BPMNPlane(BPMNDiagram parent) {
		super(parent);
	}

	protected void fillStructure() {
		XMLAttribute attrBpmnElement = new XMLAttribute(this, "bpmnElement");
		BPMNShapes refBPMNShapes = new BPMNShapes(this);
		BPMNEdges refBPMNEdges = new BPMNEdges(this);

		add(attrBpmnElement);
		add(refBPMNShapes);
		add(refBPMNEdges);
	}

	public final String getBpmnElement() {
		return get("bpmnElement").toValue();
	}
	
	public final void setBpmnElement(String bpmnElement) {
		set("bpmnElement", bpmnElement);
	}
	
	public final List<XMLElement> getBPMNShapes() {
		return ((BPMNShapes) get("BPMNShapes")).getXMLElements();
	}

	public final List<XMLElement> getBPMNEdges() {
		return ((BPMNEdges) get("BPMNEdges")).getXMLElements();
	}
}

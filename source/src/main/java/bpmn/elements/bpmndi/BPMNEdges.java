package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * BPMNEdges
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNEdges extends XMLCollectionElement {

	private static final long serialVersionUID = -6559720202835996051L;

	public BPMNEdges(BPMNPlane parent) {
		super(parent);
	}

	public XMLElement generateNewElement() {
		return new BPMNEdge(this);
	}

	public String getElementName() {
		return "BPMNEdge";
	}
	
}

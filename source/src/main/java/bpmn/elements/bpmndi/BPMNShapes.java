package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * BPMNShapes
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNShapes extends XMLCollectionElement {

	private static final long serialVersionUID = -777649886163761757L;

	public BPMNShapes(BPMNPlane parent) {
		super(parent);
	}

	public XMLElement generateNewElement() {
		return new BPMNShape(this);
	}

	public String getElementName() {
		return "BPMNShape";
	}
}

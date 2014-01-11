package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.infrastructure.Definitions;

/**
 * BPMNDiagrams
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNDiagrams extends XMLCollectionElement {

	private static final long serialVersionUID = -2801405664506136858L;

	public BPMNDiagrams(Definitions parent) {
		super(parent, "diagrams");
	}

	public XMLElement generateNewElement() {
		return new BPMNDiagram(this);
	}

	public String getElementName() {
		return "BPMNDiagram";
	}
	
}

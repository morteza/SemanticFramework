package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * InputSets
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class InputSets extends XMLCollectionElement {

	private static final long serialVersionUID = -897027052470793413L;

	public InputSets(InputOutputSpecification parent) {
		super(parent, "inputSets");
	}

	public XMLElement generateNewElement() {
		return new InputSet(this);
	}
	
	public String getElementName() {
		return "inputSet";
	}

	public InputOutputSpecification getParent() {
		return (InputOutputSpecification) parent;
	}

}

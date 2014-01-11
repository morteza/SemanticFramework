package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * OutputSets
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class OutputSets extends XMLCollectionElement {

	private static final long serialVersionUID = 7924506839849429224L;

	public OutputSets(InputOutputSpecification parent) {
		super(parent, "outputSets");
	}

	public XMLElement generateNewElement() {
		return new OutputSet(this);
	}

	public String getElementName() {
		return "outputSet";
	}

	public InputOutputSpecification getParent() {
		return (InputOutputSpecification) parent;
	}

}

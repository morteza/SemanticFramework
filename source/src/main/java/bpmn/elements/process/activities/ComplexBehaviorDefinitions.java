package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * ComplexBehaviorDefinitions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ComplexBehaviorDefinitions extends XMLCollectionElement {

	private static final long serialVersionUID = 2171623312824428169L;

	public ComplexBehaviorDefinitions(MultiInstanceLoopCharacteristics parent) {
		super(parent);
	}
	
	public XMLElement generateNewElement() {
		return new ComplexBehaviorDefinition(this);
	}

	public String getElementName() {
		return "complexBehaviorDefinition";
	}

}

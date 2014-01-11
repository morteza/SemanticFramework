package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * CorrelationKeys
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationKeys extends XMLCollectionElement {

	private static final long serialVersionUID = 8703415723006823623L;

	public CorrelationKeys(XMLElement parent) {
		super(parent);
	}
	
	public XMLElement generateNewElement() {
		return new CorrelationKey(this);
	}

	public String getElementName() {
		return "correlationKey";
	}
	
}

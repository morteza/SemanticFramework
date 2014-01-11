package org.yaoqiang.model.bpmn.elements.process;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * LaneSets
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class LaneSets extends XMLCollectionElement {

	private static final long serialVersionUID = -7302397874844048415L;

	public LaneSets(XMLElement parent) {
		super(parent, "laneSets");
	}

	public XMLElement generateNewElement() {
		return new LaneSet(this);
	}

	public String getElementName() {
		return "laneSet";
	}
	
	public boolean isEmpty() {
		return getXMLElements().isEmpty() || getXMLElements().get(0).isEmpty();
	}
	
}

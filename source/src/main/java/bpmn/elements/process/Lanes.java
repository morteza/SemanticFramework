package org.yaoqiang.model.bpmn.elements.process;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Lanes
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Lanes extends XMLCollectionElement {

	private static final long serialVersionUID = 3010267841288945630L;

	public Lanes(LaneSet parent) {
		super(parent, "lanes");
	}

	public XMLElement generateNewElement() {
		return new Lane(this);
	}

	public String getElementName() {
		return "lane";
	}

	public LaneSet getParent() {
		return (LaneSet) parent;
	}

}

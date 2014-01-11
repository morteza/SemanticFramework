package org.yaoqiang.model.bpmn.elements.bpmndi;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Waypoints
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Waypoints extends XMLCollectionElement {

	private static final long serialVersionUID = -1014414462511795048L;

	public Waypoints(BPMNEdge parent) {
		super(parent);
	}

	public XMLElement generateNewElement() {
		return new Waypoint(this);
	}

	public String getElementName() {
		return "waypoint";
	}
	
}

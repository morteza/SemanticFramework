package org.yaoqiang.model.bpmn.elements.process;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * LaneSet
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class LaneSet extends BaseElement {

	private static final long serialVersionUID = -8568383499082954972L;

	public LaneSet(LaneSets parent) {
		super(parent, "laneSet");
	}

	public LaneSet(Lane parent) {
		super(parent, "childLaneSet");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		Lanes refLanes = new Lanes(this);

		super.fillStructure();
		add(attrName);
		add(refLanes);
	}

	public final Lanes getLanes() {
		return (Lanes) get("lanes");
	}

	public final List<XMLElement> getLaneList() {
		return getLanes().getXMLElements();
	}

	public final void addLane(Lane lane) {
		getLanes().add(lane);
	}

	public final Lane addLane(String id, String name) {
		Lane lane = (Lane) getLanes().generateNewElement();
		lane.setId(id);
		lane.setName(name);
		getLanes().add(lane);
		return lane;
	}
	
	public boolean isEmpty() {
		return getLanes().isEmpty();
	}
	
}

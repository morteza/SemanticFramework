package org.yaoqiang.model.bpmn.elements.process;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Lane
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Lane extends BaseElement {

	private static final long serialVersionUID = 4384914720128074794L;

	public Lane(String name) {
		this((Lanes) null);
		setName(name);
	}

	public Lane(Lanes parent) {
		super(parent, "lane");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrPartitionElementRef = new XMLAttribute(this, "partitionElementRef");
		XMLTextElements refFlowNodeRefs = new XMLTextElements(this, "flowNodeRef");
		LaneSet refChildLaneSet = new LaneSet(this);

		super.fillStructure();
		add(attrName);
		add(attrPartitionElementRef);
		add(refFlowNodeRefs);
		add(refChildLaneSet);
	}

	public Lanes getParent() {
		return (Lanes) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final LaneSet getChildLaneSet() {
		return (LaneSet) get("childLaneSet");
	}

	public final void addChildLane(Lane lane) {
		getChildLaneSet().addLane(lane);
	}

	public final XMLTextElements getFlowNodeRef() {
		return (XMLTextElements) get("flowNodeRef");
	}

	public final List<XMLElement> getFlowNodeList() {
		return getFlowNodeRef().getXMLElements();
	}

	public final List<String> getFlowNodeRefs() {
		List<String> refs = new ArrayList<String>();
		for (XMLElement ref : getFlowNodeList()) {
			refs.add(ref.toValue());
		}
		return refs;
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void addFlowNodeRef(String flowNodeid) {
		XMLElement flowNodeRef = getFlowNodeRef().generateNewElement();
		flowNodeRef.setValue(flowNodeid);
		getFlowNodeRef().add(flowNodeRef);
	}

	public void removeFlowNodeRef(String value) {
		getFlowNodeRef().remove(value);
	}

	public boolean isGraphicalElement() {
		return true;
	}

	public String toString() {
		return getName();
	}

}

package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Assignments
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Assignments extends XMLCollectionElement {

	private static final long serialVersionUID = 6093454934573051883L;

	public Assignments(DataAssociation parent) {
		super(parent, "assignments");
	}
	
	public XMLElement generateNewElement() {
		Assignment assignment = new Assignment(this);
		assignment.setId(createId(getParent().getId() + "_A"));
		return assignment;
	}

	public String getElementName() {
		return "assignment";
	}
	
	public DataAssociation getParent() {
		return (DataAssociation) parent;
	}

}

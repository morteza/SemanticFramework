package org.yaoqiang.model.bpmn.elements.process.data;

import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.common.FormalExpression;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataAssociation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataAssociation extends BaseElement {

	private static final long serialVersionUID = 3607266151803729480L;

	public DataAssociation(XMLElement parent) {
		super(parent);
	}

	public DataAssociation(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLTextElements refSourceRef = new XMLTextElements(this, "sourceRef");
		XMLTextElement refTargetRef = new XMLTextElement(this, "targetRef");
		FormalExpression refTransformation = new FormalExpression(this, "transformation");
		Assignments refAssignments = new Assignments(this);

		super.fillStructure();
		add(refSourceRef);
		add(refTargetRef);
		add(refTransformation);
		add(refAssignments);
	}

	public final XMLTextElements getSourceRefs() {
		return (XMLTextElements) get("sourceRef");
	}

	public final String getSourceRef() {
		for (XMLElement sourceRef : getSourceRefs().getXMLElements()) {
			return sourceRef.toValue();
		}
		return "";
	}

	public final String getTargetRef() {
		return get("targetRef").toValue();
	}

	public final Assignments getAssignments() {
		return (Assignments) get("assignments");
	}

	public final List<XMLElement> getAssignmentList() {
		return getAssignments().getXMLElements();
	}

	public final void addSourceRef(String sourceId) {
		XMLElement sourceRef = getSourceRefs().generateNewElement();
		sourceRef.setValue(sourceId);
		getSourceRefs().add(sourceRef);
	}

	public final void setTargetRef(String targetId) {
		set("targetRef", targetId);
	}

	public boolean isGraphicalElement() {
		return getId().startsWith("_");
	}

}

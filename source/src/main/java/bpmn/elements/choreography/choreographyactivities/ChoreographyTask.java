package org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities;

import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * ChoreographyTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ChoreographyTask extends ChoreographyActivity {

	private static final long serialVersionUID = 4460476928419342628L;

	public ChoreographyTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ChoreographyTask(FlowElements parent) {
		super(parent, "choreographyTask");
	}

	protected void fillStructure() {
		XMLTextElements refMessageFlowRef = new XMLTextElements(this, "messageFlowRef");

		super.fillStructure();
		add(refMessageFlowRef);
	}

	public final XMLTextElements getMessageFlowRefs() {
		return (XMLTextElements) get("messageFlowRef");
	}

	public final List<XMLElement> getMessageFlowRefList() {
		return getMessageFlowRefs().getXMLElements();
	}

	public final void addMessageFlowRef(String messageFlowId) {
		XMLElement messageFlowRef = getMessageFlowRefs().generateNewElement();
		messageFlowRef.setValue(messageFlowId);
		getMessageFlowRefs().add(messageFlowRef);
	}

	public final void clearMessageFlowRefs() {
		getMessageFlowRefs().clear();
	}

}

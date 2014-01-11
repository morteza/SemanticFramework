package org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.common.CorrelationKeys;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;

/**
 * ChoreographyActivity
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class ChoreographyActivity extends FlowNode {

	private static final long serialVersionUID = -3577828963046254753L;

	public class LoopType {
		public static final String NONE = "None";
		public static final String STANDARD = "Standard";
		public static final String MULTIINSTANCESEQUENTIAL = "MultiInstanceSequential";
		public static final String MULTIINSTANCEPARALLEL = "MultiInstanceParallel";
	}

	public ChoreographyActivity(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrInitiatingParticipantRef = new XMLAttribute(this, "initiatingParticipantRef");
		XMLAttribute attrLoopType = new XMLAttribute(this, "loopType", LoopType.NONE);
		XMLTextElements refParticipantRefs = new XMLTextElements(this, "participantRef");
		CorrelationKeys refCorrelationKeys = new CorrelationKeys(this);

		super.fillStructure();
		add(attrInitiatingParticipantRef);
		add(attrLoopType);
		add(refParticipantRefs);
		add(refCorrelationKeys);
	}

	public String getLoopType() {
		return get("loopType").toValue();
	}

	public final String getInitiatingParticipantRef() {
		return get("initiatingParticipantRef").toValue();
	}

	public final XMLTextElements getParticipantRefs() {
		return (XMLTextElements) get("participantRef");
	}

	public final List<XMLElement> getParticipantRefList() {
		return getParticipantRefs().getXMLElements();
	}

	public final List<String> getParticipantList() {
		List<String> partList = new ArrayList<String>();
		for (XMLElement participantRef : getParticipantRefList()) {
			partList.add(participantRef.toValue());
		}
		return partList;
	}

	public final void addParticipantRef(String participantId) {
		XMLElement participantRef = getParticipantRefs().generateNewElement();
		participantRef.setValue(participantId);
		getParticipantRefs().add(participantRef);
	}

	public final void removeParticipantRef(String participantId) {
		getParticipantRefs().remove(participantId);
	}

	public final void setInitiatingParticipantRef(String initiatingParticipantRef) {
		set("initiatingParticipantRef", initiatingParticipantRef);
	}

	public final void setLoopType(String loopType) {
		set("loopType", loopType);
	}

}

package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.collaboration.Participant;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * PartnerRole
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class PartnerRole extends BaseElement implements RootElement {

	private static final long serialVersionUID = 7955291380075142439L;

	public PartnerRole(RootElements parent) {
		super(parent, "partnerRole");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refParticipantRef = new XMLTextElements(this, "participantRef");

		super.fillStructure();
		add(attrName);
		add(refParticipantRef);
	}

	public final XMLTextElements getParticipantRefs() {
		return (XMLTextElements) get("participantRef");
	}
	
	public final List<XMLElement> getParticipantRefList() {
		return getParticipantRefs().getXMLElements();
	}
	
	public final List<XMLElement> getRefParticipantList() {
		List<XMLElement> els = new ArrayList<XMLElement>();
		for (XMLElement partRef: getParticipantRefList()) {
			Participant part = BPMNModelUtils.getDefinitions(parent).getParticipant(partRef.toValue());
			if (part != null) {
				els.add(part);
			}
		}
		return els;
	}
	
}

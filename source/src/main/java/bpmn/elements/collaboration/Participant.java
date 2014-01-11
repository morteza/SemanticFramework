package org.yaoqiang.model.bpmn.elements.collaboration;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.service.Interface;

/**
 * Participant
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Participant extends BaseElement {

	private static final long serialVersionUID = -7710047500920385992L;

	public Participant(String name) {
		this((Participants) null);
		setName(name);
	}

	public Participant(Participants parent) {
		super(parent, "participant");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrProcessRef = new XMLAttribute(this, "processRef");
		XMLTextElements refInterfaceRef = new XMLTextElements(this, "interfaceRef");
		XMLTextElements refEndPointRef = new XMLTextElements(this, "endPointRef");
		ParticipantMultiplicity refParticipantMultiplicity = new ParticipantMultiplicity(this);

		super.fillStructure();
		add(attrName);
		add(attrProcessRef);
		add(refInterfaceRef);
		add(refEndPointRef);
		add(refParticipantMultiplicity);
	}

	public Participants getParent() {
		return (Participants) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final XMLTextElements getInterfaceRefs() {
		return (XMLTextElements) get("interfaceRef");
	}

	public final List<XMLElement> getInterfaceRefList() {
		return getInterfaceRefs().getXMLElements();
	}

	public final List<XMLElement> getRefInterfaceList() {
		List<XMLElement> els = new ArrayList<XMLElement>();
		for (XMLElement ifRef : getInterfaceRefList()) {
			Interface er = BPMNModelUtils.getDefinitions(parent).getInterface(ifRef.toValue());
			if (er != null) {
				els.add(er);
			}
		}
		return els;
	}

	public final String getProcessRef() {
		return get("processRef").toValue();
	}

	public final ParticipantMultiplicity getParticipantMultiplicity() {
		return (ParticipantMultiplicity) get("participantMultiplicity");
	}

	public final int getMultiplicity() {
		return getParticipantMultiplicity().getMaximum();
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setProcessRef(String processRef) {
		set("processRef", processRef);
	}

	public final void setMultiplicity(String name) {
		getParticipantMultiplicity().setMaximum(name);
	}

	public String toString() {
		return getName();
	}

}

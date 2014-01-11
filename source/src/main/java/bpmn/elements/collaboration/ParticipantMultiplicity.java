package org.yaoqiang.model.bpmn.elements.collaboration;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ParticipantMultiplicity
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ParticipantMultiplicity extends BaseElement {

	private static final long serialVersionUID = -997676600352830945L;

	public ParticipantMultiplicity(Participant parent) {
		super(parent, "participantMultiplicity");
	}

	protected void fillStructure() {
		XMLAttribute attrMinimum = new XMLAttribute(this, "minimum", "0");
		XMLAttribute attrMaximum = new XMLAttribute(this, "maximum", "1");
		
		super.fillStructure();
		add(attrMinimum);
		add(attrMaximum);
	}

	public final XMLAttribute getMaximumAttr() {
		return (XMLAttribute) get("maximum");
	}

	public final void setMaximum(String maximum) {
		set("maximum", maximum);
	}
	
	public int getMaximum() {
		try {
			if (getMaximumAttr().toValue() == null) {
				return -1;
			}
			return Integer.parseInt(getMaximumAttr().toValue());
		} catch (Exception e){
			return -1;
		}
	}
	
}

package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;

/**
 * EscalationEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class EscalationEventDefinition extends EventDefinition {

	private static final long serialVersionUID = 7343492045622725632L;

	public EscalationEventDefinition(XMLElement parent) {
		super(parent, "escalationEventDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrEscalationRef = new XMLAttribute(this, "escalationRef");

		super.fillStructure();
		add(attrEscalationRef);
	}

	public final String getEscalationRef() {
		return get("escalationRef").toValue();
	}

	public final void setEscalationRef(String escalationRef) {
		set("escalationRef", escalationRef);
	}
	
}

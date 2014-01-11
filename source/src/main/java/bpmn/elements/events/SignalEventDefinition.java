package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;

/**
 * SignalEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class SignalEventDefinition extends EventDefinition {

	private static final long serialVersionUID = -3597321933482505580L;

	public SignalEventDefinition(XMLElement parent) {
		super(parent, "signalEventDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrSignalRef = new XMLAttribute(this, "signalRef");

		super.fillStructure();
		add(attrSignalRef);
	}
	
	public final String getSignalRef() {
		return get("signalRef").toValue();
	}

	public final void setSignalRef(String signalRef) {
		set("signalRef", signalRef);
	}
	
}

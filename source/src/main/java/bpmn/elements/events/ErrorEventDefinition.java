package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;

/**
 * ErrorEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ErrorEventDefinition extends EventDefinition {

	private static final long serialVersionUID = 6022698592026953116L;

	public ErrorEventDefinition(XMLElement parent) {
		super(parent, "errorEventDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrErrorRef = new XMLAttribute(this, "errorRef");

		super.fillStructure();
		add(attrErrorRef);
	}

	public final String getErrorRef() {
		return get("errorRef").toValue();
	}

	public final void setErrorRef(String errorRef) {
		set("errorRef", errorRef);
	}
	
}

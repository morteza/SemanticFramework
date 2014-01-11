package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Escalation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Escalation extends BaseElement implements RootElement {

	private static final long serialVersionUID = 3296727150659152007L;

	public Escalation(RootElements parent) {
		super(parent, "escalation");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrErrorCode = new XMLAttribute(this, "escalationCode");
		XMLAttribute attrStructureRef = new XMLAttribute(this, "structureRef");

		super.fillStructure();
		add(attrName);
		add(attrErrorCode);
		add(attrStructureRef);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getEscalationCode() {
		return get("escalationCode").toValue();
	}

	public final String getStructureRef() {
		return get("structureRef").toValue();
	}

	public final void setName(String name) {
		set("name", name);
	}
	
	public final void setEscalationCode(String escalationCode) {
		set("escalationCode", escalationCode);
	}
	
	public final void setStructureRef(String structureRef) {
		set("structureRef", structureRef);
	}
	
}

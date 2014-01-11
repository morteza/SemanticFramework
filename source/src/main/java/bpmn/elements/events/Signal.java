package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * Signal
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Signal extends BaseElement implements RootElement {

	private static final long serialVersionUID = -4915173783319776620L;

	public Signal(RootElements parent) {
		super(parent, "signal");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrStructureRef = new XMLAttribute(this, "structureRef");

		super.fillStructure();
		add(attrName);
		add(attrStructureRef);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getStructureRef() {
		return get("structureRef").toValue();
	}

	public final void setName(String name) {
		set("name", name);
	}
	
	public final void setStructureRef(String structureRef) {
		set("structureRef", structureRef);
	}
	
}

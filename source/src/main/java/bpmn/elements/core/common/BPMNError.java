package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * BPMNError
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNError extends BaseElement implements RootElement {

	private static final long serialVersionUID = 4326190910729857586L;

	public BPMNError(RootElements parent) {
		super(parent, "error");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrErrorCode = new XMLAttribute(this, "errorCode");
		XMLAttribute attrStructureRef = new XMLAttribute(this, "structureRef");

		super.fillStructure();
		add(attrName);
		add(attrErrorCode);
		add(attrStructureRef);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getErrorCode() {
		return get("errorCode").toValue();
	}

	public final String getStructureRef() {
		return get("structureRef").toValue();
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setErrorCode(String errorCode) {
		set("errorCode", errorCode);
	}
	
	public final void setStructureRef(String structureRef) {
		set("structureRef", structureRef);
	}
	
}

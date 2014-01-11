package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;
import org.yaoqiang.model.elements.Import;

/**
 * ItemDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ItemDefinition extends BaseElement implements RootElement {

	private static final long serialVersionUID = -977950098425335861L;

	public class ItemKind {
		public static final String INFORMATION = "Information";
		public static final String PHYSICAL = "Physical";
	}

	public ItemDefinition(RootElements parent) {
		super(parent, "itemDefinition");
	}

	public ItemDefinition(FormalExpression parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrStructureRef = new XMLAttribute(this, "structureRef");
		XMLAttribute attrIsCollection = new XMLAttribute(this, "isCollection", Boolean.FALSE.toString());
		XMLAttribute attrItemKind = new XMLAttribute(this, "itemKind", ItemKind.INFORMATION);
		Import refImport = new Import(this);

		super.fillStructure();
		add(attrStructureRef);
		add(attrIsCollection);
		add(attrItemKind);
		add(refImport);
	}

	public final String getStructureRef() {
		return get("structureRef").toValue();
	}
	
	public final boolean isCollection() {
		return Boolean.parseBoolean(get("isCollection").toValue());
	}
	
	public final void setIsCollection(boolean isCollection) {
		set("isCollection", String.valueOf(isCollection));
	}
	
	public final void setStructureRef(String structureRef) {
		set("structureRef", structureRef);
	}

}

package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLExtensionElement;

/**
 * BaseElement
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class BaseElement extends XMLComplexElement {

	private static final long serialVersionUID = 5584043381727901731L;

	public BaseElement(XMLElement parent) {
		super(parent);
	}

	public BaseElement(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrId = new XMLAttribute(this, "id");
		Documentations refDocumentations = new Documentations(this);
		XMLExtensionElement refExtensionElements = new XMLExtensionElement(this, "extensionElements");
		ExtensionDefinitions refExtensionDefinitions = new ExtensionDefinitions(this);
		ExtensionAttributeValues refExtensionValues = new ExtensionAttributeValues(this);

		add(attrId);
		add(refDocumentations);
		add(refExtensionElements);
		add(refExtensionDefinitions);
		add(refExtensionValues);
	}

	public final String getId() {
		return get("id").toValue();
	}

	public final void setId(String id) {
		set("id", id);
	}

	public final Documentations getDocumentations() {
		return (Documentations) get("documentations");
	}

	public final XMLExtensionElement getExtensionElements() {
		return (XMLExtensionElement) get("extensionElements");
	}

	public final Documentations setDocumentations(Documentations documentations) {
		getDocumentations().clear();
		getDocumentations().addAll(documentations.getXMLElements());
		return documentations;
	}

	public boolean isGraphicalElement() {
		return false;
	}

	public String toString() {
		return get("name") != null && get("name").toValue().length() > 0 ? get("name").toValue() : getId();
	}

	public boolean equals(Object e) {
		boolean equals = super.equals(e);
		if (equals) {
			BaseElement el = (BaseElement) e;
			equals = getId().equals(el.getId());
		}
		return equals;
	}
}

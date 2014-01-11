package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.infrastructure.Definitions;

/**
 * Extensions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Extensions extends XMLCollectionElement {

	private static final long serialVersionUID = 5163569894552622512L;

	public Extensions(Definitions parent) {
		super(parent, "extensions");
	}

	public XMLElement generateNewElement() {
		return new Extension(this);
	}

	public String getElementName() {
		return "extension";
	}

	public Definitions getParent() {
		return (Definitions) parent;
	}

}

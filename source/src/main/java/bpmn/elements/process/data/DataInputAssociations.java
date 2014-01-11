package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataInputAssociations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataInputAssociations extends XMLCollectionElement {

	private static final long serialVersionUID = -3338651328601113174L;

	public DataInputAssociations(XMLElement parent) {
		super(parent, "dataInputAssociations");
	}

	public XMLElement generateNewElement() {
		DataInputAssociation dataInputAssociation = new DataInputAssociation(this);
		dataInputAssociation.setId(createId("DIA" + ((BaseElement) getParent()).getId()));
		return dataInputAssociation;
	}

	public String getElementName() {
		return "dataInputAssociation";
	}

}

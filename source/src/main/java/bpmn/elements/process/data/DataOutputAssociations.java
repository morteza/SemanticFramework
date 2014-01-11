package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataOutputAssociations
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataOutputAssociations extends XMLCollectionElement {

	private static final long serialVersionUID = -3440396224343612632L;

	public DataOutputAssociations(XMLElement parent) {
		super(parent, "dataOutputAssociations");
	}

	public XMLElement generateNewElement() {
		DataOutputAssociation dataOutputAssociation = new DataOutputAssociation(this);
		dataOutputAssociation.setId(createId("DOA" + ((BaseElement) getParent()).getId()));
		return dataOutputAssociation;
	}

	public String getElementName() {
		return "dataOutputAssociation";
	}

}

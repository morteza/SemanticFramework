package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataInputs
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataInputs extends XMLCollectionElement {

	private static final long serialVersionUID = -277949722717821095L;

	public DataInputs(XMLElement parent) {
		super(parent, "dataInputs");
	}
	
	public XMLElement generateNewElement() {
		DataInput dataInput = new DataInput(this);
		String id = null;
		if (getParent().getParent() instanceof BaseElement) {
			id = createId("Din" + ((BaseElement)getParent().getParent()).getId());
		} else {
			id = createId("Din" + ((BaseElement)getParent()).getId());
		}
		dataInput.setId(id);
		return dataInput;
	}

	public String getElementName() {
		return "dataInput";
	}

}

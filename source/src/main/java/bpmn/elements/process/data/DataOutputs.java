package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataOutputs
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataOutputs extends XMLCollectionElement {

	private static final long serialVersionUID = -5715987590530349239L;

	public DataOutputs(XMLElement parent) {
		super(parent, "dataOutputs");
	}
	
	public XMLElement generateNewElement() {
		DataOutput dataOutput = new DataOutput(this);
		String id = null;
		if (getParent().getParent() instanceof BaseElement) {
			id = createId("Dout" + ((BaseElement)getParent().getParent()).getId());
		} else {
			id = createId("Dout" + ((BaseElement)getParent()).getId());
		}
		dataOutput.setId(id);
		return dataOutput;
	}
	
	public String getElementName() {
		return "dataOutput";
	}

}

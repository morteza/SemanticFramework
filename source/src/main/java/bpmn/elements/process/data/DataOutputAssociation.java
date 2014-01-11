package org.yaoqiang.model.bpmn.elements.process.data;

import java.util.List;

import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.events.CatchEvent;

/**
 * DataOutputAssociation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataOutputAssociation extends DataAssociation {

	private static final long serialVersionUID = -5883363552041796212L;

	public DataOutputAssociation(DataOutputAssociations parent) {
		super(parent, "dataOutputAssociation");
	}

	public final List<XMLElement> getAvailableDataOutputs() {
		XMLComplexElement parent = (XMLComplexElement) getParent().getParent();
		if (parent instanceof CatchEvent) {
			return ((CatchEvent) parent).getDataOutputList();
		} else {
			return ((InputOutputSpecification) parent.get("ioSpecification")).getDataOutputs().getXMLElements();
		}
	}

	public DataOutputAssociations getParent() {
		return (DataOutputAssociations) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.process.data;

import java.util.List;

import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.events.ThrowEvent;

/**
 * DataInputAssociation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataInputAssociation extends DataAssociation {

	private static final long serialVersionUID = -6244302013361497904L;

	public DataInputAssociation(DataInputAssociations parent) {
		super(parent, "dataInputAssociation");
	}

	public final List<XMLElement> getAvailableDataInputs() {
		XMLComplexElement parent = (XMLComplexElement) getParent().getParent();
		if (parent instanceof ThrowEvent) {
			return ((ThrowEvent) parent).getDataInputList();
		} else {
			return ((InputOutputSpecification) parent.get("ioSpecification")).getDataInputs().getXMLElements();
		}
	}

	public DataInputAssociations getParent() {
		return (DataInputAssociations) parent;
	}

}

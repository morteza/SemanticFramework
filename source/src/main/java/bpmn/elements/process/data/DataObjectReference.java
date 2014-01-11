package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * DataObjectReference
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataObjectReference extends FlowElement implements ItemAwareElement {

	private static final long serialVersionUID = 5056348526025974192L;

	public DataObjectReference(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public DataObjectReference(FlowElements parent) {
		super(parent, "dataObjectReference");
	}

	protected void fillStructure() {
		XMLAttribute attrDataObjectRef = new XMLAttribute(this, "dataObjectRef");
		XMLAttribute attrItemSubjectRef = new XMLAttribute(this, "itemSubjectRef");
		DataState refDataState = new DataState(this);

		super.fillStructure();
		add(attrItemSubjectRef);
		add(attrDataObjectRef);
		add(refDataState);
	}

	public final String getDataObjectRef() {
		return get("dataObjectRef").toValue();
	}

	public final String getDataState() {
		return ((DataState) get("dataState")).getName();
	}

	public final DataObject getRefDataObject() {
		for (XMLElement obj : getParent().getAccessibleDataObjects()) {
			if (((DataObject) obj).getId().equals(getDataObjectRef())) {
				return (DataObject) obj;
			}
		}
		return null;
	}

	public final void setDataObjectRef(String dataObjectRef) {
		set("dataObjectRef", dataObjectRef);
	}

	public final void setDataState(String dataState) {
		((DataState) get("dataState")).setName(dataState);
	}

	public String toString() {
		return getRefDataObject().toString();
	}
}

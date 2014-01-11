package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * DataStoreReference
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataStoreReference extends FlowElement implements ItemAwareElement {

	private static final long serialVersionUID = -6862262129645999291L;

	public DataStoreReference() {
		this((FlowElements) null);
	}

	public DataStoreReference(FlowElements parent) {
		super(parent, "dataStoreReference");
	}

	protected void fillStructure() {
		XMLAttribute attrDataStoreRef = new XMLAttribute(this, "dataStoreRef");
		XMLAttribute attrItemSubjectRef = new XMLAttribute(this, "itemSubjectRef");
		DataState refDataState = new DataState(this);

		super.fillStructure();
		add(attrItemSubjectRef);
		add(attrDataStoreRef);
		add(refDataState);
	}
	
	public final String getDataStoreRef() {
		return get("dataStoreRef").toValue();
	}
	
	public final void setDataStoreRef(String dataStoreRef) {
		set("dataStoreRef", dataStoreRef);
	}
	
	public final String getDataState() {
		return ((DataState)get("dataState")).getName();
	}
	
	public final void setDataState(String dataState) {
		((DataState)get("dataState")).setName(dataState);
	}
	
}

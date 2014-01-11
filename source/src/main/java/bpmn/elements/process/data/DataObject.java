package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * DataObject
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataObject extends FlowElement implements ItemAwareElement {

	private static final long serialVersionUID = -4215633603526267600L;

	public DataObject(String name, boolean isCollection) {
		this((FlowElements) null);
		setName(name);
		setIsCollection(isCollection);
	}

	public DataObject(FlowElements parent) {
		super(parent, "dataObject");
	}

	protected void fillStructure() {
		XMLAttribute attrIsCollection = new XMLAttribute(this, "isCollection", Boolean.FALSE.toString());
		XMLAttribute attrItemSubjectRef = new XMLAttribute(this, "itemSubjectRef");
		DataState refDataState = new DataState(this);

		super.fillStructure();
		add(attrItemSubjectRef);
		add(refDataState);
		add(attrIsCollection);
	}

	public final boolean isCollection() {
		return Boolean.parseBoolean(get("isCollection").toValue());
	}

	public final void setIsCollection(boolean isCollection) {
		set("isCollection", String.valueOf(isCollection));
	}

	public final String getDataState() {
		return ((DataState) get("dataState")).getName();
	}

	public final void setDataState(String dataState) {
		((DataState) get("dataState")).setName(dataState);
	}

	public boolean isGraphicalElement() {
		return false;
	}

}

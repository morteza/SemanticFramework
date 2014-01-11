package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * DataStore
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataStore extends BaseElement implements RootElement, ItemAwareElement {

	private static final long serialVersionUID = -4770172579444031924L;

	public DataStore(RootElements parent) {
		super(parent, "dataStore");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrCapacity = new XMLAttribute(this, "capacity");
		XMLAttribute attrIsUnlimited = new XMLAttribute(this, "isUnlimited", Boolean.FALSE.toString());
		XMLAttribute attrItemSubjectRef = new XMLAttribute(this, "itemSubjectRef");
		DataState refDataState = new DataState(this);

		super.fillStructure();
		add(attrItemSubjectRef);
		add(refDataState);
		add(attrName);
		add(attrCapacity);
		add(attrIsUnlimited);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final String getDataState() {
		return ((DataState) get("dataState")).getName();
	}

	public final void setDataState(String dataState) {
		((DataState) get("dataState")).setName(dataState);
	}

	public String toString() {
		return getName();
	}

}

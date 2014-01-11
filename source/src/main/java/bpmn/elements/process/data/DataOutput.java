package org.yaoqiang.model.bpmn.elements.process.data;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataOutput
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataOutput extends BaseElement implements ItemAwareElement {

	private static final long serialVersionUID = -3790184711935692683L;

	public DataOutput(String name, boolean isCollection) {
		this((DataOutputs) null);
		setName(name);
		setIsCollection(isCollection);
	}

	public DataOutput(DataOutputs parent) {
		super(parent, "dataOutput");
	}

	public DataOutput(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrIsCollection = new XMLAttribute(this, "isCollection", Boolean.FALSE.toString());
		XMLAttribute attrItemSubjectRef = new XMLAttribute(this, "itemSubjectRef");
		DataState refDataState = new DataState(this);

		super.fillStructure();
		add(attrItemSubjectRef);
		add(refDataState);
		add(attrName);
		add(attrIsCollection);
	}

	public final boolean isCollection() {
		return Boolean.parseBoolean(get("isCollection").toValue());
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getDataState() {
		return ((DataState) get("dataState")).getName();
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setIsCollection(boolean isCollection) {
		set("isCollection", String.valueOf(isCollection));
	}

	public final void setDataState(String dataState) {
		set("dataState", dataState);
	}

	public String toString() {
		return getName().length() == 0 ? getId() : getName();
	}

	public boolean isGraphicalElement() {
		return getId().startsWith("_");
	}

	protected List<OutputSet> outputSetRefs;

	protected List<OutputSet> outputSetwithOptional;

	protected List<OutputSet> outputSetWithWhileExecuting;

}

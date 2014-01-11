package org.yaoqiang.model.bpmn.elements.process.data;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * DataInput
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class DataInput extends BaseElement implements ItemAwareElement {

	private static final long serialVersionUID = 3458991963611237618L;

	public DataInput(String name, boolean isCollection) {
		this((DataInputs) null);
		setName(name);
		setIsCollection(isCollection);
	}

	public DataInput(DataInputs parent) {
		super(parent, "dataInput");
	}

	public DataInput(XMLElement parent, String name) {
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
		((DataState) get("dataState")).setName(dataState);
	}

	public String toString() {
		return getName().length() == 0 ? getId() : getName();
	}
	
	public boolean isGraphicalElement() {
		return getId().startsWith("_");
	}

	protected List<InputSet> inputSetRefs;

	protected List<InputSet> inputSetwithOptional;

	protected List<InputSet> inputSetWithWhileExecuting;

}

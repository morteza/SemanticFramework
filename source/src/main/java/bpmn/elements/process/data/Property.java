package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Property
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Property extends BaseElement implements ItemAwareElement {

	private static final long serialVersionUID = 6282380399129605144L;

	public Property(Properties parent) {
		super(parent, "property");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrItemSubjectRef = new XMLAttribute(this, "itemSubjectRef");
		DataState refDataState = new DataState(this);

		super.fillStructure();
		add(attrItemSubjectRef);
		add(refDataState);
		add(attrName);
	}

	public Properties getParent() {
		return (Properties) parent;
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getItemSubjectRef() {
		return get("itemSubjectRef").toValue();
	}

	public final String getDataState() {
		return ((DataState) get("dataState")).getName();
	}

	public final void setDataState(String dataState) {
		((DataState) get("dataState")).setName(dataState);
	}

}

package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * OutputSet
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class OutputSet extends BaseElement {

	private static final long serialVersionUID = 6181385034937225256L;

	public OutputSet(XMLElement parent) {
		super(parent, "outputSet");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refDataOutputRefs = new XMLTextElements(this, "dataOutputRefs");
		XMLTextElements refOptionalOutputRefs = new XMLTextElements(this, "optionalOutputRefs");
		XMLTextElements refWhileExecutingOutputRefs = new XMLTextElements(this, "whileExecutingOutputRefs");
		XMLTextElements refInputSetRefs = new XMLTextElements(this, "inputSetRefs");

		super.fillStructure();
		add(attrName);
		add(refDataOutputRefs);
		add(refOptionalOutputRefs);
		add(refWhileExecutingOutputRefs);
		add(refInputSetRefs);
	}

	public final XMLTextElements getDataOutputRefs() {
		return (XMLTextElements) get("dataOutputRefs");
	}

}

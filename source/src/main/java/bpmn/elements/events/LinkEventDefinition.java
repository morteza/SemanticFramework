package org.yaoqiang.model.bpmn.elements.events;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.XMLTextElements;

/**
 * LinkEventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class LinkEventDefinition extends EventDefinition {

	private static final long serialVersionUID = -1459505037162963650L;

	public LinkEventDefinition(XMLElement parent) {
		super(parent, "linkEventDefinition");
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refSources = new XMLTextElements(this, "source");
		XMLTextElement refTarget = new XMLTextElement(this, "target");

		super.fillStructure();
		add(attrName);
		add(refSources);
		add(refTarget);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public final String getTarget() {
		return get("target").toValue();
	}

	public final XMLTextElements getSources() {
		return (XMLTextElements) get("source");
	}
	
	public final List<XMLElement> getSourceList() {
		return getSources().getXMLElements();
	}
	
	public final void setName(String name) {
		set("name", name);
	}
	
	public final void setTarget(String target) {
		set("target", target);
	}
	
}

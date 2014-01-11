package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;

/**
 * GlobalScriptTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalScriptTask extends GlobalTask {

	private static final long serialVersionUID = 5081588008104302269L;

	public GlobalScriptTask(XMLElement parent) {
		super(parent, "globalScriptTask");
	}

	protected void fillStructure() {
		XMLAttribute attrScriptFormat = new XMLAttribute(this, "scriptLanguage");
		XMLTextElement refScript = new XMLTextElement(this, "script");
		super.fillStructure();
		add(attrScriptFormat);
		add(refScript);
	}


	public final XMLAttribute getScriptLanguageAttribute() {
		return (XMLAttribute) get("scriptLanguage");
	}
	
	public final String getScriptLanguage() {
		return getScriptLanguageAttribute().toValue();
	}

	public final XMLTextElement getScriptElement() {
		return (XMLTextElement) get("script");
	}
	
	public final String getScript() {
		return get("script").toValue();
	}

	public final void setScriptLanguage(String scriptLanguage) {
		set("scriptLanguage", scriptLanguage);
	}
	
	public final void setScript(String script) {
		set("script", script);
	}
}

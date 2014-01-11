package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * ScriptTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ScriptTask extends Task {

	private static final long serialVersionUID = 8597003702439945840L;

	public ScriptTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ScriptTask(FlowElements parent) {
		super(parent, "scriptTask");
	}

	protected void fillStructure() {
		XMLAttribute attrScriptFormat = new XMLAttribute(this, "scriptFormat");
		XMLTextElement refScript = new XMLTextElement(this, "script");
		super.fillStructure();
		add(attrScriptFormat);
		add(refScript);
	}

	public final XMLAttribute getScriptFormatAttribute() {
		return (XMLAttribute) get("scriptFormat");
	}
	
	public final String getScriptFormat() {
		return getScriptFormatAttribute().toValue();
	}

	public final XMLTextElement getScriptElement() {
		return (XMLTextElement) get("script");
	}
	
	public final String getScript() {
		return get("script").toValue();
	}

	public final void setScriptFormat(String scriptFormat) {
		set("scriptFormat", scriptFormat);
	}
	
	public final void setScript(String script) {
		set("script", script);
	}
}

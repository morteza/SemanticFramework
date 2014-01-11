package org.yaoqiang.model.bpmn.elements.artifacts;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLTextElement;

/**
 * TextAnnotation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class TextAnnotation extends Artifact {

	private static final long serialVersionUID = 8782675899592633790L;

	public TextAnnotation(String text) {
		this((Artifacts) null);
		setText(text);
	}

	public TextAnnotation(Artifacts parent) {
		super(parent, "textAnnotation");
	}

	protected void fillStructure() {
		XMLAttribute attrTextFormat = new XMLAttribute(this, "textFormat", "text/plain");
		XMLTextElement refText = new XMLTextElement(this, "text");

		super.fillStructure();
		add(attrTextFormat);
		add(refText);
	}

	public Artifacts getParent() {
		return (Artifacts) parent;
	}

	public final String getText() {
		return get("text").toValue();
	}

	public final void setText(String text) {
		set("text", text);
	}

	public final String getTextFormat() {
		return get("textFormat").toValue();
	}

	public final void setTextFormat(String textFormat) {
		set("textFormat", textFormat);
	}

	public String toString() {
		return getText();
	}
}

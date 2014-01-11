package org.yaoqiang.model.bpmn.elements.artifacts;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;

/**
 * Artifacts
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Artifacts extends XMLFactoryElement {

	private static final long serialVersionUID = -3191371003910719984L;
	
	public static final String TYPE_TEXTANNOTATION = "textAnnotation";
	public static final String TYPE_GROUP = "group";
	public static final String TYPE_ASSOCIATION = "association";

	public Artifacts(XMLElement parent) {
		super(parent, "artifacts");
	}

	public XMLElement generateNewElement() {
		if (type.equals(TYPE_TEXTANNOTATION)) {
			return new TextAnnotation(this);
		} else if (type.equals(TYPE_GROUP)) {
			return new Group(this);
		} else if (type.equals(TYPE_ASSOCIATION)) {
			return new Association(this);
		}
		return null;
	}

}

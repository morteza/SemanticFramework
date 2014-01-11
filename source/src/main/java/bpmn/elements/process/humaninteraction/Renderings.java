package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;

/**
 * Renderings
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Renderings extends XMLCollectionElement {

	private static final long serialVersionUID = -4048161373247910690L;

	public Renderings(XMLElement parent) {
		super(parent, "renderings");
	}

	public XMLElement generateNewElement() {
		return new Rendering(this);
	}

	public String getElementName() {
		return "rendering";
	}
	
}

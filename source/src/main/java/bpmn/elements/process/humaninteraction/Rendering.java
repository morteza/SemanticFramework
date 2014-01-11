package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Rendering
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Rendering extends BaseElement {

	private static final long serialVersionUID = -3516472115826503749L;

	public Rendering(Renderings parent) {
		super(parent, "rendering");
	}

	public Renderings getParent() {
		return (Renderings) parent;
	}

}

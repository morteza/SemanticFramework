package org.yaoqiang.model.bpmn.elements.artifacts;

import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * Artifact
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class Artifact extends BaseElement {

	private static final long serialVersionUID = -6606774208087389490L;

	public Artifact(Artifacts parent, String name) {
		super(parent, name);
	}

	public boolean isGraphicalElement() {
		return true;
	}

}

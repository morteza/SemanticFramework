package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.XMLElement;

/**
 * PotentialOwner
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class PotentialOwner extends HumanPerformer {

	private static final long serialVersionUID = 3927852506320147486L;

	public PotentialOwner(XMLElement parent) {
		super(parent, "potentialOwner");
	}

	public PotentialOwner(XMLElement parent, String name) {
		super(parent, name);
	}
}

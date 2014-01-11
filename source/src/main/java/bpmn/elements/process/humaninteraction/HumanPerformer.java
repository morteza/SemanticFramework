package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.Performer;

/**
 * HumanPerformer
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class HumanPerformer extends Performer {

	private static final long serialVersionUID = 7026662450642537540L;

	public HumanPerformer(XMLElement parent) {
		super(parent, "humanPerformer");
	}

	public HumanPerformer(XMLElement parent, String name) {
		super(parent, name);
	}
	
}

package org.yaoqiang.model.bpmn.elements.process;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.activities.ResourceRole;

/**
 * Performer
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Performer extends ResourceRole {

	private static final long serialVersionUID = 2130264766208211123L;

	public Performer(XMLElement parent) {
		super(parent, "performer");
	}
	
	public Performer(XMLElement parent, String name) {
		super(parent, name);
	}

}

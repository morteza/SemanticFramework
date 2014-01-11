package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

import org.yaoqiang.model.bpmn.elements.collaboration.Collaboration;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * GlobalConversation
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalConversation extends Collaboration {

	private static final long serialVersionUID = -1700220986977501633L;

	public GlobalConversation(RootElements parent) {
		super(parent, "globalConversation");
		super.remove("choreographyRef");
	}

	public GlobalConversation(RootElements parent, String name) {
		super(parent, name);
		super.remove("choreographyRef");
	}

}

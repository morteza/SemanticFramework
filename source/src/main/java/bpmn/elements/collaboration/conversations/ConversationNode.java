package org.yaoqiang.model.bpmn.elements.collaboration.conversations;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.common.CorrelationKeys;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * ConversationNode
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class ConversationNode extends BaseElement {

	private static final long serialVersionUID = 7793959486508048448L;

	public ConversationNode(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refParticipantRefs = new XMLTextElements(this, "participantRef");
		XMLTextElements refMessageFlowRefs = new XMLTextElements(this, "messageFlowRef");
		CorrelationKeys refCorrelationKeys = new CorrelationKeys(this);

		super.fillStructure();
		add(attrName);
		add(refParticipantRefs);
		add(refMessageFlowRefs);
		add(refCorrelationKeys);
	}

	public final String getName() {
		return get("name").toValue();
	}
	
	public final void setName(String name) {
		set("name", name);
	}
}

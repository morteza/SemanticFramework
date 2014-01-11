package org.yaoqiang.model.bpmn.elements.choreography;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * GlobalChoreographyTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalChoreographyTask extends Choreography {

	private static final long serialVersionUID = 5659533615735216546L;

	public GlobalChoreographyTask(RootElements parent) {
		super(parent, "globalChoreographyTask");
	}

	protected void fillStructure() {
		XMLAttribute attrInitiatingParticipantRef = new XMLAttribute(this, "initiatingParticipantRef");

		super.fillStructure();
		add(attrInitiatingParticipantRef);
	}

}

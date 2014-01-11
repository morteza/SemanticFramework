package org.yaoqiang.model.bpmn.elements.choreography.choreographyactivities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.collaboration.ParticipantAssociations;
import org.yaoqiang.model.bpmn.elements.core.common.CorrelationKeys;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * CallChoreography
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CallChoreography extends ChoreographyActivity {

	private static final long serialVersionUID = -7713963001353824411L;

	public CallChoreography(FlowElements parent) {
		super(parent, "callChoreography");
	}

	protected void fillStructure() {
		XMLAttribute attrCalledChoreographyRef = new XMLAttribute(this, "calledChoreographyRef");
		CorrelationKeys refCorrelationKeys = new CorrelationKeys(this);
		ParticipantAssociations refParticipantAssociations = new ParticipantAssociations(this);
		
		super.fillStructure();
		add(attrCalledChoreographyRef);
		add(refCorrelationKeys);
		add(refParticipantAssociations);
	}

	public final String getCalledChoreographyRef() {
		return get("calledChoreographyRef").toValue();
	}
	
}

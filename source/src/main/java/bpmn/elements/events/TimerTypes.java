package org.yaoqiang.model.bpmn.elements.events;

import java.util.ArrayList;

import org.yaoqiang.model.XMLComplexChoiceElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.FormalExpression;

/**
 * TimerTypes
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class TimerTypes extends XMLComplexChoiceElement {

	private static final long serialVersionUID = 7210888620690313528L;

	public TimerTypes(TimerEventDefinition parent) {
		super(parent);
	}

	protected void fillChoices() {
		choices = new ArrayList<XMLElement>();
		choices.add(new FormalExpression(this, "timeDate"));
		choices.add(new FormalExpression(this, "timeCycle"));
		choices.add(new FormalExpression(this, "timeDuration"));
		choosen = choices.get(2);
	}

}

package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.process.activities.Task;

/**
 * UserTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class UserTask extends Task {

	private static final long serialVersionUID = 4153834048038139465L;

	public UserTask(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public UserTask(FlowElements parent) {
		super(parent, "userTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##unspecified");
		Renderings refRenderings = new Renderings(this);

		super.fillStructure();
		add(attrImplementation);
		add(refRenderings);
	}

	public final Renderings getRenderings() {
		return (Renderings) get("renderings");
	}

}

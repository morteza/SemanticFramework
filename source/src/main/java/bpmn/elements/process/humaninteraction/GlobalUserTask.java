package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;

/**
 * GlobalUserTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalUserTask extends GlobalTask {

	private static final long serialVersionUID = 4058841147063580995L;

	public GlobalUserTask(XMLElement parent) {
		super(parent, "globalUserTask");
	}

	protected void fillStructure() {
		XMLAttribute attrImplementation = new XMLAttribute(this, "implementation", "##unspecified");

		super.fillStructure();
		add(attrImplementation);
	}

}

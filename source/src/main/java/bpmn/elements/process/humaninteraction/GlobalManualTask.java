package org.yaoqiang.model.bpmn.elements.process.humaninteraction;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;

/**
 * GlobalManualTask
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class GlobalManualTask extends GlobalTask {

	private static final long serialVersionUID = 541541755096890995L;

	public GlobalManualTask(XMLElement parent) {
		super(parent, "globalManualTask");
	}

}

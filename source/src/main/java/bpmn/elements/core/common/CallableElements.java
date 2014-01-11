package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;
import org.yaoqiang.model.bpmn.elements.process.activities.GlobalBusinessRuleTask;
import org.yaoqiang.model.bpmn.elements.process.activities.GlobalScriptTask;
import org.yaoqiang.model.bpmn.elements.process.humaninteraction.GlobalManualTask;
import org.yaoqiang.model.bpmn.elements.process.humaninteraction.GlobalUserTask;

/**
 * CallableElements
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CallableElements extends XMLFactoryElement {

	private static final long serialVersionUID = -5034099277518675260L;

	public CallableElements(XMLElement parent) {
		super(parent, "callableElements");
	}

	public XMLElement generateNewElement() {
		if (type.equals("process")) {
			return new BPMNProcess(this);
		} else if (type.equals("globalBusinessRuleTask")) {
			return new GlobalBusinessRuleTask(this);
		} else if (type.equals("globalManualTask")) {
			return new GlobalManualTask(this);
		} else if (type.equals("globalScriptTask")) {
			return new GlobalScriptTask(this);
		} else if (type.equals("globalTask")) {
			return new GlobalTask(this);
		} else if (type.equals("globalUserTask")) {
			return new GlobalUserTask(this);
		} 
		return null;
	}
	
}

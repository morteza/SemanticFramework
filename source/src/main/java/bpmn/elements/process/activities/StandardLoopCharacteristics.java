package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;

/**
 * StandardLoopCharacteristics
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class StandardLoopCharacteristics extends LoopCharacteristics {

	private static final long serialVersionUID = 5992325980770349797L;

	public StandardLoopCharacteristics(XMLElement parent) {
		super(parent, "standardLoopCharacteristics");
	}

	protected void fillStructure() {
		XMLAttribute attrTestBefore = new XMLAttribute(this, "testBefore", Boolean.FALSE.toString());
		XMLAttribute attrLoopMaximum = new XMLAttribute(this, "loopMaximum");
		Expression refLoopCondition = new Expression(this, "loopCondition");

		super.fillStructure();
		add(attrTestBefore);
		add(attrLoopMaximum);
		add(refLoopCondition);
	}

	public boolean isTestBefore() {
		return Boolean.parseBoolean(get("testBefore").toValue());
	}

	public void setTestBefore(boolean testBefore) {
		set("testBefore", String.valueOf(testBefore));
	}

	public String getLoopMaximum() {
		return get("loopMaximum").toValue();
	}

	public void setLoopMaximum(String loopMaximum) {
		set("loopMaximum", loopMaximum);
	}

	public String getLoopCondition() {
		return get("loopCondition").toValue();
	}

	public void setLoopCondition(String loopCondition) {
		set("loopCondition", loopCondition);
	}

}

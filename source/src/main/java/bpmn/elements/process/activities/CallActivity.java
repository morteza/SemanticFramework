package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * CallActivity
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CallActivity extends Activity {

	private static final long serialVersionUID = -1941770556428698344L;

	public CallActivity(String name, String calledElement) {
		this((FlowElements) null);
		setName(name);
		setCalledElement(calledElement);
	}

	public CallActivity(FlowElements parent) {
		super(parent, "callActivity");
	}

	protected void fillStructure() {
		XMLAttribute attrCalledElement = new XMLAttribute(this, "calledElement");

		super.fillStructure();
		add(attrCalledElement);
	}

	public String getCalledElement() {
		return get("calledElement").toValue();
	}
	
	public final void setCalledElement(String calledElement) {
		set("calledElement", calledElement);
	}
	
}

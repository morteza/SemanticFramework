package org.yaoqiang.model.bpmn.elements.gateways;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowNode;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.activities.SubProcess;

/**
 * Gateway
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class Gateway extends FlowNode {

	private static final long serialVersionUID = -7302148457315366591L;

	public class Direction {
		public static final String UNSPECIFIED = "Unspecified";
		public static final String CONVERGING = "Converging";
		public static final String DIVERGING = "Diverging";
		public static final String MIXED = "Mixed";
	}

	public Gateway(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrGatewayDirection = new XMLAttribute(this, "gatewayDirection", Direction.UNSPECIFIED);

		super.fillStructure();
		add(attrGatewayDirection);
	}

	public List<XMLElement> getAccessibleProperties() {
		List<XMLElement> properties = new ArrayList<XMLElement>();
		if (getParent().getParent() instanceof SubProcess) {
			properties.addAll(((SubProcess) getParent().getParent()).getAccessibleProperties());
		} else if (getParent().getParent() instanceof BPMNProcess) {
			properties.addAll(((BPMNProcess) getParent().getParent()).getAccessibleProperties());
		}
		return properties;
	}

	public final String getGatewayDirection() {
		return get("gatewayDirection").toValue();
	}
	
	public final void setGatewayDirection(String gatewayDirection) {
		set("gatewayDirection", gatewayDirection);
	}

}

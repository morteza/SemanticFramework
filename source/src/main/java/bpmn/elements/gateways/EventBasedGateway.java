package org.yaoqiang.model.bpmn.elements.gateways;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * EventBasedGateway
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class EventBasedGateway extends Gateway {

	private static final long serialVersionUID = -8554362026033368352L;

	public class Type {
		public static final String PARALLEL = "Parallel";
		public static final String EXCLUSIVE = "Exclusive";
	}

	public EventBasedGateway(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public EventBasedGateway(String name, boolean instantiate) {
		this((FlowElements) null);
		setName(name);
		setInstantiate(instantiate);
	}

	public EventBasedGateway(String name, String eventGatewayType, boolean instantiate) {
		this((FlowElements) null);
		setName(name);
		setEventGatewayType(eventGatewayType);
		setInstantiate(instantiate);
	}

	public EventBasedGateway(FlowElements parent) {
		super(parent, "eventBasedGateway");
	}

	protected void fillStructure() {
		XMLAttribute attrInstantiate = new XMLAttribute(this, "instantiate", Boolean.FALSE.toString());
		XMLAttribute attrEventGatewayType = new XMLAttribute(this, "eventGatewayType", Type.EXCLUSIVE);

		super.fillStructure();
		add(attrInstantiate);
		add(attrEventGatewayType);
	}

	public final boolean isInstantiate() {
		return Boolean.parseBoolean(get("instantiate").toValue());
	}
	
	public final String getEventGatewayType() {
		return get("eventGatewayType").toValue();
	}
	
	public final void setInstantiate(boolean instantiate) {
		set("instantiate", String.valueOf(instantiate));
	}
	
	public final void setEventGatewayType(String eventGatewayType) {
		set("eventGatewayType", eventGatewayType);
	}

}

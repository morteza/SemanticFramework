package org.yaoqiang.model.bpmn.elements.gateways;

import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;

/**
 * ParallelGateway
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class ParallelGateway extends Gateway {

	private static final long serialVersionUID = 2839350902702220993L;

	public ParallelGateway(String name) {
		this((FlowElements) null);
		setName(name);
	}

	public ParallelGateway(FlowElements parent) {
		super(parent, "parallelGateway");
		setGatewayDirection(Gateway.Direction.DIVERGING);
	}

}

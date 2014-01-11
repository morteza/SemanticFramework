package org.yaoqiang.model.bpmn.elements.core.service;

import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;

/**
 * EndPoint
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class EndPoint extends BaseElement implements RootElement {

	private static final long serialVersionUID = 5996168026896823146L;

	public EndPoint(RootElements parent) {
		super(parent, "endPoint");
	}

}

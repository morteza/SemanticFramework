package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;

/**
 * EventDefinition
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class EventDefinition extends BaseElement implements RootElement {

	private static final long serialVersionUID = -7579719546853731764L;

	public EventDefinition(XMLElement parent, String name) {
		super(parent, name);
	}

}

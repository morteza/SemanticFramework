package org.yaoqiang.model.bpmn.elements.core.common;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;

/**
 * CorrelationSubscriptions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class CorrelationSubscriptions extends XMLCollectionElement {

	private static final long serialVersionUID = 5474497738518186726L;

	public CorrelationSubscriptions(BPMNProcess parent) {
		super(parent, "correlationSubscriptions");
	}
	
	public XMLElement generateNewElement() {
		return new CorrelationSubscription(this);
	}
	
	public String getElementName() {
		return "correlationSubscription";
	}
	
}

package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.ArrayList;
import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;

/**
 * FlowNode
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class FlowNode extends FlowElement {

	private static final long serialVersionUID = -9007696150677054978L;

	public FlowNode(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLTextElements refIncoming = new XMLTextElements(this, "incoming");
		XMLTextElements refOutgoing = new XMLTextElements(this, "outgoing");

		super.fillStructure();
		add(refIncoming);
		add(refOutgoing);
	}

	public final List<SequenceFlow> getIncomingSequenceFlows() {
		List<SequenceFlow> sfList = new ArrayList<SequenceFlow>();
		for (XMLElement incoming : getIncomings().getXMLElements()) {
			SequenceFlow sf = (SequenceFlow) getParent().getFlowElement(incoming.toValue());
			if (sf != null) {
				sfList.add(sf);
			}
		}
		return sfList;
	}

	public final List<SequenceFlow> getOutgoingSequenceFlows() {
		List<SequenceFlow> sfList = new ArrayList<SequenceFlow>();
		for (XMLElement outgoing : getOutgoings().getXMLElements()) {
			SequenceFlow sf = (SequenceFlow) getParent().getFlowElement(outgoing.toValue());
			if (sf != null) {
				sfList.add(sf);
			}
		}
		return sfList;
	}

	public final XMLTextElements getIncomings() {
		return (XMLTextElements) get("incoming");
	}

	public final XMLTextElements getOutgoings() {
		return (XMLTextElements) get("outgoing");
	}

	public final XMLTextElements setIncomings(XMLTextElements incomings) {
		getIncomings().clear();
		if (incomings != null) {
			getIncomings().addAll(incomings.getXMLElements());
		}
		return incomings;
	}

	public final XMLTextElements setOutgoings(XMLTextElements outgoings) {
		getOutgoings().clear();
		if (outgoings != null) {
			getOutgoings().addAll(outgoings.getXMLElements());
		}
		return outgoings;
	}

	public final void addIncoming(String incomingValue) {
		XMLElement incoming = getIncomings().generateNewElement();
		incoming.setValue(incomingValue);
		getIncomings().add(incoming);
	}

	public final void addOutgoing(String outgoingValue) {
		XMLElement outgoing = getOutgoings().generateNewElement();
		outgoing.setValue(outgoingValue);
		getOutgoings().add(outgoing);
	}

	public void removeOutgoing(String value) {
		getOutgoings().remove(value);
	}

	public void removeIncoming(String value) {
		getIncomings().remove(value);
	}

	public void removeIncomingOutgoings() {
		getIncomings().clear();
		getOutgoings().clear();
	}

}

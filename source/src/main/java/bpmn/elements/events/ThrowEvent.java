package org.yaoqiang.model.bpmn.elements.events;

import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.process.data.DataInput;
import org.yaoqiang.model.bpmn.elements.process.data.DataInputAssociation;
import org.yaoqiang.model.bpmn.elements.process.data.DataInputAssociations;
import org.yaoqiang.model.bpmn.elements.process.data.DataInputs;
import org.yaoqiang.model.bpmn.elements.process.data.InputSet;

/**
 * ThrowEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class ThrowEvent extends Event {

	private static final long serialVersionUID = 1412044254252217547L;

	public ThrowEvent(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		DataInputs refDataInputs = new DataInputs(this);
		DataInputAssociations refDataInputAssociations = new DataInputAssociations(this);
		InputSet refInputSet = new InputSet(this);
		EventDefinitions refEventDefinitions = new EventDefinitions(this);
		XMLTextElements refEventDefinitionRef = new XMLTextElements(this, "eventDefinitionRef");

		super.fillStructure();
		add(refDataInputs);
		add(refDataInputAssociations);
		add(refInputSet);
		add(refEventDefinitions);
		add(refEventDefinitionRef);
	}

	public final DataInputs getDataInputs() {
		return (DataInputs) get("dataInputs");
	}

	public final List<XMLElement> getDataInputList() {
		return getDataInputs().getXMLElements();
	}

	public final DataInput getDataInput(String id) {
		return (DataInput) getDataInputs().getCollectionElement(id);
	}

	public final DataInputAssociations getDataInputAssociations() {
		return (DataInputAssociations) get("dataInputAssociations");
	}

	public final List<XMLElement> getDataInputAssociationList() {
		return getDataInputAssociations().getXMLElements();
	}

	public final InputSet getInputSet() {
		return (InputSet) get("inputSet");
	}

	public final DataInput addDataInput(String id) {
		DataInput dataInput = (DataInput) getDataInputs().generateNewElement();
		dataInput.setId(id);
		getDataInputs().add(dataInput);
		addDataInputRef(id);
		return dataInput;
	}

	public final void addDataInputRef(String id) {
		if (!getInputSet().getDataInputRefs().contains(id)) {
			XMLTextElement dataInputRef = (XMLTextElement) getInputSet().getDataInputRefs().generateNewElement();
			dataInputRef.setValue(id);
			getInputSet().getDataInputRefs().add(dataInputRef);
		}
	}

	public final DataInputAssociation addDataInputAssociation(String id, String sourceId, String dataInputId) {
		DataInputAssociation dia = (DataInputAssociation) getDataInputAssociations().generateNewElement();
		dia.setId(id);
		dia.addSourceRef(sourceId);
		dia.setTargetRef(dataInputId);
		getDataInputAssociations().add(dia);
		return dia;
	}

	public final void removeDataInput(String id) {
		getDataInputs().remove(id);
		getInputSet().getDataInputRefs().remove(id);
	}

	public final void removeDataInputRefs(String value) {
		getInputSet().getDataInputRefs().remove(value);
	}

	public final void clearDataInputs() {
		getDataInputs().clear();
		getInputSet().getDataInputRefs().clear();
	}
}

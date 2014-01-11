package org.yaoqiang.model.bpmn.elements.process.data;

import java.util.List;

import org.yaoqiang.model.XMLCollectionElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * InputOutputSpecification
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class InputOutputSpecification extends BaseElement {

	private static final long serialVersionUID = 7583470044108280711L;

	public InputOutputSpecification(XMLElement parent) {
		super(parent, "ioSpecification");
	}

	protected void fillStructure() {
		DataInputs refDataInputs = new DataInputs(this);
		DataOutputs refDataOutputs = new DataOutputs(this);
		InputSets refInputSets = new InputSets(this);
		OutputSets refOutputSets = new OutputSets(this);

		super.fillStructure();
		add(refDataInputs);
		add(refDataOutputs);
		add(refInputSets);
		add(refOutputSets);
	}

	public final DataInputs getDataInputs() {
		return (DataInputs) get("dataInputs");
	}

	public final DataOutputs getDataOutputs() {
		return (DataOutputs) get("dataOutputs");
	}

	public final List<XMLElement> getDataInputList() {
		return getDataInputs().getXMLElements();
	}

	public final List<XMLElement> getDataOutputList() {
		return getDataOutputs().getXMLElements();
	}

	public final XMLElement getDataInOut(String id) {
		XMLElement dout = getDataOutputs().getCollectionElement(id);
		if (dout == null) {
			return getDataInputs().getCollectionElement(id);
		} else {
			return dout;
		}
	}

	public final InputSets getInputSets() {
		return (InputSets) get("inputSets");
	}

	public final OutputSets getOutputSets() {
		return (OutputSets) get("outputSets");
	}

	public boolean isEmpty() {
		boolean isEmpty = true;
		for (XMLElement el : getXMLElements()) {
			isEmpty = isEmpty && (el.isEmpty() || ((XMLCollectionElement) el).getXMLElements().get(0).isEmpty());
		}
		return isEmpty;
	}

	public void clear() {
		getDataInputs().clear();
		getDataOutputs().clear();
		getInputSets().clear();
		getOutputSets().clear();
	}

	public final DataInput addDataInput(String id, String value, boolean isCollection) {
		DataInput dataInput = (DataInput) getDataInputs().generateNewElement();
		dataInput.setId(id);
		if (value != null && value.length() != 0) {
			dataInput.setIsCollection(isCollection);
			int index = value.lastIndexOf("\n[");
			if (index > 0) {
				dataInput.setName(value.substring(0, index));
				dataInput.setDataState(value.substring(index + 2, value.length() - 1));
			} else {
				dataInput.setName(value);
			}
		}
		getDataInputs().add(dataInput);
		addDataInputRef(id);
		return dataInput;
	}

	public final void addDataInput(DataInput dataInput) {
		getDataInputs().add(dataInput);
		addDataInputRef(dataInput.getId());
	}

	public final DataOutput addDataOutput(String id, String value, boolean isCollection) {
		DataOutput dataOutput = (DataOutput) getDataOutputs().generateNewElement();
		dataOutput.setId(id);
		if (value != null && value.length() != 0) {
			dataOutput.setIsCollection(isCollection);
			int index = value.lastIndexOf("\n[");
			if (index > 0) {
				dataOutput.setName(value.substring(0, index));
				dataOutput.setDataState(value.substring(index + 2, value.length() - 1));
			} else {
				dataOutput.setName(value);
			}
		}
		getDataOutputs().add(dataOutput);
		addDataOutputRef(id);
		return dataOutput;
	}

	public final void addDataOutput(DataOutput dataOutput) {
		getDataOutputs().add(dataOutput);
		addDataOutputRef(dataOutput.getId());
	}

	public final void addDataInputRef(String id) {
		InputSet inputSet = null;
		if (getInputSets().isEmpty()) {
			inputSet = (InputSet) getInputSets().generateNewElement();
			getInputSets().add(inputSet);
		} else {
			inputSet = (InputSet) getInputSets().getXMLElements().get(0);
		}
		if (getOutputSets().isEmpty()) {
			getOutputSets().add(getOutputSets().generateNewElement());
		}
		if (!inputSet.getDataInputRefs().contains(id)) {
			XMLTextElement dataInputRef = (XMLTextElement) inputSet.getDataInputRefs().generateNewElement();
			dataInputRef.setValue(id);
			inputSet.getDataInputRefs().add(dataInputRef);
		}
	}

	public final void addDataOutputRef(String id) {
		if (getInputSets().isEmpty()) {
			getInputSets().add(getInputSets().generateNewElement());
		}
		OutputSet outputSet = null;
		if (getOutputSets().isEmpty()) {
			outputSet = (OutputSet) getOutputSets().generateNewElement();
			getOutputSets().add(outputSet);
		} else {
			outputSet = (OutputSet) getOutputSets().getXMLElements().get(0);
		}
		if (!outputSet.getDataOutputRefs().contains(id)) {
			XMLTextElement dataOutputRef = (XMLTextElement) outputSet.getDataOutputRefs().generateNewElement();
			dataOutputRef.setValue(id);
			outputSet.getDataOutputRefs().add(dataOutputRef);
		}
	}

	public final void removeDataInput(String id) {
		getDataInputs().remove(id);
		InputSet inputSet = (InputSet) getInputSets().getXMLElements().get(0);
		inputSet.getDataInputRefs().remove(id);
	}

	public final void removeDataInputRef(String value) {
		InputSet inputSet = (InputSet) getInputSets().getXMLElements().get(0);
		inputSet.getDataInputRefs().remove(value);
	}

	public final void removeDataOutput(String id) {
		getDataOutputs().remove(id);
		OutputSet outputSet = (OutputSet) getOutputSets().getXMLElements().get(0);
		outputSet.getDataOutputRefs().remove(id);
	}

	public final void removeDataOutputRef(String value) {
		OutputSet outputSet = (OutputSet) getOutputSets().getXMLElements().get(0);
		outputSet.getDataOutputRefs().remove(value);
	}
}

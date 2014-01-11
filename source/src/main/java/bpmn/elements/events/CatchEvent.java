package org.yaoqiang.model.bpmn.elements.events;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.common.FlowElements;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutput;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutputAssociation;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutputAssociations;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutputs;
import org.yaoqiang.model.bpmn.elements.process.data.OutputSet;

/**
 * CatchEvent
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class CatchEvent extends Event {

	private static final long serialVersionUID = 1722441028570528345L;

	public CatchEvent(FlowElements parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrParallelMultiple = new XMLAttribute(this, "parallelMultiple", Boolean.FALSE.toString());
		DataOutputs refDataOutputs = new DataOutputs(this);
		DataOutputAssociations refDataOutputAssociations = new DataOutputAssociations(this);
		OutputSet refOutputSet = new OutputSet(this);
		EventDefinitions refEventDefinitions = new EventDefinitions(this);
		XMLTextElements refEventDefinitionRef = new XMLTextElements(this, "eventDefinitionRef");

		super.fillStructure();
		add(attrParallelMultiple);
		add(refDataOutputs);
		add(refDataOutputAssociations);
		add(refOutputSet);
		add(refEventDefinitions);
		add(refEventDefinitionRef);
	}

	public final boolean isParallelMultiple() {
		return Boolean.parseBoolean(get("parallelMultiple").toValue());
	}

	public final DataOutputs getDataOutputs() {
		return (DataOutputs) get("dataOutputs");
	}

	public final List<XMLElement> getDataOutputList() {
		return getDataOutputs().getXMLElements();
	}

	public final DataOutput getDataOutput(String id) {
		return (DataOutput) getDataOutputs().getCollectionElement(id);
	}

	public final DataOutputAssociations getDataOutputAssociations() {
		return (DataOutputAssociations) get("dataOutputAssociations");
	}

	public final List<XMLElement> getDataOutputAssociationList() {
		return getDataOutputAssociations().getXMLElements();
	}

	public final OutputSet getOutputSet() {
		return (OutputSet) get("outputSet");
	}

	public final void setParallelMultiple(boolean parallelMultiple) {
		set("parallelMultiple", String.valueOf(parallelMultiple));
	}

	public final DataOutput addDataOutput(String id) {
		DataOutput dataOutput = (DataOutput) getDataOutputs().generateNewElement();
		dataOutput.setId(id);
		getDataOutputs().add(dataOutput);
		addDataOutputRef(id);
		return dataOutput;
	}

	public final void addDataOutputRef(String id) {
		if (!getOutputSet().getDataOutputRefs().contains(id)) {
			XMLTextElement dataOutputRef = (XMLTextElement) getOutputSet().getDataOutputRefs().generateNewElement();
			dataOutputRef.setValue(id);
			getOutputSet().getDataOutputRefs().add(dataOutputRef);
		}
	}

	public final DataOutputAssociation addDataOutputAssociation(String id, String dataOutputId, String targetId) {
		DataOutputAssociation doa = (DataOutputAssociation) getDataOutputAssociations().generateNewElement();
		doa.setId(id);
		doa.addSourceRef(dataOutputId);
		doa.setTargetRef(targetId);
		getDataOutputAssociations().add(doa);
		return doa;
	}

	public final void removeDataOutput(String id) {
		getDataOutputs().remove(id);
		getOutputSet().getDataOutputRefs().remove(id);
	}

	public final void removeDataOutputRefs(String value) {
		getOutputSet().getDataOutputRefs().remove(value);
	}

	public final void clearDataOutputs() {
		getDataOutputs().clear();
		getOutputSet().getDataOutputRefs().clear();
	}

}

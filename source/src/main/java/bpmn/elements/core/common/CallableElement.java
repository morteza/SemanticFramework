package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.List;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElements;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElement;
import org.yaoqiang.model.bpmn.elements.process.data.InputOutputBindings;
import org.yaoqiang.model.bpmn.elements.process.data.InputOutputSpecification;

/**
 * CallableElement
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public abstract class CallableElement extends BaseElement implements RootElement {

	private static final long serialVersionUID = 5883369679384088404L;

	public CallableElement(XMLElement parent, String name) {
		super(parent, name);
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLTextElements refSupportedInterfaceRef = new XMLTextElements(this, "supportedInterfaceRef");
		InputOutputSpecification refInputOutputSpecification = new InputOutputSpecification(this);
		InputOutputBindings refInputOutputBindings = new InputOutputBindings(this);

		super.fillStructure();
		add(attrName);
		add(refSupportedInterfaceRef);
		add(refInputOutputSpecification);
		add(refInputOutputBindings);
	}

	public final String getName() {
		return get("name").toValue();
	}
	
	public final InputOutputSpecification getIoSpecification() {
		return (InputOutputSpecification) get("ioSpecification");
	}

	public final List<XMLElement> getDataInOuts() {
		List<XMLElement> dio = getDataInputs();
		dio.addAll(getDataOutputs());
		return dio;
	}

	public final List<XMLElement> getDataInputs() {
		return getIoSpecification().getDataInputs().getXMLElements();
	}

	public final List<XMLElement> getDataOutputs() {
		return getIoSpecification().getDataOutputs().getXMLElements();
	}

	public final void setName(String name) {
		set("name", name);
	}
	
}

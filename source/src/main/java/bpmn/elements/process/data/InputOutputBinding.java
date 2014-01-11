package org.yaoqiang.model.bpmn.elements.process.data;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

/**
 * InputOutputBinding
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class InputOutputBinding extends BaseElement {

	private static final long serialVersionUID = 7426418451976810597L;

	public InputOutputBinding(InputOutputBindings parent) {
		super(parent, "ioBinding");
	}

	protected void fillStructure() {
		XMLAttribute attrInputDataRef = new XMLAttribute(this, "inputDataRef");
		XMLAttribute attrOutputDataRef = new XMLAttribute(this, "outputDataRef");
		XMLAttribute attrOperationRef = new XMLAttribute(this, "operationRef");

		super.fillStructure();
		add(attrInputDataRef);
		add(attrOutputDataRef);
		add(attrOperationRef);
	}

	public InputOutputBindings getParent() {
		return (InputOutputBindings) parent;
	}

}

package org.yaoqiang.model.bpmn.elements.process.activities;

import java.util.ArrayList;

import org.yaoqiang.model.XMLComplexChoiceElement;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLEmptyElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;

public class ResourceAssignTypes extends XMLComplexChoiceElement {

	private static final long serialVersionUID = 6787286523475035069L;

	public ResourceAssignTypes(ResourceRole parent) {
		super(parent);
	}

	protected void fillChoices() {
		choices = new ArrayList<XMLElement>();
		choices.add(new XMLComplexElement(this, "parameterAssignment") {
			private static final long serialVersionUID = 2531244423229176862L;

			protected void fillStructure() {
				XMLTextElement refResourceRef = new XMLTextElement(this, "resourceRef");
				ResourceParameterBindings refResourceParameterBindings = new ResourceParameterBindings(this);
				add(refResourceRef);
				add(refResourceParameterBindings);
			}
		});
		choices.add(new ResourceAssignmentExpression(this));
		choosen = choices.get(0);
	}

	public final ResourceParameterBindings getResourceParameterBindings() {
		return (ResourceParameterBindings) ((XMLComplexElement) choices.get(0)).get("resourceParameterBindings");
	}

	public final XMLElement getResourceAssignmentExpression() {
		return choices.get(1);
	}

	public final void setChoosen(XMLElement ch) {
		if (ch instanceof XMLEmptyElement || ch instanceof ResourceAssignmentExpression) {
			choosen = choices.get(1);
		} else {
			String id = ((BaseElement) ch).getId();
			XMLComplexElement choice = (XMLComplexElement) choices.get(0);
			String oldRef = choice.get("resourceRef").toValue();
			int index = oldRef.indexOf(":");
			if (index != -1) {
				id = oldRef.substring(0, index + 1) + id;
			}
			choice.set("resourceRef", id);
			choosen = choice;
		}
	}
}

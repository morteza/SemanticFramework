package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLTextElement;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.process.data.DataInput;
import org.yaoqiang.model.bpmn.elements.process.data.DataOutput;

/**
 * MultiInstanceLoopCharacteristics
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class MultiInstanceLoopCharacteristics extends LoopCharacteristics {

	private static final long serialVersionUID = -4923611309825631627L;

	public class Behavior {
		public static final String NONE = "None";
		public static final String ONE = "One";
		public static final String ALL = "All";
		public static final String COMPLEX = "Complex";
	}

	DataInput refInputDataItem;

	DataOutput refOutputDataItem;

	public MultiInstanceLoopCharacteristics(XMLElement parent) {
		super(parent, "multiInstanceLoopCharacteristics");
	}

	protected void fillStructure() {
		XMLAttribute attrIsSequential = new XMLAttribute(this, "isSequential", Boolean.FALSE.toString());
		XMLAttribute attrBehavior = new XMLAttribute(this, "behavior", Behavior.ALL);
		XMLAttribute attrOneBehaviorEventRef = new XMLAttribute(this, "oneBehaviorEventRef");
		XMLAttribute attrNoneBehaviorEventRef = new XMLAttribute(this, "noneBehaviorEventRef");
		Expression refLoopCardinality = new Expression(this, "loopCardinality");
		XMLTextElement refLoopDataInputRef = new XMLTextElement(this, "loopDataInputRef");
		XMLTextElement refLoopDataOutputRef = new XMLTextElement(this, "loopDataOutputRef");
		refInputDataItem = new DataInput(this, "inputDataItem");
		refOutputDataItem = new DataOutput(this, "outputDataItem");
		ComplexBehaviorDefinitions refComplexBehaviorDefinitions = new ComplexBehaviorDefinitions(this);
		Expression refCompletionCondition = new Expression(this, "completionCondition");

		super.fillStructure();
		add(attrIsSequential);
		add(attrBehavior);
		add(attrOneBehaviorEventRef);
		add(attrNoneBehaviorEventRef);
		add(refLoopCardinality);
		add(refLoopDataInputRef);
		add(refLoopDataOutputRef);
		add(refInputDataItem);
		add(refOutputDataItem);
		add(refComplexBehaviorDefinitions);
		add(refCompletionCondition);
	}

	public final boolean isSequential() {
		return Boolean.parseBoolean(get("isSequential").toValue());
	}

	public final void setIsSequential(boolean isSequential) {
		set("isSequential", String.valueOf(isSequential));
	}

	public final DataInput getInputDataItem() {
		return refInputDataItem;
	}

	public final DataOutput getOutputDataItem() {
		return refOutputDataItem;
	}

}

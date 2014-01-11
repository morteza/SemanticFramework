package org.yaoqiang.model.bpmn.elements.process.activities;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;

/**
 * LoopTypes
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class LoopTypes extends XMLFactoryElement {

	private static final long serialVersionUID = -2423958092140243379L;
	
	public static final String STANDARD_LOOPCHARACTERISTICS = "standardLoopCharacteristics";
	public static final String MULTI_INSTANCE_LOOPCHARACTERISTICS = "multiInstanceLoopCharacteristics";
	
	public LoopTypes(Activity parent) {
		super(parent, "loopCharacteristics");
	}
	
	public XMLElement generateNewElement() {
		if (type.equals(MULTI_INSTANCE_LOOPCHARACTERISTICS)) {
			return new MultiInstanceLoopCharacteristics(this);
		} else if (type.equals(STANDARD_LOOPCHARACTERISTICS)) {
			return new StandardLoopCharacteristics(this);
		}
		return null;
	}

}

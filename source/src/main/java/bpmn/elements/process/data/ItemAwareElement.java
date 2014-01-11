package org.yaoqiang.model.bpmn.elements.process.data;


/**
 * ItemAwareElement
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public interface ItemAwareElement {

	public String getId();
	
	public String getDataState();
	
	public void setDataState(String dataState);
	
}

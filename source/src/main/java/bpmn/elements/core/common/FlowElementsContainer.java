package org.yaoqiang.model.bpmn.elements.core.common;

import java.util.List;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.elements.artifacts.Artifacts;

/**
 * FlowElementsContainer
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public interface FlowElementsContainer {

	public FlowElement getFlowElement(String id);
	
	public FlowElements getFlowElements();

	public List<FlowNode> getFlowNodes();

	public List<FlowNode> getStartingFlowNodes();
	
	public List<SequenceFlow> getSequenceFlows();
	
	public XMLElement generateFlowElement(String type);
	
	public void addFlowElement(XMLElement flowElement);
	
	public Artifacts getArtifacts();
	
	public void addFlowElements(FlowElements flowElements);

	public void addArtifacts(Artifacts artifacts);

	public void addArtifact(XMLElement artifact);

}

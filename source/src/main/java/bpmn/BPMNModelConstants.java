package org.yaoqiang.model.bpmn;

import java.util.HashSet;
import java.util.Set;

/**
 * BPMNModelConstants
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public final class BPMNModelConstants {

	public static final Set<String> READONLY_ELEMENT = new HashSet<String>();
	static {
		READONLY_ELEMENT.add(BPMNModelConstants.BPMN_SEMANTIC_MODEL_NS);
		READONLY_ELEMENT.add(BPMNModelConstants.BPMN_DI_NS);
		READONLY_ELEMENT.add(BPMNModelConstants.DI_NS);
		READONLY_ELEMENT.add(BPMNModelConstants.DC_NS);
		READONLY_ELEMENT.add(BPMNModelConstants.XMLNS_XSI);
		READONLY_ELEMENT.add(BPMNModelConstants.XMLNS_XSD);
		READONLY_ELEMENT.add(BPMNModelConstants.YAOQIANG_NS);
	}

	public static final String BPMN_SCHEMA_BASEURI = "org/yaoqiang/model/bpmn/resources/";

	public static final String BPMN_SYSTEM_ID = "BPMN20.xsd";
	public static final String BPMNDI_SYSTEM_ID = "BPMNDI.xsd";
	public static final String DI_SYSTEM_ID = "DI.xsd";
	public static final String DC_SYSTEM_ID = "DC.xsd";
	public static final String SEMANTIC_SYSTEM_ID = "Semantic.xsd";

	public final static String XMLNS_XSD = "http://www.w3.org/2001/XMLSchema";
	public final static String XMLNS_XSI = "http://www.w3.org/2001/XMLSchema-instance";
	public final static String XSI_SCHEMA_LOCATION = "http://www.omg.org/spec/BPMN/20100524/MODEL http://bpmn.sourceforge.net/schemas/BPMN20.xsd";

	public static final String BPMN_SEMANTIC_MODEL_NS = "http://www.omg.org/spec/BPMN/20100524/MODEL";
	public static final String BPMN_DI_NS = "http://www.omg.org/spec/BPMN/20100524/DI";
	public static final String DI_NS = "http://www.omg.org/spec/DD/20100524/DI";
	public static final String DC_NS = "http://www.omg.org/spec/DD/20100524/DC";
	public static final String BPMN_TARGET_MODEL_NS = "http://sourceforge.net/bpmn/definitions/";

	public static final String YAOQIANG_NS = "http://bpmn.sourceforge.net";

}

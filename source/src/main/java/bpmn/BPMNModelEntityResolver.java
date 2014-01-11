package org.yaoqiang.model.bpmn;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * BPMNModelEntityResolver
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNModelEntityResolver implements EntityResolver {

	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		if (systemId != null) {
			InputStream is = null;
			java.net.URL u = null;
			try {
				if (systemId.endsWith(BPMNModelConstants.BPMN_SYSTEM_ID)) {
					u = BPMNModelEntityResolver.class.getClassLoader().getResource(BPMNModelConstants.BPMN_SCHEMA_BASEURI + BPMNModelConstants.BPMN_SYSTEM_ID);
				} else if (systemId.endsWith(BPMNModelConstants.BPMNDI_SYSTEM_ID)) {
					u = BPMNModelEntityResolver.class.getClassLoader().getResource(BPMNModelConstants.BPMN_SCHEMA_BASEURI + BPMNModelConstants.BPMNDI_SYSTEM_ID);
				} else if (systemId.endsWith(BPMNModelConstants.DI_SYSTEM_ID)) {
					u = BPMNModelEntityResolver.class.getClassLoader().getResource(BPMNModelConstants.BPMN_SCHEMA_BASEURI + BPMNModelConstants.DI_SYSTEM_ID);
				} else if (systemId.endsWith(BPMNModelConstants.DC_SYSTEM_ID)) {
					u = BPMNModelEntityResolver.class.getClassLoader().getResource(BPMNModelConstants.BPMN_SCHEMA_BASEURI + BPMNModelConstants.DC_SYSTEM_ID);
				} else if (systemId.endsWith(BPMNModelConstants.SEMANTIC_SYSTEM_ID)) {
					u = BPMNModelEntityResolver.class.getClassLoader().getResource(BPMNModelConstants.BPMN_SCHEMA_BASEURI + BPMNModelConstants.SEMANTIC_SYSTEM_ID);
				} else {
					u = BPMNModelEntityResolver.class.getClassLoader().getResource(BPMNModelConstants.BPMN_SCHEMA_BASEURI + BPMNModelConstants.BPMN_SYSTEM_ID);
				}

				is = (InputStream) u.getContent();
				return new InputSource(is);
			} catch (Exception ex) {
				return null;
			}
		}
		return null;
	}

}

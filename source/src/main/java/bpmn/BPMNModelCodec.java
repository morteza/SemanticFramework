package org.yaoqiang.model.bpmn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.yaoqiang.model.XMLComplexChoiceElement;
import org.yaoqiang.model.XMLComplexElement;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;
import org.yaoqiang.model.XMLModelCodec;
import org.yaoqiang.model.bpmn.elements.core.common.BPMNError;
import org.yaoqiang.model.bpmn.elements.core.common.Expression;
import org.yaoqiang.model.bpmn.elements.core.common.Expressions;
import org.yaoqiang.model.bpmn.elements.core.common.ItemDefinition;
import org.yaoqiang.model.bpmn.elements.core.common.Message;
import org.yaoqiang.model.bpmn.elements.core.foundation.Documentation;
import org.yaoqiang.model.bpmn.elements.core.infrastructure.Definitions;
import org.yaoqiang.model.bpmn.elements.core.service.Interface;
import org.yaoqiang.model.bpmn.elements.events.EventDefinition;
import org.yaoqiang.model.bpmn.elements.process.activities.ResourceAssignmentExpression;
import org.yaoqiang.model.util.XMLModelUtils;

/**
 * BPMNModelCodec
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class BPMNModelCodec extends XMLModelCodec {

	public Element encode(Document doc, Definitions BPMNModel) {
		Map<String, String> namespaces = BPMNModel.getNamespaces();
		String prefix = namespaces.get(BPMNModelConstants.BPMN_SEMANTIC_MODEL_NS);
		if (prefix == null) {
			prefix = "";
		} else if (prefix.length() != 0) {
			prefix += ":";
		}

		Element defs = doc.createElement(prefix + "definitions");
		doc.appendChild(defs);
		defs.setAttribute("id", BPMNModel.getId());
		defs.setAttribute("name", BPMNModel.getName());
		defs.setAttribute("targetNamespace", BPMNModel.getTargetNamespace());
		defs.setAttribute("expressionLanguage", BPMNModel.getExpressionLanguage());
		defs.setAttribute("typeLanguage", BPMNModel.getTypeLanguage());
		defs.setAttribute("exporter", BPMNModel.getExporter());
		defs.setAttribute("exporterVersion", BPMNModel.getExporterVersion());
		for (String location : namespaces.keySet()) {
			String name = namespaces.get(location);
			defs.setAttribute("xmlns:" + name, location);
		}
		if (prefix.length() == 0) {
			defs.setAttribute("xmlns", BPMNModelConstants.BPMN_SEMANTIC_MODEL_NS);
		}

		defs.setAttribute("xsi:schemaLocation", BPMNModelConstants.XSI_SCHEMA_LOCATION);

		encodeSemantic(defs, BPMNModel, prefix);

		return defs;
	}

	private void encodeSemantic(Element defs, Definitions BPMNModel, String prefix) {
		Element node = null;
		List<XMLElement> importElements = BPMNModel.getImportList();
		for (XMLElement el : importElements) {
			if (el.isEmpty()) {
				continue;
			}
			node = defs.getOwnerDocument().createElement(prefix + el.toName());
			defs.appendChild(node);
			encodeComplexElement(node, el, prefix);
		}
		List<XMLElement> roots = new ArrayList<XMLElement>();
		List<XMLElement> messageElements = new ArrayList<XMLElement>();
		List<XMLElement> errorElements = new ArrayList<XMLElement>();
		List<XMLElement> interfaceElements = new ArrayList<XMLElement>();
		List<XMLElement> eventDefElements = new ArrayList<XMLElement>();
		List<XMLElement> rootElements = BPMNModel.getRootElementList();
		for (XMLElement root : rootElements) {
			if (root.isEmpty()) {
				continue;
			}
			if (root instanceof ItemDefinition) {
				node = defs.getOwnerDocument().createElement(prefix + root.toName());
				defs.appendChild(node);
				encodeComplexElement(node, root, prefix);
			} else if (root instanceof BPMNError) {
				errorElements.add(root);
				continue;
			} else if (root instanceof Message) {
				messageElements.add(root);
				continue;
			} else if (root instanceof Interface) {
				interfaceElements.add(root);
				continue;
			} else if (root instanceof EventDefinition) {
				eventDefElements.add(root);
				continue;
			} else {
				roots.add(root);
				continue;
			}
		}
		for (XMLElement error : errorElements) {
			node = defs.getOwnerDocument().createElement(prefix + error.toName());
			defs.appendChild(node);
			encodeComplexElement(node, error, prefix);
		}
		for (XMLElement message : messageElements) {
			node = defs.getOwnerDocument().createElement(prefix + message.toName());
			defs.appendChild(node);
			encodeComplexElement(node, message, prefix);
		}
		for (XMLElement _interface : interfaceElements) {
			node = defs.getOwnerDocument().createElement(prefix + _interface.toName());
			defs.appendChild(node);
			encodeComplexElement(node, _interface, prefix);
		}
		for (XMLElement eventDef : eventDefElements) {
			node = defs.getOwnerDocument().createElement(prefix + eventDef.toName());
			defs.appendChild(node);
			encodeComplexElement(node, eventDef, prefix);
		}
		for (XMLElement id : roots) {
			node = defs.getOwnerDocument().createElement(prefix + id.toName());
			defs.appendChild(node);
			encodeComplexElement(node, id, prefix);
		}
	}

	protected void beforeEncodeComplexElement(Element parent, XMLElement el, String prefix) {
		if (el.toValue() != null && el.toValue().length() > 0) {
			if (el instanceof Expression || el instanceof Documentation) {
				if (!el.toValue().equals("")) {
					Node textNode = parent.getOwnerDocument().createCDATASection(el.toValue());
					parent.appendChild(textNode);
				}
			}
		}
	}

	protected void encodeComplexChoiceElement(Element parent, XMLElement el, String prefix) {
		XMLElement choosen = ((XMLComplexChoiceElement) el).getChoosen();
		if (choosen != null) {
			if (choosen.toName().equals("parameterAssignment")) {
				encodeComplexElement(parent, choosen, prefix);
			} else if (choosen instanceof XMLComplexElement) {
				Element node = parent.getOwnerDocument().createElement(prefix + choosen.toName());
				parent.appendChild(node);
				encodeComplexElement(node, choosen, prefix);
			} else if (choosen instanceof XMLFactoryElement) {
				encodeFactoryElement(parent, choosen, prefix);
			}
		}
	}

	protected void encodeText(Element parent, XMLElement el, String prefix) {
		if (!el.isEmpty()) {
			Node textNode = null;
			Node node = parent.getOwnerDocument().createElement(prefix + el.toName());
			if (el.toName().equals("script")) {
				textNode = parent.getOwnerDocument().createCDATASection(el.toValue());
			} else {
				textNode = parent.getOwnerDocument().createTextNode(el.toValue());
			}
			node.appendChild(textNode);
			parent.appendChild(node);
		}
	}

	public void decode(Element node, Definitions defs) {
		NamedNodeMap attribs = node.getAttributes();
		Map<String, String> nss = defs.getNamespaces();
		for (int i = 0; i < attribs.getLength(); i++) {
			Node n = attribs.item(i);
			String nn = n.getNodeName();
			if (nn.startsWith("xmlns:")) {
				nss.put(n.getNodeValue(), nn.substring(6, nn.length()));
			}
		}
		decode(node, (XMLComplexElement) defs);
		BPMNModelUtils.refreshTypes(defs);
		BPMNModelUtils.fillAllFlowNodeSequenceFlowRefs(defs);
	}

	protected void beforeDecode(Node node, XMLComplexElement cel) {
		if (cel instanceof Documentation || cel instanceof Expression) {
			cel.setValue(XMLModelUtils.getChildNodesContent(node));
		}
	}

	protected void decode(Node node, XMLComplexChoiceElement el) {
		List<XMLElement> ch = el.getChoices();
		for (int i = 0; i < ch.size(); i++) {
			XMLElement chc = ch.get(i);
			String chname = chc.toName();
			if (chname.equals("parameterAssignment")) {
				decode(node, (XMLComplexElement) chc);
			} else {
				Node child = XMLModelUtils.getChildByName(node, chname);
				if (child != null) {
					if (chc instanceof ResourceAssignmentExpression || chc instanceof Expressions) {
						if (chc instanceof XMLComplexElement) {
							decode(child, (XMLComplexElement) chc);
						} else {
							decode(node, (Expressions) chc);
						}
					} else {
						decode(child, (XMLComplexElement) chc);
					}
					el.setChoosen(chc);
					break;
				}
			}
		}
	}

}

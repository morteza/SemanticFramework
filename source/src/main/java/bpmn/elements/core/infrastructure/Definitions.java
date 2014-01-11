package org.yaoqiang.model.bpmn.elements.core.infrastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.yaoqiang.model.XMLAttribute;
import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.bpmn.BPMNModelConstants;
import org.yaoqiang.model.bpmn.BPMNModelUtils;
import org.yaoqiang.model.bpmn.elements.artifacts.Category;
import org.yaoqiang.model.bpmn.elements.artifacts.CategoryValue;
import org.yaoqiang.model.bpmn.elements.bpmndi.BPMNDiagram;
import org.yaoqiang.model.bpmn.elements.bpmndi.BPMNDiagrams;
import org.yaoqiang.model.bpmn.elements.choreography.Choreography;
import org.yaoqiang.model.bpmn.elements.collaboration.Collaboration;
import org.yaoqiang.model.bpmn.elements.collaboration.MessageFlow;
import org.yaoqiang.model.bpmn.elements.collaboration.Participant;
import org.yaoqiang.model.bpmn.elements.core.common.BPMNError;
import org.yaoqiang.model.bpmn.elements.core.common.ItemDefinition;
import org.yaoqiang.model.bpmn.elements.core.common.Message;
import org.yaoqiang.model.bpmn.elements.core.common.PartnerEntity;
import org.yaoqiang.model.bpmn.elements.core.common.PartnerRole;
import org.yaoqiang.model.bpmn.elements.core.common.Resource;
import org.yaoqiang.model.bpmn.elements.core.foundation.BaseElement;
import org.yaoqiang.model.bpmn.elements.core.foundation.Extensions;
import org.yaoqiang.model.bpmn.elements.core.foundation.Relationships;
import org.yaoqiang.model.bpmn.elements.core.foundation.RootElements;
import org.yaoqiang.model.bpmn.elements.core.service.Interface;
import org.yaoqiang.model.bpmn.elements.core.service.Operation;
import org.yaoqiang.model.bpmn.elements.events.Escalation;
import org.yaoqiang.model.bpmn.elements.events.EventDefinition;
import org.yaoqiang.model.bpmn.elements.events.Signal;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;
import org.yaoqiang.model.bpmn.elements.process.data.DataStore;
import org.yaoqiang.model.elements.Import;
import org.yaoqiang.model.elements.Imports;
import org.yaoqiang.model.util.XMLModelUtils;
import org.yaoqiang.model.wsdl.WSDLModelUtils;
import org.yaoqiang.model.wsdl.elements.Fault;
import org.yaoqiang.model.wsdl.elements.PortType;
import org.yaoqiang.model.xsd.elements.Schema;

/**
 * Definitions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class Definitions extends BaseElement {

	private static final long serialVersionUID = 8157094629298601195L;

	protected LinkedHashMap<String, String> namespaces;

	protected Map<String, XMLElement> importedElements = new HashMap<String, XMLElement>();

	protected Set<String> types;

	public Definitions() {
		super(null, "definitions");
		resetNamespace();
		resetTypes();
	}

	protected void fillStructure() {
		XMLAttribute attrName = new XMLAttribute(this, "name");
		XMLAttribute attrTargetNamespace = new XMLAttribute(this, "targetNamespace");
		XMLAttribute attrExpressionLanguage = new XMLAttribute(this, "expressionLanguage", "http://www.w3.org/1999/XPath");
		XMLAttribute attrTypeLanguage = new XMLAttribute(this, "typeLanguage", "http://www.w3.org/2001/XMLSchema");
		XMLAttribute attrExporter = new XMLAttribute(this, "exporter");
		XMLAttribute attrExporterVersion = new XMLAttribute(this, "exporterVersion");
		Imports refImports = new Imports(this);
		Extensions refExtensions = new Extensions(this);
		RootElements refRootElements = new RootElements(this);
		BPMNDiagrams refBPMNDiagrams = new BPMNDiagrams(this);
		Relationships refRelationships = new Relationships(this);

		super.fillStructure();
		add(attrName);
		add(attrTargetNamespace);
		add(attrExpressionLanguage);
		add(attrTypeLanguage);
		add(attrExporter);
		add(attrExporterVersion);
		add(refImports);
		add(refExtensions);
		add(refRootElements);
		add(refBPMNDiagrams);
		add(refRelationships);
	}

	public final String getName() {
		return get("name").toValue();
	}

	public Map<String, String> getNamespaces() {
		return namespaces;
	}

	public final String getTargetNamespacePrefix() {
		return getNamespacePrefix(getTargetNamespace());
	}

	public final String getNamespacePrefix(String namespace) {
		return namespaces.get(namespace);
	}

	public final String addNamespace(String namespace) {
		String prefix = null;
		if (!namespaces.containsKey(namespace)) {
			String name = "ns";
			int n = 1;
			while (namespaces.containsValue(name + n)) {
				n++;
			}
			prefix = name + n;
			namespaces.put(namespace, prefix);
		} else {
			prefix = namespaces.get(namespace);
		}
		return prefix;
	}

	public final String getTargetNamespace() {
		return get("targetNamespace").toValue();
	}

	public final String getExpressionLanguage() {
		return get("expressionLanguage").toValue();
	}

	public final String getTypeLanguage() {
		return get("typeLanguage").toValue();
	}

	public final String getExporter() {
		return get("exporter").toValue();
	}

	public final String getExporterVersion() {
		return get("exporterVersion").toValue();
	}

	public Set<String> getTypes() {
		return types;
	}

	public final RootElements getRootElements() {
		return (RootElements) get("rootElements");
	}

	public final List<XMLElement> getRootElementList() {
		return getRootElements().getXMLElements();
	}

	public final Imports getImports() {
		return (Imports) get("imports");
	}

	public final List<XMLElement> getImportList() {
		return getImports().getXMLElements();
	}

	public final void initImportedElements() {
		for (XMLElement el : getImportList()) {
			Import i = (Import) el;
			if (Import.Type.XML_SCHEMA.equals(i.getImportType())) {
				Schema schema = XMLModelUtils.parseSchema(i.getLocation());
				addImportedElement(i.getNamespace(), schema);
			} else if (Import.Type.BPMN.equals(i.getImportType())) {
				Definitions bpmnModel = BPMNModelUtils.parseBPMN(i.getLocation());
				addImportedElement(i.getNamespace(), bpmnModel);
			} else if (Import.Type.WSDL.equals(i.getImportType())) {
				org.yaoqiang.model.wsdl.elements.Definitions wsdlModel = WSDLModelUtils.parseWSDL(i.getLocation());
				addImportedElement(i.getNamespace(), wsdlModel);
			} else if (Import.Type.WSDL20.equals(i.getImportType())) {
				// TODO:
			}
		}
	}

	public final String removeImportedElement(String namespace) {
		XMLElement element = importedElements.remove(namespace);
		String prefix = namespaces.remove(namespace);
		Set<String> types = getImportedElementTypes(prefix, element);
		removeTypes(types);
		for (String type : types) {
			String itemId = removeItemDefinition(type);
			if (element instanceof org.yaoqiang.model.wsdl.elements.Definitions) {
				removeMessage(itemId);
				removeError(itemId);
			}
		}
		if (element instanceof org.yaoqiang.model.wsdl.elements.Definitions) {
			removeInterfaces(prefix, (org.yaoqiang.model.wsdl.elements.Definitions) element);
		}
		return prefix;
	}

	public final String addImportedElement(String namespace, XMLElement element) {
		importedElements.put(namespace, element);
		String prefix = addNamespace(namespace);
		Set<String> types = getImportedElementTypes(prefix, element);
		addTypes(types);
		for (String type : types) {
			String itemId = addItemDefinition(type);
			if (element instanceof org.yaoqiang.model.wsdl.elements.Definitions) {
				addMessage(itemId);
			}
		}
		if (element instanceof org.yaoqiang.model.wsdl.elements.Definitions) {
			addInterfaces(prefix, (org.yaoqiang.model.wsdl.elements.Definitions) element);
		}
		return prefix;
	}

	public Set<String> getImportedElementTypes(String prefix, XMLElement element) {
		Set<String> typeList = new HashSet<String>();
		if (element instanceof Schema) {
			Schema schema = (Schema) element;
			for (String el : schema.getElementList()) {
				typeList.add(prefix + ":" + el);
			}
			for (String el : schema.getComplexTypeList()) {
				typeList.add(prefix + ":" + el);
			}
		} else if (element instanceof org.yaoqiang.model.wsdl.elements.Definitions) {
			org.yaoqiang.model.wsdl.elements.Definitions wsdlModel = (org.yaoqiang.model.wsdl.elements.Definitions) element;
			for (XMLElement el : wsdlModel.getMessageList()) {
				typeList.add(prefix + ":" + ((org.yaoqiang.model.wsdl.elements.Message) el).getName());
			}
		} else {
			// TODO:
		}
		return typeList;
	}

	public Map<String, XMLElement> getImportedElements() {
		return importedElements;
	}

	public Map<String, Definitions> getImportedBPMNModels() {
		Map<String, Definitions> bpmnModels = new HashMap<String, Definitions>();
		for (Entry<String, XMLElement> i : importedElements.entrySet()) {
			if (i.getValue() instanceof Definitions) {
				bpmnModels.put(i.getKey(), (Definitions) i.getValue());
			}
		}
		return bpmnModels;
	}

	public final Map<String, String> getImportedFiles() {
		Map<String, String> files = new HashMap<String, String>();
		for (XMLElement el : getImportList()) {
			Import i = (Import) el;
			files.put(getNamespacePrefix(i.getNamespace()), i.getLocation());
		}
		return files;
	}

	public final String getImportedFile(String prefix) {
		return getImportedFiles().get(prefix);
	}

	public final BaseElement getRootElement(String id) {
		int index = id.indexOf(":");
		if (index != -1) {
			id = id.substring(index + 1);
		}
		return (BaseElement) getRootElements().getCollectionElement(id);
	}

	public String getDiagramName() {
		return "";
	}

	public void setDiagramName(String diagramName) {
	}

	public final BPMNDiagrams getBPMNDiagrams() {
		return (BPMNDiagrams) get("diagrams");
	}

	public final BPMNDiagram getFirstBPMNDiagram() {
		if (getBPMNDiagrams().getXMLElements().isEmpty()) {
			return null;
		}
		return (BPMNDiagram) getBPMNDiagrams().getXMLElements().get(0);
	}

	public final String getBPMNDiagramName(String bpmnElement) {
		for (XMLElement d : getBPMNDiagrams().getXMLElements()) {
			if (bpmnElement.equals(((BPMNDiagram) d).getBPMNPlane().getBpmnElement())) {
				return ((BPMNDiagram) d).getName();
			}
		}
		return "";
	}

	public final List<XMLElement> getItemDefinitions() {
		List<XMLElement> itemDefinitions = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof ItemDefinition) {
				itemDefinitions.add(root);
			}
		}
		return itemDefinitions;
	}

	public final String addItemDefinition(String type) {
		ItemDefinition itemDefinition = null;
		if (hasItemDefinition(type)) {
			itemDefinition = getItemDefinitionByStructure(type);
		} else {
			itemDefinition = (ItemDefinition) generateRootElement(RootElements.TYPE_ITEM_DEFINITION);
			itemDefinition.setStructureRef(type);
			addRootElement(itemDefinition);
		}
		return itemDefinition.getId();
	}

	public final String removeItemDefinition(String type) {
		for (XMLElement id : getItemDefinitions()) {
			ItemDefinition item = (ItemDefinition) id;
			if (item.getStructureRef().equals(type)) {
				removeRootElement(item.getId());
				return item.getId();
			}
		}
		return null;
	}

	public final ItemDefinition getItemDefinitionByStructure(String type) {
		for (XMLElement id : getItemDefinitions()) {
			if (((ItemDefinition) id).getStructureRef().equals(type)) {
				return (ItemDefinition) id;
			}
		}
		return null;
	}

	public final boolean hasItemDefinition(String type) {
		for (XMLElement id : getItemDefinitions()) {
			if (((ItemDefinition) id).getStructureRef().equals(type)) {
				return true;
			}
		}
		return false;
	}

	public final List<XMLElement> getMessages() {
		List<XMLElement> messages = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof Message) {
				messages.add(root);
			}
		}
		return messages;
	}

	public Message getMessageByStructure(String type) {
		for (XMLElement msg : getMessages()) {
			String itemId = ((Message) msg).getItemRef();
			XMLElement item = getRootElement(itemId);
			if (item != null) {
				if (((ItemDefinition) item).getStructureRef().equals(type)) {
					return (Message) msg;
				}
			}
		}
		return null;
	}

	public Message getMessageByItem(String itemId) {
		for (XMLElement msg : getMessages()) {
			String id = ((Message) msg).getItemRef();
			if (id.equals(itemId)) {
				return (Message) msg;
			}
		}
		return null;
	}

	public final void addMessage(String itemId) {
		Message message = getMessageByItem(itemId);
		if (message == null) {
			message = (Message) generateRootElement(RootElements.TYPE_MESSAGE);
			message.setName("Message " + message.getId().substring(4));
			// message.setItemRef("tns:" + itemDefinition.getId());
			message.setItemRef(itemId);
			addRootElement(message);
		}
	}

	public final void removeMessage(String itemId) {
		for (XMLElement msg : getMessages()) {
			Message message = (Message) msg;
			if (message.getItemRef().equals(itemId)) {
				removeRootElement(message.getId());
			}
		}
	}

	public final List<XMLElement> getErrors() {
		List<XMLElement> errors = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof BPMNError) {
				errors.add(root);
			}
		}
		return errors;
	}

	public BPMNError getErrorByStructure(String type) {
		for (XMLElement err : getErrors()) {
			String itemId = ((BPMNError) err).getStructureRef();
			XMLElement item = getRootElement(itemId);
			if (item != null) {
				if (((ItemDefinition) item).getStructureRef().equals(type)) {
					return (BPMNError) err;
				}
			}
		}
		return null;
	}

	public final BPMNError addError(String itemId) {
		BPMNError error = (BPMNError) generateRootElement(RootElements.TYPE_ERROR);
		error.setName("Error " + error.getId().substring(4));
		error.setStructureRef(itemId);
		addRootElement(error);
		return error;
	}

	public final void removeError(String itemId) {
		for (XMLElement err : getErrors()) {
			BPMNError error = (BPMNError) err;
			if (error.getStructureRef().equals(itemId)) {
				removeRootElement(error.getId());
			}
		}
	}

	public final List<XMLElement> getSignals() {
		List<XMLElement> errors = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof Signal) {
				errors.add(root);
			}
		}
		return errors;
	}

	public final List<XMLElement> getEscalations() {
		List<XMLElement> errors = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof Escalation) {
				errors.add(root);
			}
		}
		return errors;
	}

	public final List<XMLElement> getInterfaces() {
		List<XMLElement> interfaces = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof Interface) {
				interfaces.add(root);
			}
		}
		return interfaces;
	}

	public final Interface getInterfaceByName(String name) {
		for (XMLElement i : getInterfaces()) {
			Interface _interface = (Interface) i;
			if (_interface.getName().equals(name)) {
				return _interface;
			}
		}
		return null;
	}

	public final Interface addInterface(String prefix, String name) {
		Interface _interface = (Interface) generateRootElement(RootElements.TYPE_INTERFACE);
		_interface.setName(name);
		_interface.setImplementationRef(prefix + ":" + name);
		addRootElement(_interface);
		return _interface;
	}

	public final void removeInterface(String name) {
		for (XMLElement i : getInterfaces()) {
			Interface _interface = (Interface) i;
			if (_interface.getName().equals(name)) {
				removeRootElement(_interface.getId());
			}
		}
	}

	public void addInterfaces(String prefix, org.yaoqiang.model.wsdl.elements.Definitions wsdlModel) {
		for (XMLElement p : wsdlModel.getPortTypeList()) {
			PortType pt = (PortType) p;
			Interface _interface = getInterfaceByName(pt.getName());
			if (_interface != null) {
				return;
			}
			_interface = addInterface(prefix, pt.getName());
			for (XMLElement o : pt.getOperationList()) {
				org.yaoqiang.model.wsdl.elements.Operation op = (org.yaoqiang.model.wsdl.elements.Operation) o;
				Operation operation = _interface.addOperation(prefix, op.getName());
				String input = op.getInput().getMessage();
				int index = input.indexOf(":");
				if (index != -1) {
					input = input.substring(index + 1);
				}
				input = prefix + ":" + input;
				Message message = getMessageByStructure(input);
				if (message != null) {
					operation.setInMessageRef(message.getId());
				}

				String output = op.getOutput().getMessage();
				index = output.indexOf(":");
				if (index != -1) {
					output = output.substring(index + 1);
				}
				output = prefix + ":" + output;
				message = getMessageByStructure(output);
				if (message != null) {
					operation.setOutMessageRef(message.getId());
				}

				for (XMLElement f : op.getFaultList()) {
					Fault fault = (Fault) f;
					String msg = fault.getMessage();
					index = msg.indexOf(":");
					if (index != -1) {
						msg = msg.substring(index + 1);
					}
					msg = prefix + ":" + msg;
					ItemDefinition item = getItemDefinitionByStructure(msg);
					BPMNError error = getErrorByStructure(msg);
					if (error == null && item != null) {
						error = addError(item.getId());
						operation.addErrorRef(error.getId());
					}
				}
			}
		}
	}

	public void removeInterfaces(String prefix, org.yaoqiang.model.wsdl.elements.Definitions wsdlModel) {
		for (XMLElement p : wsdlModel.getPortTypeList()) {
			PortType pt = (PortType) p;
			removeInterface(pt.getName());
		}
	}

	public final List<XMLElement> getOperations() {
		List<XMLElement> operations = new ArrayList<XMLElement>();
		for (XMLElement _interface : getInterfaces()) {
			operations.addAll(((Interface) _interface).getOperationList());
		}
		return operations;
	}

	public final List<XMLElement> getPartners() {
		List<XMLElement> partners = new ArrayList<XMLElement>();
		partners.addAll(getPartnerEntities());
		partners.addAll(getPartnerRoles());
		return partners;
	}

	public final List<XMLElement> getPartnerEntities() {
		List<XMLElement> partnerEntities = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof PartnerEntity) {
				partnerEntities.add(root);
			}
		}
		return partnerEntities;
	}

	public final List<XMLElement> getPartnerRoles() {
		List<XMLElement> partnerRoles = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof PartnerRole) {
				partnerRoles.add(root);
			}
		}
		return partnerRoles;
	}

	public final List<XMLElement> getEventDefinitions(String type) {
		List<XMLElement> eventDefs = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof EventDefinition && root.toName().startsWith(type)) {
				eventDefs.add(root);
			}
		}
		return eventDefs;
	}

	public List<XMLElement> getGlobalTasks() {
		List<XMLElement> globalTasks = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof GlobalTask) {
				globalTasks.add(root);
			}
		}
		return globalTasks;
	}

	public List<XMLElement> getGlobalTasks(String type) {
		List<XMLElement> globalTasks = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof GlobalTask && root.toName().startsWith(type)) {
				globalTasks.add(root);
			}
		}
		return globalTasks;
	}

	public Set<String> getGlobalTaskIds() {
		Set<String> globalTasks = new HashSet<String>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof GlobalTask) {
				globalTasks.add(((GlobalTask) root).getId());
			}
		}
		return globalTasks;
	}

	public Set<String> getGlobalTaskIds(String type) {
		Set<String> globalTasks = new HashSet<String>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof GlobalTask && root.toName().equals(type)) {
				globalTasks.add(((GlobalTask) root).getId());
			}
		}
		return globalTasks;
	}

	public final GlobalTask createGlobalTask(String type) {
		GlobalTask globalTask = (GlobalTask) generateRootElement(type);
		globalTask.setName("Global Task");
		addRootElement(globalTask);
		return globalTask;
	}

	public final BPMNProcess getProcess(String id) {
		return (BPMNProcess) getRootElement(id);
	}

	public List<BPMNProcess> getProcesses() {
		List<BPMNProcess> processes = new ArrayList<BPMNProcess>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof BPMNProcess) {
				processes.add((BPMNProcess) root);
			}
		}
		return processes;
	}

	public Set<String> getProcessIds() {
		Set<String> processes = new HashSet<String>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof BPMNProcess) {
				processes.add(((BPMNProcess) root).getId());
			}
		}
		return processes;
	}

	public final Operation getOperation(String id) {
		int index = id.indexOf(":");
		if (index != -1) {
			id = id.substring(index + 1);
		}
		for (XMLElement o : getOperations()) {
			Operation operation = (Operation) o;
			if (operation.getId().equals(id)) {
				return operation;
			}
		}
		return null;
	}

	public final EventDefinition getEventDefinition(String id) {
		return (EventDefinition) getRootElement(id);
	}

	public final BPMNError getError(String id) {
		return (BPMNError) getRootElement(id);
	}

	public final Interface getInterface(String id) {
		return (Interface) getRootElement(id);
	}

	public final List<XMLElement> getDataStores() {
		List<XMLElement> dataStores = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof DataStore) {
				dataStores.add(root);
			}
		}
		return dataStores;
	}

	public final List<XMLElement> getResources() {
		List<XMLElement> resources = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof Resource) {
				resources.add(root);
			}
		}
		return resources;
	}

	public final DataStore getDataStore(String id) {
		return (DataStore) getRootElement(id);
	}

	public final Resource getResource(String id) {
		return (Resource) getRootElement(id);
	}

	public final List<XMLElement> getCategories() {
		List<XMLElement> categories = new ArrayList<XMLElement>();
		for (XMLElement root : getRootElementList()) {
			if (root instanceof Category) {
				categories.add(root);
			}
		}
		return categories;
	}

	public final Category getCategory(String id) {
		return (Category) getRootElement(id);
	}

	public final List<XMLElement> getAllCategoryValues() {
		List<XMLElement> categoryValues = new ArrayList<XMLElement>();
		for (XMLElement category : getCategories()) {
			categoryValues.addAll(((Category) category).getCategoryValueList());
		}
		return categoryValues;
	}

	public final CategoryValue getCategoryValue(String id) {
		for (XMLElement category : getCategories()) {
			CategoryValue categoryValue = ((Category) category).getCategoryValue(id);
			if (categoryValue != null) {
				return categoryValue;
			}
		}
		return null;
	}

	public final CategoryValue getDefaultCategoryValue() {
		for (XMLElement category : getCategories()) {
			for (XMLElement categoryValue : ((Category) category).getCategoryValueList()) {
				return (CategoryValue) categoryValue;
			}
		}
		return null;
	}

	public final List<XMLElement> getParticipants() {
		List<XMLElement> participants = new ArrayList<XMLElement>();
		Collaboration collaboration = BPMNModelUtils.getCollaboration(this);
		if (collaboration != null) {
			for (XMLElement part : collaboration.getParticipantList()) {
				participants.add(part);
			}
		}
		return participants;
	}

	public final Participant getParticipant(String id) {
		int index = id.indexOf(":");
		if (index != -1) {
			id = id.substring(index + 1);
		}
		for (XMLElement part : getParticipants()) {
			Participant participant = (Participant) part;
			if (participant.getId().equals(id)) {
				return participant;
			}
		}
		return null;
	}

	public final XMLElement getMessageFlowByMessage(String messageId) {
		Collaboration collaboration = BPMNModelUtils.getCollaboration(this);
		if (collaboration != null) {
			for (XMLElement messageFlow : collaboration.getMessageFlowList()) {
				if (messageId.equals(((MessageFlow) messageFlow).getMessageRef())) {
					return messageFlow;
				}
			}
		}
		return null;
	}

	public final void setName(String name) {
		set("name", name);
	}

	public final void setTargetNamespace(String targetNamespace) {
		set("targetNamespace", targetNamespace);
	}

	public final void setExporter(String exporter) {
		set("exporter", exporter);
	}

	public final void setExporterVersion(String exporterVersion) {
		set("exporterVersion", exporterVersion);
	}

	public final XMLElement generateRootElement(String type) {
		RootElements rootElements = getRootElements();
		rootElements.setType(type);
		XMLElement el = rootElements.generateNewElement();
		return el;
	}

	public final void addType(String type) {
		if (!getTypes().contains(type)) {
			getTypes().add(type);
		}
	}

	public final void addTypes(Collection<String> types) {
		getTypes().addAll(types);
	}

	public final void removeType(String type) {
		getTypes().remove(type);
	}

	public final void removeTypes(Collection<String> types) {
		getTypes().removeAll(types);
	}

	public final void addRootElement(XMLElement el) {
		getRootElements().add(el);
	}

	public final void removeRootElement(String id) {
		getRootElements().remove(id);
	}

	public final BPMNProcess createProcess(boolean defaultProcess) {
		BPMNProcess process = (BPMNProcess) generateRootElement(RootElements.TYPE_PROCESS);
		// if (defaultProcess) {
		// process.setId("_1");
		// } else {
		// process.setId("P_1");
		// }
		// process.setProcessType(BPMNProcess.ProcessType.Private.toString());
		process.setIsExecutable(true);
		addRootElement(process);
		return process;
	}

	public final Choreography createChoreography() {
		Choreography choreography = (Choreography) generateRootElement(RootElements.TYPE_CHOREOGRAPHY);

		BaseElement rootElement = getRootElement("_1");
		if (rootElement == null) {
			choreography.setId("_1");
		} else if (rootElement instanceof Collaboration) {
			choreography.setId("C_1");
		} else if (rootElement instanceof BPMNProcess) {
			choreography.setId("_1");
		}
		if (rootElement instanceof BPMNProcess || rootElement != null && getRootElement("P_1") != null) {
			if (!(rootElement instanceof BPMNProcess)) {
				rootElement = getRootElement("P_1");
			}
			choreography.addFlowElements(((BPMNProcess) rootElement).getFlowElements());
			choreography.addArtifacts(((BPMNProcess) rootElement).getArtifacts());
			removeRootElement(rootElement.getId());
		}
		addRootElement(choreography);
		return choreography;
	}

	public final Collaboration createCollaboration() {
		Collaboration collaboration = (Collaboration) generateRootElement(RootElements.TYPE_COLLABORATION);
		// collaboration.setId("_1");

		// BaseElement rootElement = (BaseElement) getRootElement("_1");
		// if (rootElement != null) {
		// removeRootElement(rootElement.getId());
		// if (rootElement instanceof BPMNProcess) {
		// rootElement.setId("P_1");
		// } else if (rootElement instanceof Choreography) {
		// rootElement.setId("C_1");
		// }
		// collaboration.addArtifacts(((FlowElementsContainer) rootElement).getArtifacts());
		// addRootElement(rootElement);
		// }

		addRootElement(collaboration);
		return collaboration;
	}

	public final DataStore createDataStore(String name) {
		DataStore dataStore = (DataStore) generateRootElement(RootElements.TYPE_DATASTORE);
		dataStore.setName(name);
		addRootElement(dataStore);
		return dataStore;
	}

	public final Participant addParticipant(String id, String name) {
		Collaboration collaboration = BPMNModelUtils.getCollaboration(this);
		if (collaboration == null) {
			collaboration = createCollaboration();
		}
		return collaboration.addParticipant(id, name);
	}

	public final Participant addParticipantInChoreography(String id, String name) {
		Choreography choreography = null;
		BaseElement rootElement = getRootElement("_1");
		if (rootElement == null || rootElement != null && rootElement instanceof BPMNProcess) {
			choreography = (Choreography) generateRootElement(RootElements.TYPE_COLLABORATION);
			choreography.setId(rootElement.getId());
			if (rootElement != null && rootElement != choreography) {
				removeRootElement(rootElement.getId());
				rootElement.setId("P_1");
				choreography.addArtifacts(((BPMNProcess) rootElement).getArtifacts());
				addRootElement(rootElement);
			}
			addRootElement(choreography);
		} else if (rootElement instanceof Choreography) {
			choreography = (Choreography) rootElement;
		}
		return choreography.addParticipant(id, name);
	}

	public void resetNamespace() {
		namespaces = new LinkedHashMap<String, String>();
		namespaces.put(BPMNModelConstants.BPMN_DI_NS, "bpmndi");
		namespaces.put(BPMNModelConstants.DI_NS, "di");
		namespaces.put(BPMNModelConstants.DC_NS, "dc");
		namespaces.put(BPMNModelConstants.XMLNS_XSI, "xsi");
		namespaces.put(BPMNModelConstants.XMLNS_XSD, "xsd");
		namespaces.put(BPMNModelConstants.YAOQIANG_NS, "yaoqiang");
	}

	public void resetTypes() {
		types = new HashSet<String>();
		String[] types = null;
		String type = getTypeLanguage();
		if (type.equals("http://www.java.com/javaTypes")) {
			types = new String[] { "String", "Boolean", "Integer", "Long", "Double", "Float" };
		}
		if (types != null) {
			addTypes(Arrays.asList(types));
		}
	}

	public void clear() {
		importedElements.clear();
		getImports().clear();
		getRootElements().clear();
		getBPMNDiagrams().clear();
		resetNamespace();
		resetTypes();
	}

}

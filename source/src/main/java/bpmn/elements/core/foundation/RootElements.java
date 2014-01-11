package org.yaoqiang.model.bpmn.elements.core.foundation;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;
import org.yaoqiang.model.bpmn.elements.artifacts.Category;
import org.yaoqiang.model.bpmn.elements.choreography.Choreography;
import org.yaoqiang.model.bpmn.elements.choreography.GlobalChoreographyTask;
import org.yaoqiang.model.bpmn.elements.collaboration.Collaboration;
import org.yaoqiang.model.bpmn.elements.collaboration.conversations.GlobalConversation;
import org.yaoqiang.model.bpmn.elements.core.common.BPMNError;
import org.yaoqiang.model.bpmn.elements.core.common.CorrelationProperty;
import org.yaoqiang.model.bpmn.elements.core.common.ItemDefinition;
import org.yaoqiang.model.bpmn.elements.core.common.Message;
import org.yaoqiang.model.bpmn.elements.core.common.PartnerEntity;
import org.yaoqiang.model.bpmn.elements.core.common.PartnerRole;
import org.yaoqiang.model.bpmn.elements.core.common.Resource;
import org.yaoqiang.model.bpmn.elements.core.infrastructure.Definitions;
import org.yaoqiang.model.bpmn.elements.core.service.EndPoint;
import org.yaoqiang.model.bpmn.elements.core.service.Interface;
import org.yaoqiang.model.bpmn.elements.events.CancelEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.CompensateEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.ConditionalEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.ErrorEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.Escalation;
import org.yaoqiang.model.bpmn.elements.events.EscalationEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.EventDefinition;
import org.yaoqiang.model.bpmn.elements.events.LinkEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.MessageEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.Signal;
import org.yaoqiang.model.bpmn.elements.events.SignalEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.TerminateEventDefinition;
import org.yaoqiang.model.bpmn.elements.events.TimerEventDefinition;
import org.yaoqiang.model.bpmn.elements.process.BPMNProcess;
import org.yaoqiang.model.bpmn.elements.process.GlobalTask;
import org.yaoqiang.model.bpmn.elements.process.activities.GlobalBusinessRuleTask;
import org.yaoqiang.model.bpmn.elements.process.activities.GlobalScriptTask;
import org.yaoqiang.model.bpmn.elements.process.data.DataStore;
import org.yaoqiang.model.bpmn.elements.process.humaninteraction.GlobalManualTask;
import org.yaoqiang.model.bpmn.elements.process.humaninteraction.GlobalUserTask;

/**
 * RootElements
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class RootElements extends XMLFactoryElement {

	private static final long serialVersionUID = 3046741985771208991L;

	public static final String TYPE_RESOURCE = "resource";

	public static final String TYPE_CATEGORY = "category";
	public static final String TYPE_DATASTORE = "dataStore";

	public static final String TYPE_ITEM_DEFINITION = "itemDefinition";
	public static final String TYPE_INTERFACE = "interface";

	public static final String TYPE_COLLABORATION = "collaboration";
	public static final String TYPE_CHOREOGRAPHY = "choreography";

	public static final String TYPE_EVENT_DEFINITION = "eventDefinition";
	public static final String TYPE_CANCEL_EVENT_DEFINITION = "cancelEventDefinition";
	public static final String TYPE_COMPENSATE_EVENT_DEFINITION = "compensateEventDefinition";
	public static final String TYPE_CONDITIONAL_EVENT_DEFINITION = "conditionalEventDefinition";
	public static final String TYPE_ERROR_EVENT_DEFINITION = "errorEventDefinition";
	public static final String TYPE_ESCALATION_EVENT_DEFINITION = "escalationEventDefinition";
	public static final String TYPE_LINK_EVENT_DEFINITION = "linkEventDefinition";
	public static final String TYPE_MESSAGE_EVENT_DEFINITION = "messageEventDefinition";
	public static final String TYPE_SIGNAL_EVENT_DEFINITION = "signalEventDefinition";
	public static final String TYPE_TERMINATE_EVENT_DEFINITION = "terminateEventDefinition";
	public static final String TYPE_TIMER_EVENT_DEFINITION = "timerEventDefinition";

	public static final String TYPE_GLOBAL_TASK = "globalTask";
	public static final String TYPE_GLOBAL_USER_TASK = "globalUserTask";
	public static final String TYPE_GLOBAL_SCRIPT_TASK = "globalScriptTask";
	public static final String TYPE_GLOBAL_MANUAL_TASK = "globalManualTask";
	public static final String TYPE_GLOBAL_BUSINESS_RULE_TASK = "globalBusinessRuleTask";

	public static final String TYPE_ERROR = "error";
	public static final String TYPE_ESCALATION = "escalation";
	public static final String TYPE_MESSAGE = "message";
	public static final String TYPE_PROCESS = "process";
	public static final String TYPE_SIGNAL = "signal";

	public static final String TYPE_PARTNER = "partner";
	public static final String TYPE_PARTNER_ENTITY = "partnerEntity";
	public static final String TYPE_PARTNER_ROLE = "partnerRole";

	public RootElements(Definitions parent) {
		super(parent, "rootElements");
	}

	public XMLElement generateNewElement() {
		EventDefinition eventDefinition = null;
		GlobalTask globalTask = null;
		if (type.equals(TYPE_CATEGORY)) {
			Category category = new Category(this);
			category.setId(createId("CAT"));
			return category;
		} else if (type.equals(TYPE_COLLABORATION)) {
			Collaboration collaboration = new Collaboration(this);
			collaboration.setId(createId("COLLABORATION"));
			return collaboration;
		} else if (type.equals(TYPE_CHOREOGRAPHY)) {
			return new Choreography(this);
		} else if (type.equals("globalChoreographyTask")) {
			return new GlobalChoreographyTask(this);
		} else if (type.equals("globalConversation")) {
			return new GlobalConversation(this);
		} else if (type.equals("correlationProperty")) {
			return new CorrelationProperty(this);
		} else if (type.equals(TYPE_DATASTORE)) {
			DataStore dataStore = new DataStore(this);
			dataStore.setId(createId("DS"));
			return dataStore;
		} else if (type.equals("endPoint")) {
			return new EndPoint(this);
		} else if (type.equals(TYPE_ERROR)) {
			BPMNError error = new BPMNError(this);
			error.setId(createId("ERR"));
			return error;
		} else if (type.equals(TYPE_ESCALATION)) {
			Escalation escalation = new Escalation(this);
			escalation.setId(createId("ES"));
			return escalation;
		} else if (type.equals(TYPE_CANCEL_EVENT_DEFINITION)) {
			eventDefinition = new CancelEventDefinition(this);
		} else if (type.equals(TYPE_COMPENSATE_EVENT_DEFINITION)) {
			eventDefinition = new CompensateEventDefinition(this);
		} else if (type.equals(TYPE_CONDITIONAL_EVENT_DEFINITION)) {
			eventDefinition = new ConditionalEventDefinition(this);
		} else if (type.equals(TYPE_ERROR_EVENT_DEFINITION)) {
			eventDefinition = new ErrorEventDefinition(this);
		} else if (type.equals(TYPE_ESCALATION_EVENT_DEFINITION)) {
			eventDefinition = new EscalationEventDefinition(this);
		} else if (type.equals(TYPE_LINK_EVENT_DEFINITION)) {
			eventDefinition = new LinkEventDefinition(this);
		} else if (type.equals(TYPE_MESSAGE_EVENT_DEFINITION)) {
			eventDefinition = new MessageEventDefinition(this);
		} else if (type.equals(TYPE_SIGNAL_EVENT_DEFINITION)) {
			eventDefinition = new SignalEventDefinition(this);
		} else if (type.equals(TYPE_TERMINATE_EVENT_DEFINITION)) {
			eventDefinition = new TerminateEventDefinition(this);
		} else if (type.equals(TYPE_TIMER_EVENT_DEFINITION)) {
			eventDefinition = new TimerEventDefinition(this);
		} else if (type.equals(TYPE_GLOBAL_BUSINESS_RULE_TASK)) {
			globalTask = new GlobalBusinessRuleTask(this);
		} else if (type.equals(TYPE_GLOBAL_MANUAL_TASK)) {
			globalTask = new GlobalManualTask(this);
		} else if (type.equals(TYPE_GLOBAL_SCRIPT_TASK)) {
			globalTask = new GlobalScriptTask(this);
		} else if (type.equals(TYPE_GLOBAL_TASK)) {
			globalTask = new GlobalTask(this);
		} else if (type.equals(TYPE_GLOBAL_USER_TASK)) {
			globalTask = new GlobalUserTask(this);
		} else if (type.equals(TYPE_INTERFACE)) {
			Interface _interface = new Interface(this);
			_interface.setId(createId("IF"));
			return _interface;
		} else if (type.equals(TYPE_ITEM_DEFINITION)) {
			ItemDefinition itemDefinition = new ItemDefinition(this);
			itemDefinition.setId(createId("ID"));
			return itemDefinition;
		} else if (type.equals(TYPE_MESSAGE)) {
			Message message = new Message(this);
			message.setId(createId("MSG"));
			return message;
		} else if (type.equals(TYPE_PARTNER_ENTITY)) {
			PartnerEntity partnerEntity = new PartnerEntity(this);
			partnerEntity.setId(createId("PE"));
			return partnerEntity;
		} else if (type.equals(TYPE_PARTNER_ROLE)) {
			PartnerRole partnerRole = new PartnerRole(this);
			partnerRole.setId(createId("PR"));
			return partnerRole;
		} else if (type.equals(TYPE_PROCESS)) {
			BPMNProcess process = new BPMNProcess(this);
			process.setId(createId("PROCESS"));
			return process;
		} else if (type.equals(TYPE_RESOURCE)) {
			Resource resource = new Resource(this);
			resource.setId(createId("RS"));
			return resource;
		} else if (type.equals(TYPE_SIGNAL)) {
			Signal signal = new Signal(this);
			signal.setId(createId("SIG"));
			return signal;
		}
		if (eventDefinition != null) {
			eventDefinition.setId(createId("ED"));
			return eventDefinition;
		} else if (globalTask != null) {
			globalTask.setId(createId("GT"));
			return globalTask;
		}

		return null;
	}

}

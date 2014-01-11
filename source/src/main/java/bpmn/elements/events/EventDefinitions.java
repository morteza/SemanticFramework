package org.yaoqiang.model.bpmn.elements.events;

import org.yaoqiang.model.XMLElement;
import org.yaoqiang.model.XMLFactoryElement;

/**
 * EventDefinitions
 * 
 * @author Shi Yaoqiang(shi_yaoqiang@yahoo.com)
 */
public class EventDefinitions extends XMLFactoryElement {

	private static final long serialVersionUID = -1073387052460185904L;
	
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
	
	public EventDefinitions(Event parent) {
		super(parent, "eventDefinitions");
	}

	public XMLElement generateNewElement() {
		EventDefinition eventDefinition = null;
		if (type.equals("cancelEventDefinition")) {
			eventDefinition = new CancelEventDefinition(this);
		} else if (type.equals("compensateEventDefinition")) {
			eventDefinition = new CompensateEventDefinition(this);
		} else if (type.equals("conditionalEventDefinition")) {
			eventDefinition = new ConditionalEventDefinition(this);
		} else if (type.equals("errorEventDefinition")) {
			eventDefinition = new ErrorEventDefinition(this);
		} else if (type.equals("escalationEventDefinition")) {
			eventDefinition = new EscalationEventDefinition(this);
		} else if (type.equals("linkEventDefinition")) {
			eventDefinition = new LinkEventDefinition(this);
		} else if (type.equals("messageEventDefinition")) {
			eventDefinition = new MessageEventDefinition(this);
		} else if (type.equals("signalEventDefinition")) {
			eventDefinition = new SignalEventDefinition(this);
		} else if (type.equals("terminateEventDefinition")) {
			eventDefinition = new TerminateEventDefinition(this);
		} else if (type.equals("timerEventDefinition")) {
			eventDefinition = new TimerEventDefinition(this);
		}
		if (eventDefinition != null) {
			eventDefinition.setId(createId(((Event)getParent()).getId() + "_ED"));
		}
		return eventDefinition;
	}
	
}

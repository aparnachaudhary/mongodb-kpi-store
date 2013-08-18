/**
 * 
 */
package net.arunoday.kpi.engine.entity;

import java.util.Date;

/**
 * Gauge Event Entity. Represents gauge event type which returns a single value. The metadata associated can be stored
 * along with this event.
 * 
 * @author Aparna Chaudhary
 * 
 */
public class GaugeEventEntity {

	/** unique identifier for this event */
	private String id;
	/** Time of occurrence of event */
	private Date occuredOn;
	/** Type of event. */
	private String eventType;
	/** value for this event */
	private double value;
	/** Metadata associated with this event */
	private ContextData contextData;

	/**
	 * Default constructor
	 */
	public GaugeEventEntity() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param occuredOn time of event occurrence
	 * @param eventType type of event
	 * @param value value for this event
	 */
	public GaugeEventEntity(Date occuredOn, String eventType, double value) {
		this(occuredOn, eventType, value, null);
	}

	/**
	 * Constructor
	 * 
	 * @param occuredOn time of event occurrence
	 * @param eventType type of event
	 * @param value value for this event
	 * @param contextData metadata associated with this event
	 */
	public GaugeEventEntity(Date occuredOn, String eventType, double value, ContextData contextData) {
		super();
		this.occuredOn = occuredOn;
		this.eventType = eventType;
		this.value = value;
		this.contextData = contextData;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOccuredOn() {
		return occuredOn;
	}

	public void setOccuredOn(Date occuredOn) {
		this.occuredOn = occuredOn;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public ContextData getContextData() {
		return contextData;
	}

	public void setContextData(ContextData contextData) {
		this.contextData = contextData;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !getClass().equals(obj.getClass())) {
			return false;
		}
		GaugeEventEntity that = (GaugeEventEntity) obj;
		return this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public String toString() {
		return "GaugeEventEntity [id=" + id + ", occuredOn=" + occuredOn + ", eventType=" + eventType + ", value="
				+ value + ", contextData=" + contextData + "]";
	}

}

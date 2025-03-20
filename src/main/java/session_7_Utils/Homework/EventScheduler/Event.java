package session_7_Utils.Homework.EventScheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event {
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventDateTime;
    private LocalDateTime reminderDateTime;
    private final LocalDateTime currentTime = LocalDateTime.now();

    public Event(String eventName, String eventDescription, LocalDateTime eventDateTime, LocalDateTime reminderDateTime) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.reminderDateTime = reminderDateTime;
    }

    public Event(String eventName, String eventDescription, LocalDateTime eventDateTime) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.reminderDateTime = eventDateTime.minusDays(1);
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public long timeUntilEvent(){
        Duration duration = Duration.between(currentTime, eventDateTime);
        return duration.toHours();
    }

    public long timeUntilReminder(){
        Duration duration = Duration.between(currentTime, reminderDateTime);
        return duration.toHours();
    }

    @Override
    public String toString() {
        return String.format("%s on %s at %s", getEventName(), getEventDateTime().toLocalDate(), eventDateTime.toLocalTime());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;
        return Objects.equals(getEventName(), event.getEventName()) && Objects.equals(getEventDateTime(), event.getEventDateTime());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getEventName());
        result = 31 * result + Objects.hashCode(getEventDateTime());
        return result;
    }
}

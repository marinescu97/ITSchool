package session_7_Utils.Homework.EventScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler {
    private final List<Event> events;

    public Scheduler() {
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public boolean addEvent(Event e){
        int index = Collections.binarySearch(events, e);
        if (index < 0){
            index = -(index + 1);
            events.add(index, e);
            return true;
        }

        System.out.println("The event is already in the list.");
        return false;
    }

    public boolean removeEvent(String eventName){
        return events.removeIf(event -> event.getEventName().equals(eventName));
    }

    public Event[] getUpcomingEvents(int n){
        if (n > events.size()){
            n = events.size();
        }
        Event[] upcomingEvents = new Event[n];

        for (int i = 0; i < n; i++){
            upcomingEvents[i] = events.get(i);
        }

        return upcomingEvents;
    }

    public List<Event> getEventsOn(LocalDate date){
        List<Event> eventsOn = new ArrayList<>();

        for (Event event : events){
            if (event.getEventDateTime().toLocalDate().isEqual(date)){
                eventsOn.add(event);
            }
        }

        return eventsOn;
    }

    public List<Event> getPendingReminders(){
        List<Event> pendingReminders = new ArrayList<>();

        for (Event event : events){
            if (event.timeUntilReminder() <= 24){
                pendingReminders.add(event);
            }
        }
        return pendingReminders;
    }
}

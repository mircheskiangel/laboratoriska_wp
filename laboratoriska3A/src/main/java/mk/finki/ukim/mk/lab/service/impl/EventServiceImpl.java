package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.SavedBooking;
import mk.finki.ukim.mk.lab.repository.InMemoryEventRepository;
import mk.finki.ukim.mk.lab.repository.InMemoryLocationRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final InMemoryEventRepository eventRepository;
    private final InMemoryLocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository, InMemoryEventRepository eventRepository1, LocationRepository locationRepository1, InMemoryEventRepository eventRepository2, InMemoryLocationRepository locationRepository2) {


        this.eventRepository = eventRepository2;
        this.locationRepository = locationRepository2;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        if (location != null) {
            Event event = new Event(name, description, popularityScore, location);
            return eventRepository.save(name,description,popularityScore,location);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationId) {
        Event event = eventRepository.findById(id).orElse(null);
        Location location = locationRepository.findById(locationId).orElse(null);

        if (event != null) {
            event.setName(name);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            event.setLocation(location);

            return this.eventRepository.save(name,description,popularityScore,location);
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void changeEventRating(Long id, String type) {
        eventRepository.findById(id).ifPresent(event -> {
            if ("increment".equalsIgnoreCase(type)) {
                event.setPopularityScore(event.getPopularityScore() + 1);
            } else if ("decrease".equalsIgnoreCase(type)) {
                event.setPopularityScore(event.getPopularityScore() - 1);
            }
            event.setRatingManipulated(true);
            eventRepository.save(event.getName(), event.getDescription(),event.getPopularityScore(),event.getLocation());
        });
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> findAllByLocationId(Long locationId) {

        return eventRepository.findAll();
    }
}

package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {

    public static List<Event> eventList = new ArrayList<>();
    public static List<Location> locationList = new ArrayList<>();
    @PostConstruct
    public void init()
    {

        locationList.add(new Location("Brazil", "Brasilia 1", "1234", "Brazil description"));
        locationList.add(new Location("Germany", "Germany 2", "2345", "Germany description"));
        locationList.add(new Location("Austria", "Austria 3", "5312", "Austria description"));
        locationList.add(new Location("Iceland", "Iceland 4", "6421", "Iceland description"));
        locationList.add(new Location("France", "France 5", "3432", "France description"));

        eventList.add(new Event("Rio Carnival", "The world’s largest carnival", 8.70,locationList.get(0)));
        eventList.add(new Event("Diwali", "The Hindu Festival of Lights", 7.10,locationList.get(1)));
        eventList.add(new Event("Oktoberfest", "A lively Bavarian beer festival in Munich", 9.30,locationList.get(2)));
        eventList.add(new Event("La Tomatina", "A fun-filled tomato-throwing festival in Bunol", 6.80,locationList.get(3)));
        eventList.add(new Event("Mardi Gras", "New Orleans' iconic festival with parades", 7.40,locationList.get(4)));
        eventList.add(new Event("Holi", "Known as the Festival of Colors", 9.00,locationList.get(0)));
        eventList.add(new Event("Glastonbury Festival", "One of the world’s biggest music festivals", 9.10,locationList.get(1)));
        eventList.add(new Event("Chinese New Year", "Celebrated worldwide with dragon dances", 8.10,locationList.get(2)));
        eventList.add(new Event("Day of the Dead", "A colorful celebration honoring deceased loved ones with altars", 6.60,locationList.get(3)));
        eventList.add(new Event("Burning Man", "A unique gathering in Nevada’s Black Rock Desert", 7.40,locationList.get(4)));

    }

}

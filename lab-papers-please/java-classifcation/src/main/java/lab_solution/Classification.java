package lab_solution;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Classification {
    private final ObjectMapper mapper;
    private final Universe starWars;
    private final Universe hitchhikers;
    private final Universe marvel;
    private final Universe rings;
    private final Universe unclassified;

    public Classification() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        starWars = new Universe("Star Wars", new ArrayList<>());
        hitchhikers = new Universe("Hitchhiker", new ArrayList<>());
        marvel = new Universe("Marvel", new ArrayList<>());
        rings = new Universe("Lord of the Rings", new ArrayList<>());
        unclassified = new Universe("Unclassified", new ArrayList<>());
    }

    //checking the planet
    public boolean verifyPlanet(Person person) {
        switch (person.getPlanet()) {
            case "Kashyyk", "Endor" -> {
                starWars.individuals().add(person);
                return true;
            }
            case "Asgard" -> {
                marvel.individuals().add(person);
                return true;
            }
            case "Betelgeuse", "Vogsphere" -> {
                hitchhikers.individuals().add(person);
                return true;
            }
            case "Earth" -> {
                rings.individuals().add(person);
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    //checking the trait and humanoid value
    public boolean verifyTrait(Person person) {
        if (person.containsTrait(person.getTraits(), "HAIRY")) {
            starWars.individuals().add(person);
            return true;
        } else if (person.containsTrait(person.getTraits(), "BLONDE")) {
            marvel.individuals().add(person);
            return true;
        } else if (person.containsTrait(person.getTraits(), "EXTRA_ARMS") || person.containsTrait(person.getTraits(), "EXTRA_HEAD") || person.containsTrait(person.getTraits(), "GREEN")) {
            hitchhikers.individuals().add(person);
            return true;
        } else if (person.containsTrait(person.getTraits(), "POINTY-EYES") || (person.containsTrait(person.getTraits(), "SHORT") && person.containsTrait(person.getTraits(), "BULKY"))) {
            rings.individuals().add(person);
            return true;
        } else if (person.containsTrait(person.getTraits(), "TALL")) {
            if (!person.getHumanoid()) {
                starWars.individuals().add(person);
                return true;
            } else if (person.getHumanoid() || person.getAge() > 400) {
                marvel.individuals().add(person);
                return true;
            }
        } else if (person.containsTrait(person.getTraits(), "SHORT")) {
            if (!person.getHumanoid()) {
                starWars.individuals().add(person);
                return true;
            } else if (person.getHumanoid() || person.getAge() > 60) {
                rings.individuals().add(person);
                return true;
            }
        } else if (person.containsTrait(person.getTraits(), "BULKY")) {
            if (!person.getHumanoid()) {
                hitchhikers.individuals().add(person);
                return true;
            } else if (person.getHumanoid()) {
                rings.individuals().add(person);
                return true;
            }
        }
        return false;
    }

    //checking age
    public boolean verifyAge(Person person) {
        rings.individuals().add(person);
        return true;
    }

    //default
    public void notClassified(Person person) {
        unclassified.individuals().add(person);
    }

    // writing classified data to JSON files
    public void writeOutput() throws IOException {
        mapper.writeValue(new File("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\java\\lab_solution\\output\\starwars.json"), starWars);
        mapper.writeValue(new File("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\java\\lab_solution\\output\\hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\java\\lab_solution\\output\\rings.json"), rings);
        mapper.writeValue(new File("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\java\\lab_solution\\output\\marvel.json"), marvel);
        mapper.writeValue(new File("C:\\Users\\user\\IdeaProjects\\OOP_Lab2\\lab-papers-please\\java-classifcation\\src\\main\\java\\lab_solution\\output\\unclassified.json"), unclassified);
    }
}

record Universe(
        String name,
        List<Person> individuals
) { }


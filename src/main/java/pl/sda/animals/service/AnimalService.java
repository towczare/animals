package pl.sda.animals.service;

import pl.sda.animals.model.Animal;

import java.util.HashMap;
import java.util.Map;

public class AnimalService {

    private static Map<Integer, Animal> ANIMALS = new HashMap<>();

    static {
        ANIMALS.put(1, new Animal("Reksio"));
        ANIMALS.put(2, new Animal("Filemon"));
        ANIMALS.put(3, new Animal("Miś Uszatek"));
    }

    public static Map<Integer, Animal> findAll() {
        return ANIMALS;
    }

    public static Animal findById(String id) {
        Animal animal = ANIMALS.get(Integer.valueOf(id));
        return animal;
    }

    public static void add(String name) {
        Animal newAnimal = new Animal(name);
        ANIMALS.put(ANIMALS.size() + 1, newAnimal);
    }
}

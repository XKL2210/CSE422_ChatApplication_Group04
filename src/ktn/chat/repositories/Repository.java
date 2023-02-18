package ktn.chat.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<Entity> implements ResInterface<Entity>{
	private List<Entity> entities;

    public Repository() {
        this.entities = new ArrayList<>();
    }

    public Repository(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public Iterable<Entity> get(Predicate<Entity> predicate, Comparator<Entity> orderBy) {
        List<Entity> match;

        if (predicate == null) {
            return entities;
        }

        if (orderBy != null) {
            match = this.entities.stream().filter(predicate).sorted(orderBy).toList();
        } else {
            match = this.entities.stream().filter(predicate).toList();
        }

        return match;
    }

    @Override
    public Entity find(Predicate<Entity> predicate) {
        Entity entity = this.entities.stream().filter(predicate).findFirst().orElse(null);
        return entity;
    }

    @Override
    public void insert(Entity entity) {
        this.entities.add(entity);
    }

    @Override
    public void delete(Entity entity) {
        this.entities.remove(entity);
    };

}

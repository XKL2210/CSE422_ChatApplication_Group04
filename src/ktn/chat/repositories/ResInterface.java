package ktn.chat.repositories;

import java.util.List;
import java.util.Comparator;
import java.util.function.Predicate;

public interface ResInterface<Entity> {
	Iterable<Entity> get(Predicate<Entity> predicate, Comparator<Entity> orderBy);
    Entity find(Predicate<Entity> predicate);
    void insert(Entity entity);
    void delete(Entity entity);
}

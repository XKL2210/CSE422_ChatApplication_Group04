package ktn.chat.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<Entity> implements IRepository<Entity>{
	List<Entity> list = new ArrayList<>();

	@Override
	public List<Entity> get(Predicate<Entity> predicate, Comparator<Entity> filter) {
		List<Entity> result;
        result = list.stream().filter(predicate).sorted(filter).collect(Collectors.toList());
        return result;
	}

	@Override
	public Entity find(Predicate<Entity> predicate) {
		return list.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public void insert(Entity entity) {
		list.add(entity);
	}

	@Override
	public void update(Entity entity, Entity entity1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entity entity) {
		list.remove(entity);
	}
	
}

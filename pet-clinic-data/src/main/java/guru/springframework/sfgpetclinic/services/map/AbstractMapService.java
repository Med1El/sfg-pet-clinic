package guru.springframework.sfgpetclinic.services.map;

import javafx.util.Pair;

import java.util.*;

public class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id,T object) {
        map.put(id, object);
        return object;
    }

    void deleteById(Long id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

}

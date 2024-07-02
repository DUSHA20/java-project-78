package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    public MapSchema() {
        this.addPredicate("isRequired", o -> o != null);
    }

    @Override
    public MapSchema<K, V> required() {
        this.isRequired = true;
        this.addPredicate("isRequired", o -> o != null);
        return this;
    }

    public MapSchema<K, V> sizeof(int sizeRequirement) {
        Predicate<Map<K, V>> predicate = o -> o != null && o.size() == sizeRequirement;
        this.addPredicate("sizeof", predicate);
        return this;
    }

    public MapSchema<K, V> shape(Map<String, BaseSchema<?>> schemas) {
        Predicate<Map<K, V>> predicate = map -> map != null && schemas.entrySet()
                .stream()
                .allMatch(entry -> {
                    BaseSchema<Object> schema = (BaseSchema<Object>) entry.getValue();
                    Object value = map.get(entry.getKey());
                    return schema.isValid(value);
                });
        this.addPredicate("shape", predicate);
        return this;
    }
}


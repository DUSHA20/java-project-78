package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    public MapSchema() {
        this.addPredicate("isRequired", o -> o instanceof Map<?, ?>);
    }

    @Override
    public MapSchema<K, V> required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema<K, V> sizeof(int sizeRequirement) {
        Predicate<Map<K, V>> predicate = o -> o.size() == sizeRequirement;
        this.addPredicate("sizeof", predicate);
        return this;
    }

    public MapSchema<K, V> shape(Map<String, ? extends BaseSchema<String>> schema) {
        Predicate<Map<K, V>> predicate = o -> schema.entrySet()
                .stream()
                .allMatch(entry -> {
                    BaseSchema<String> baseSchema = entry.getValue();
                    Object value = o.get(entry.getKey());
                    return value == null || (value != null && baseSchema.isValid((String) value));
                });
        this.addPredicate("shape", predicate);
        return this;
    }
}


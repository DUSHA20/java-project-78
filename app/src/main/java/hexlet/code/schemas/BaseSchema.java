package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected LinkedHashMap<String, Predicate<T>> predicates = new LinkedHashMap<>();

    protected final void addPredicate(String name, Predicate<T> predicate) {
        this.predicates.put(name, predicate);
    }

    public abstract BaseSchema<T> required();

    public final boolean isValid(T obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        return predicates.keySet().stream()
                .allMatch(o -> predicates.get(o).test(obj));
    }
}


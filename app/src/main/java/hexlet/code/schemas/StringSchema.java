package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<Object> {

    public StringSchema() {
        addPredicate("isRequired", o -> o instanceof String && !((String) o).isEmpty());
    }

    @Override
    public StringSchema required() {
        this.isRequired = true;
        Predicate<Object> predicate = o -> o != null && !o.toString().isEmpty();
        addPredicate("isRequired", predicate);
        return this;
    }

    public StringSchema minLength(int addedMinLength) {
        Predicate<Object> predicate = o -> o instanceof String && ((String) o).length() >= addedMinLength;
        this.addPredicate("minLength", predicate);
        return this;
    }

    public StringSchema contains(String addedRequiredString) {
        Predicate<Object> predicate = o -> o instanceof String && ((String) o).contains(addedRequiredString);
        addPredicate("contains", predicate);
        return this;
    }

    public StringSchema containsSubstring(String substring) {
        Predicate<Object> predicate = o -> o instanceof String && ((String) o).contains(substring);
        addPredicate("containsSubstring", predicate);
        return this;
    }
}

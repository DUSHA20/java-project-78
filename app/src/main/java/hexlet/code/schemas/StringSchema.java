package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addPredicate("isRequired", o -> o != null && !o.isEmpty());
    }

    @Override
    public StringSchema required() {
        this.isRequired = true;
        Predicate<String> predicate = o -> o != null && !o.isEmpty();
        addPredicate("isRequired", predicate);
        return this;
    }

    public StringSchema minLength(int addedMinLength) {
        Predicate<String> predicate = o -> o != null && o.length() >= addedMinLength;
        this.addPredicate("minLength", predicate);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<String> predicate = o -> o != null && o.contains(substring);
        addPredicate("contains", predicate);
        return this;
    }
}

package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema<T extends Number> extends BaseSchema<T> {

    public NumberSchema() {
        this.addPredicate("isRequired", o -> o instanceof Number);
    }

    @Override
    public NumberSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema<T> positive() {
        this.addPredicate("positive", o -> o == null || o.doubleValue() > 0);
        return this;
    }

    public NumberSchema<T> range(T lowest, T highest) {
        Predicate<T> predicate = o -> o.doubleValue() >= lowest.doubleValue() && o.doubleValue() <= highest.doubleValue();
        this.addPredicate("range", predicate);
        return this;
    }
}

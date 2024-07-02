package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Number> {

    public NumberSchema() {
        this.addPredicate("isRequired", o -> o != null);
    }

    @Override
    public NumberSchema required() {
        this.isRequired = true;
        this.addPredicate("isRequired", o -> o != null);
        return this;
    }

    public NumberSchema positive() {
        this.addPredicate("positive", o -> o == null || ((Number) o).doubleValue() > 0);
        return this;
    }

    public NumberSchema range(Number lowest, Number highest) {
        Predicate<Number> predicate = o -> {
            if (o == null) {
                return false;
            }
            double value = o.doubleValue();
            double lowestValue = lowest.doubleValue();
            double highestValue = highest.doubleValue();
            return value >= lowestValue && value <= highestValue;
        };
        this.addPredicate("range", predicate);
        return this;
    }
}

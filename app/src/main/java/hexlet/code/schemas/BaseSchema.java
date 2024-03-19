package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected boolean required = false;

    private List<Predicate<Object>> predicates = new ArrayList<>();

    public BaseSchema() {
        addPredicate(s -> s != null);
    }

    public boolean isValid(Object object) {
        if (isEmptyValue(object)) {
            return !required;
        } else {
            return predicates.stream().allMatch(predicate -> predicate.test(object));
        }
    }

    protected boolean isEmptyValue(Object object) {
        return object == null;
    }

    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    public void setRequired(boolean req) {
        this.required = req;
    }
}


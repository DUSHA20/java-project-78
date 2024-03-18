package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private boolean required = false;

    private List<Predicate<Object>> predicates = new ArrayList<>();

    public boolean isValid(Object object) {

        if (checkIfNull(object)) {
            return !required;
        } else {
            return predicates.stream().allMatch(predicate -> predicate.test(object));
        }
    }

    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    public boolean checkIfNull(Object object) {
        return object == null;
    }

    public void setRequired(boolean req) {
        this.required = req;
    }

}


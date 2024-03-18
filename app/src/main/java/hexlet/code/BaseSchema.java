package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class BaseSchema {

    private boolean required = false;

    private List<Function<Object, Boolean>> checks = new ArrayList<>();

    public boolean isValid(Object object) {
        if (checkIfNull(object)) {
            return !required;
        } else {
            return checks.stream().allMatch(check -> check.apply(object));
        }
    }

    public void addCheck(Function<Object, Boolean> check) {
        checks.add(check);
    }

    public boolean checkIfNull(Object object) {
        return object == null;
    }

    public void setRequired(boolean req) {
        this.required = req;
    }

}

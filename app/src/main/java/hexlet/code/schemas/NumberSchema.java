package hexlet.code.schemas;

import hexlet.code.BaseSchema;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        addCheck(i -> i instanceof Integer && ((Integer) i) > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        addCheck(i -> i instanceof Integer && (((Integer) i) >= a && ((Integer) i) <= b));
        return this;
    }
}

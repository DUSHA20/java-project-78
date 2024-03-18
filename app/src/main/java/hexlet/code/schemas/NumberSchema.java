package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {


    public NumberSchema required() {
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        addPredicate(i -> i instanceof Integer && ((Integer) i) > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        addPredicate(i -> i instanceof Integer && (((Integer) i) >= a && ((Integer) i) <= b));
        return this;
    }
}

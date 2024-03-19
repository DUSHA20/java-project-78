package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
        // Add a predicate to check if the object is a String
        addPredicate(s -> s instanceof String);
    }

    public StringSchema required() {
        setRequired(true);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addPredicate(s -> ((String) s).length() >= minLength);
        return this;
    }

    public StringSchema contains(String contains) {
        addPredicate(s -> ((String) s).contains(contains));
        return this;
    }

    @Override
    protected boolean isEmptyValue(Object object) {
        return super.isEmptyValue(object) || ((String) object).isEmpty();
    }
}

package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

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
    public boolean checkIfNull(Object object) {
        return object == null || ((String) object).isEmpty();
    }
}

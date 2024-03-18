package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        setRequired(true);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCheck(s -> s instanceof String && ((String) s).length() >= minLength);
        return this;
    }

    public StringSchema contains(String contains) {
        addCheck(s -> s instanceof String && ((String) s).contains(contains));
        return this;
    }

    @Override
    public boolean checkIfNull(Object object) {
        return object == null || ((String) object).isEmpty();
    }
}

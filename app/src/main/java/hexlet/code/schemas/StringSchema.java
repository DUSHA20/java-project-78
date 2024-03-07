package hexlet.code.schemas;

import hexlet.code.BaseSchema;
import hexlet.code.StringOperations;

public class StringSchema extends BaseSchema<String> implements StringOperations {

    private int minLength = 0;
    private String contains = "";

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    @Override
    public boolean isValid(String data) {
        if (required && (data == null || data.isEmpty())) {
            return false;
        }

        return data != null && data.length() >= minLength && (contains.isEmpty() || data.contains(contains));
    } // может быть надо будет его исправить

    @Override
    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    @Override
    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }
}

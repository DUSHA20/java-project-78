package hexlet.code.schemas;

import hexlet.code.BaseSchema;
import hexlet.code.StringOperations;

public class StringSchema extends BaseSchema implements StringOperations  {
    private int minLength = 0;
    private String contains = "";

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    @Override
    public boolean isValid(Object data) {
        if (required && (data == null || !(data instanceof String))) {
            return false;
        }

        String strData = (String) data;

        return strData != null && strData.length() >= minLength && (contains.isEmpty() || strData.contains(contains));
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }
}

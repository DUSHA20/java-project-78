package hexlet.code;

public class StringSchema {
    private boolean required = false;
    private int minLength = 0;
    private String contains = "";

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }

    public boolean isValid(String data) {
        if (required && (data == null || data.isEmpty())) {
            return false;
        }

        if (data != null && data.length() < minLength) {
            return false;
        }

        return contains.isEmpty() || data.contains(contains);
    }
}

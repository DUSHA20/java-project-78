package hexlet.code;

public abstract class BaseSchema {
    protected boolean required = false;

    public BaseSchema required() {
        this.required = true;
        return this;
    }

    public abstract boolean isValid(Object data);
}

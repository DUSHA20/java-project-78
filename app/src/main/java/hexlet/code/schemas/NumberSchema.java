package hexlet.code.schemas;

import hexlet.code.BaseSchema;

public class NumberSchema extends BaseSchema {
    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        this.min = 1;
        this.max = Integer.MAX_VALUE;
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.min = min;
        this.max = max;
        return this;
    }

    @Override
    public boolean isValid(Object data) {
        if (required && !(data instanceof Integer)) {
            return false;
        }
        Integer intData = (Integer) data;
        return intData != null && intData >= min && intData <= max;
    }
}

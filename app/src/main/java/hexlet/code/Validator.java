package hexlet.code;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;

/**
 * Validator class provides methods for creating various schema validators.
 * This class can be extended to add custom validation methods.
 */
public class Validator {

    /**
     * Returns a new StringSchema instance.
     * @return StringSchema instance.
     */
    public StringSchema string() {
        return new StringSchema();
    }
    /**
     * Returns a new NumberSchema instance.
     * @return NumberSchema instance.
     */
    public NumberSchema number() {
        return new NumberSchema();
    }
    /**
     * Returns a new MapSchema instance.
     * @return MapSchema instance.
     */
    public MapSchema map() {
        return new MapSchema();
    }
}


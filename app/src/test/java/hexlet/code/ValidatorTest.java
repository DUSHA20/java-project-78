package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void testValidator() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("hex");

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    public void testStringSchema() {
        StringSchema schema = new StringSchema();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertFalse(schema.required().isValid(null));
        assertFalse(schema.required().isValid(""));
        assertTrue(schema.minLength(5).isValid("hello"));
        assertFalse(schema.minLength(5).isValid("hi"));
        assertTrue(schema.contains("hex").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }
}

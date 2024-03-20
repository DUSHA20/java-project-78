package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    @Test
    void numberSchemaTest() {
        Validator v = new Validator();
        NumberSchema<Integer> schema = v.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(8));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    void stringSchemaTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));

        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
        assertFalse(schema.minLength(5).isValid("fox"));
    }

    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema<String, String> schema = v.map();

        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        Map<String, String> data = new HashMap<>();
        assertTrue(schema.isValid(data));
        data.put("one", "two");

        schema.sizeof(2);

        assertFalse(schema.isValid(data));
        data.put("three", "four");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void testShape() {
        Validator v = new Validator();
        MapSchema<String, Object> schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        BaseSchema<String> firstNameSchema = v.string().required().contains("ya");
        BaseSchema<String> lastNameSchema = v.string().required().contains("ov");

        schemas.put("firstName", firstNameSchema);
        schemas.put("lastName", lastNameSchema);

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "Dusya");
        human1.put("lastName", "ovechkina");
        human1.put("age", 12);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("firstName", "");
        human2.put("lastName", "Ivanova");
        human2.put("age", 12);
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("firstName", "Sveta");
        human3.put("lastName", "Petrova");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("firstName", "Oleg");
        human4.put("lastName", "Sidorov");
        human4.put("age", -6);
        assertFalse(schema.isValid(human4));
    }

}


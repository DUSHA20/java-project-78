package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import hexlet.code.schemas.MapSchema;

public class MapSchemaTest {
    @Test
    public void testRequired() {
        MapSchema<String> schema = new MapSchema<>();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(Map.of()));
    }

    @Test
    public void testSizeOf() {
        MapSchema<String> schema = new MapSchema<>();
        assertFalse(schema.sizeof(2).isValid(Map.of()));
        assertTrue(schema.sizeof(2).isValid(Map.of("key1", "value1", "key2", "value2")));
    }
}

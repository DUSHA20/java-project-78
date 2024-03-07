package hexlet.code;
import hexlet.code.schemas.MapSchema;

public interface MapOperations<T> {
    MapSchema<T> sizeof(int size);
}

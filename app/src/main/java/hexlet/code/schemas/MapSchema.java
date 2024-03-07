package hexlet.code.schemas;

import hexlet.code.BaseSchema;
import hexlet.code.MapOperations;
import java.util.Map;

public class MapSchema<T> extends BaseSchema<Map<?, T>> implements MapOperations<T> {
    private Integer size;

    @Override
    public MapSchema<T> sizeof(int size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean isValid(Map<?, T> data) {
        if (required && (data == null || data.isEmpty())) {
            return false;
        }

        if (size != null && data != null && data.size() != size) {
            return false;
        }

        return true;
    }
}

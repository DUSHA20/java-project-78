package hexlet.code.schemas;

import hexlet.code.BaseSchema;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private Integer size;
    private Map<String, BaseSchema> shape;

    public MapSchema sizeof(int size) {
        this.size = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> shape) {
        this.shape = shape;
        return this;
    }

    @Override
    public boolean isValid(Object data) {
        if (required && (data == null || !(data instanceof Map) || ((Map<?, ?>) data).isEmpty())) {
            return false;
        }

        Map<?, ?> mapData = (Map<?, ?>) data;

        if (size != null && mapData.size() != size) {
            return false;
        }

        if (shape != null) {
            for (Map.Entry<String, BaseSchema> entry : shape.entrySet()) {
                String key = entry.getKey();
                BaseSchema nestedSchema = entry.getValue();
                if (!mapData.containsKey(key) || !nestedSchema.isValid(mapData.get(key))) {
                    return false;
                }
            }
        }

        return true;
    }
}

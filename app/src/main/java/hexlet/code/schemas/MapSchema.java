package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Map<String, BaseSchema> schemas = new HashMap<>();

    public MapSchema required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int x) {
        addCheck(m -> ((Map) m).size() == x);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> innerSchemas) {
        this.schemas = innerSchemas;
        return this;
    }

    public boolean innerCheck(Map<Object, Object> objectMap) {
        for (Map.Entry entry : objectMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (schemas.containsKey(key)) {
                BaseSchema sce = schemas.get(key);
                if (!sce.isValid(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Object object) {
        if (object != null && !schemas.isEmpty()) {
            return innerCheck((Map) object);
        } else {
            return super.isValid(object);
        }
    }
}

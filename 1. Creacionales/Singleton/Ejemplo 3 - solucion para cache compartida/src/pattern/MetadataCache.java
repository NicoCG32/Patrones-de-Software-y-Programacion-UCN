package pattern;

import java.util.HashMap;
import java.util.Map;

public final class MetadataCache {
    private static final MetadataCache INSTANCE = new MetadataCache();
    private final Map<String, String> values = new HashMap<>();

    private MetadataCache() { }
    public static MetadataCache getInstance() { return INSTANCE; }

    public String find(String key) {
        return values.computeIfAbsent(key, k -> "metadata cargada para " + k);
    }
}

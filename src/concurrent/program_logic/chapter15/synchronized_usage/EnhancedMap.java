package concurrent.program_logic.chapter15.synchronized_usage;

import java.util.Collections;
import java.util.Map;

public class EnhancedMap<K, V> {
    Map<K, V> map;

    public EnhancedMap(Map<K, V> map) {
        this.map = Collections.synchronizedMap(map);
    }


    public V putIfAbsent(K key, V value) {
        V old = map.get(key);
        if (old != null) {
            return old;
        }
        return map.put(key, value);

    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

}

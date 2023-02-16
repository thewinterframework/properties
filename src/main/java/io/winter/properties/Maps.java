package io.winter.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Maps {

	public static <K, V> Map<K,V> skipNulls(Map<K,V> map) {
		Map<K,V> newMap = new HashMap<>();
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (entry.getValue() != null) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		return newMap;
	}

	public static <K, V> Map<K,V> filter(Map<K,V> properties, Predicate<Map.Entry<K,V>> condition) {
		Map<K,V> newMap = new HashMap<>();
		for (Map.Entry<K, V> entry : properties.entrySet()) {
			if (condition.test(entry)) {
				newMap.put(entry.getKey(), entry.getValue());
			}
		}
		return newMap;
	}

}

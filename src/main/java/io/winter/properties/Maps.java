package io.winter.properties;

import java.util.HashMap;
import java.util.Map;

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

}

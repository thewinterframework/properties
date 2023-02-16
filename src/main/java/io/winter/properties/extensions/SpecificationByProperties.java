package io.winter.properties.extensions;

import io.winter.properties.Maps;
import org.gradle.api.Project;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SpecificationByProperties {

	public static PropertyMap createPropertyMap(Project project) {
		Map<String, ?> properties = Maps.filter(project.getProperties(),
				property -> property.getKey().startsWith("spigot.")
		);

		return new PropertyMap(properties);
	}

	public static class PropertyMap {
		private final Map<String, ?> map;

		public PropertyMap(Map<String, ?> map) {
			this.map = map;
		}

		public String getString(String key) {
			Object value = map.get(key);

			if (value == null) {
				return null;
			}

			return (String) map.get(key);
		}

		public List<String> getStringList(String key) {
			String value = getString(key);

			if (value == null) {
				return null;
			}

			return Arrays.asList(value.split(","));
		}
	}

}

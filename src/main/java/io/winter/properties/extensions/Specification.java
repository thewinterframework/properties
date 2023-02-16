package io.winter.properties.extensions;

import io.winter.properties.extensions.SpecificationByProperties.PropertyMap;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Specification {
	private String main;
	private String name;
	private String author;
	private String version;
	private String description;
	private String website;
	private String load;
	private String apiVersion;
	private List<String> authors;
	private List<String> depend;
	private String prefix;
	private List<String> softDepend;
	private List<String> loadBefore;
	private List<String> libraries;

	public boolean isInvalid() {
		return main.isEmpty() || name.isEmpty();
	}

	public Specification(PropertyMap properties) {
		this.main = properties.getString("spigot.main");
		this.apiVersion = properties.getString("spigot.api-version");
		this.author = properties.getString("spigot.author");
		this.authors = properties.getStringList("spigot.authors");
		this.depend = properties.getStringList("spigot.depend");
		this.description = properties.getString("spigot.description");
		this.load = properties.getString("spigot.load");
		this.loadBefore = properties.getStringList("spigot.loadbefore");
		this.libraries = properties.getStringList("spigot.libraries");
		this.name = properties.getString("spigot.name");
		this.prefix = properties.getString("spigot.prefix");
		this.softDepend = properties.getStringList("spigot.softdepend");
		this.version = properties.getString("spigot.version");
		this.website = properties.getString("spigot.website");
	}

	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<>();

		map.put("main", main);
		map.put("name", name);
		map.put("author", author);
		map.put("version", version);
		map.put("description", description);
		map.put("website", website);
		map.put("load", load);
		map.put("api-version", apiVersion);
		map.put("authors", authors);
		map.put("depend", depend);
		map.put("prefix", prefix);
		map.put("softdepend", softDepend);
		map.put("loadbefore", loadBefore);
		map.put("libraries", libraries);

		return map;
	}
}

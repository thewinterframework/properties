package io.winter.properties.extensions;

import com.fasterxml.jackson.annotation.JsonProperty;
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
	private @JsonProperty("api-version") String apiVersion;
	private List<String> authors;
	private List<String> depend;
	private String prefix;
	private @JsonProperty("softdepend") List<String> softDepend;
	private @JsonProperty("loadbefore") List<String> loadBefore;
	private List<String> libraries;
	private List<Command> commands;
	private List<Permission> permissions;

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
		map.put("commands", commands);
		map.put("permissions", permissions);
		return map;
	}
}

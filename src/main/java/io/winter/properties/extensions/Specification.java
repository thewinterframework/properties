package io.winter.properties.extensions;

import lombok.Data;

import java.util.List;

@Data
public class Specification {
	private String mainClass;
	private String pluginName;
	private String version;
	private String description;
	private String author;
	private String website;
	private String load;
	private String apiVersion;
	private List<String> authors;
	private List<String> depends;
	private String prefix;
	private List<String> softDepends;
	private List<String> loadBefore;
	private List<String> libraries;
	private List<Command> commands;
	private List<String> permissions;
}

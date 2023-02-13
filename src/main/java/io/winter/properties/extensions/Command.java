package io.winter.properties.extensions;

import lombok.Data;

import java.util.List;

@Data
public class Command {
	private String name;
	private String description;
	private String usage;
	private String permission;
	private String permissionMessage;
	private List<String> aliases;
}

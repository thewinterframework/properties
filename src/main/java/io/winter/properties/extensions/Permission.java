package io.winter.properties.extensions;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
	private String name;
	private String description;
	private boolean isDefault;
	private List<String> children;
}

package io.winter.properties.writer;

import io.winter.properties.extensions.Specification;
import org.gradle.api.Project;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PropertiesWriter {

	private final static Yaml YAML = new Yaml();
	private final static String RESOURCES_LOCATION = "resources/main";
	private final static String PLUGIN_PROPERTIES_FILE = "plugin.yml";

	private final File folder;

	public PropertiesWriter(Project project) {
		this.folder = project.getLayout().getBuildDirectory().dir(RESOURCES_LOCATION).get().getAsFile();
	}

	public void write(Specification specification) throws IOException {
		try (FileWriter writer = new FileWriter(new File(folder, PLUGIN_PROPERTIES_FILE))) {
			YAML.dump(specification.serialize(), writer);
		}
	}

}

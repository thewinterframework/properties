package io.winter.properties.writer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import io.winter.properties.extensions.Specification;
import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;

public class PropertiesWriter {

	private final static ObjectMapper MAPPER = new ObjectMapper(
			new YAMLFactory()
					.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
					.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
					.enable(YAMLGenerator.Feature.INDENT_ARRAYS))
			.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	private final File folder;

	public PropertiesWriter(Project project) {
		this.folder = project.getLayout().getBuildDirectory().dir("resources/main").get().getAsFile();
	}

	public void write(Specification specification) throws IOException {
		MAPPER.writeValue(new File(folder, "plugin.yml"), specification.serialize());
	}

}

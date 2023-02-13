package io.winter.properties.test;

import io.winter.properties.extensions.Specification;
import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeneratePropertiesTaskTest {

	@Test
	public void testPropertiesTask() {
		Project project = ProjectBuilder.builder().build();
		project.getPlugins().apply("io.winter.properties");

		Object pluginProperties = project.getExtensions().getByName("pluginProperties");

		Assertions.assertTrue(pluginProperties instanceof Specification);
	}

}

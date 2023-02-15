package io.winter.properties;

import io.winter.properties.extensions.Specification;
import io.winter.properties.writer.PropertiesWriter;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPlugin;

public class PropertiesPlugin implements Plugin<Project> {

	private final static String COMPILE_JAVA_TASK = "compileJava";

	@Override
	public void apply(Project project) {
		Specification specification = project.getExtensions()
				.create("pluginProperties", Specification.class);

		project.getTasks()
				.register("generatePluginProperties")
				.configure(task -> task.doFirst(action -> {
					PropertiesWriter writer = new PropertiesWriter(project);

					try {
						writer.write(specification);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}));

		project.getPlugins()
				.withType(JavaPlugin.class)
				.configureEach(javaPlugin -> {
					project.getTasks()
							.named(COMPILE_JAVA_TASK)
							.configure(task -> task.dependsOn("generatePluginProperties"));
				});
	}
}

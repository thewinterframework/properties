package io.winter.properties;

import io.winter.properties.extensions.Specification;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class PropertiesPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		Specification specification = project.getExtensions()
				.create("pluginProperties", Specification.class);

		project.getTasks()
				.register("generatePluginProperties")
				.configure(task -> {
					task.doFirst((firstTask) -> {
						System.out.println(specification.getMainClass());
						System.out.println(specification.getPluginName());
						System.out.println(specification.getVersion());
						System.out.println(specification.getDescription());
						System.out.println(specification.getAuthor());
						System.out.println(specification.getWebsite());
						System.out.println(specification.getLoad());
						System.out.println(specification.getApiVersion());
						System.out.println(specification.getAuthors());
						System.out.println(specification.getDepends());
						System.out.println(specification.getPrefix());
						System.out.println(specification.getSoftDepends());
						System.out.println(specification.getLoadBefore());
						System.out.println(specification.getLibraries());
						System.out.println(specification.getCommands());
						System.out.println(specification.getPermissions());
					});
				});
	}
}

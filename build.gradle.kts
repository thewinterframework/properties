plugins {
    id("java")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.1.0"
}

group = "io.winter"
version = "1.0-SNAPSHOT"

gradlePlugin {
    website.set("https://github.com/thewinterframework/properties")
    vcsUrl.set("https://github.com/thewinterframework/properties.git")
    plugins {
        create("propertiesPlugin") {
            id = "io.winter.properties"
            version = "1.0.14"
            displayName = "WinterProperties"
            description = "A Gradle plugin to generate Spigot plugin.yml properties from buildscript."
            implementationClass = "io.winter.properties.PropertiesPlugin"
            tags.set(listOf("spigot", "properties", "yaml"))
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")

    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

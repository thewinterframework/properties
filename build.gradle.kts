plugins {
    id("java")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.1.0"
}

gradlePlugin {
    website.set(findProperty("website").toString())
    vcsUrl.set(findProperty("vcsUrl").toString())
    plugins {
        create(findProperty("plugin.name").toString()) {
            id = findProperty("plugin.id").toString()
            version = findProperty("version").toString()
            displayName = findProperty("plugin.display.name").toString()
            description = findProperty("plugin.description").toString()
            implementationClass = findProperty("plugin.class").toString()
            tags.set(findProperty("plugin.tags").toString().split(", ").toSet())
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")

    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

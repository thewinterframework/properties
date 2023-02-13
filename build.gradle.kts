plugins {
    id("java")
    id("java-gradle-plugin")
}

group = "io.winter"
version = "1.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("propertiesPlugin") {
            id = "io.winter.properties"
            implementationClass = "io.winter.properties.PropertiesPlugin"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")

    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

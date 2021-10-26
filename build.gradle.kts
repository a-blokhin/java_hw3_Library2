plugins {
    java
}

group = "org.example_models"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation ("com.google.code.gson:gson:2.8.5")
    implementation("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    implementation("com.google.inject:guice:4.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
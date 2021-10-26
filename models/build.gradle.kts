plugins {
    java
}

group = "org.example_models"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.intellij:annotations:12.0")
    implementation("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
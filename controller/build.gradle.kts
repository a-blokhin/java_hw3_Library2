plugins {
    java

}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.intellij:annotations:12.0")
    implementation("org.projectlombok:lombok:1.18.20")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation(project(":models"))
    implementation("com.google.inject:guice:4.0")
    testImplementation("org.mockito:mockito-core:2.24.0")
    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-all:1.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}


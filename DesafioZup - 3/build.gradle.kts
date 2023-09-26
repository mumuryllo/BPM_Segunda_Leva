plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.0")

}

tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}
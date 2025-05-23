plugins {
    id("java")
}

group = "ru.smolny"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(gradleApi())
}

tasks.test {
    useJUnitPlatform()
}
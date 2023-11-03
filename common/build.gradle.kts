plugins {
    kotlin("plugin.serialization") version "1.9.0"
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("org.springframework.kafka:spring-kafka:2.8.1")
}

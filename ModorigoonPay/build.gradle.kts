import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.1.3"

    val kotlinVersion = "1.9.0"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.noarg") version kotlinVersion

    application
}

group = "me.modorigoon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.15")
    testImplementation("junit:junit:4.13.2")

    implementation("org.springframework.boot:spring-boot-configuration-processor:2.7.15")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.7.15")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.7.15")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.15")
    implementation("org.springframework.data:spring-data-jpa:2.7.15")
    implementation("javax.persistence:javax.persistence-api:2.2")

    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("io.springfox:springfox-swagger2:2.9.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

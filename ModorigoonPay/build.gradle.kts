import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.1.3"

    val kotlinVersion = "1.9.0"

    kotlin("jvm") version kotlinVersion

    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.jpa") version kotlinVersion apply false
    kotlin("plugin.allopen") version kotlinVersion apply false
    kotlin("plugin.noarg") version kotlinVersion apply false
}

allprojects {
    group = "me.modorigoon"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

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

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

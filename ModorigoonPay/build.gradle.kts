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
    kotlin("plugin.serialization") version kotlinVersion
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
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
    apply(plugin = "org.jetbrains.kotlin.plugin.noarg")

    noArg {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.Embeddable")
        annotation("javax.persistence.MappedSuperclass")
    }

    allOpen {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.Embeddable")
        annotation("javax.persistence.MappedSuperclass")
    }

    dependencies {
        testImplementation(kotlin("test"))
        testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.15")
        testImplementation("junit:junit:4.13.2")

        implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.0")

        implementation("org.springframework.boot:spring-boot-configuration-processor:2.7.15")
        implementation("org.springframework.boot:spring-boot-starter-web:2.7.15")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.15")
        implementation("javax.persistence:javax.persistence-api:2.2")

        implementation("org.springframework.boot:spring-boot-starter-validation:2.7.15")

        implementation("mysql:mysql-connector-java:8.0.33")

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")
        implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.10")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
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

import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

plugins {
    id("com.google.cloud.tools.jib") version "3.4.0"
}

apply(plugin = "com.google.cloud.tools.jib")

jib {
    from {
        image = "adoptopenjdk/openjdk11"
        platforms {
            platform {
                architecture = "arm64"
                os = "linux"
            }
        }
    }
    to {
        image = "${project.name}-${project.version}".toLowerCaseAsciiOnly()
        tags = setOf("latest")
    }
    container {
        ports = listOf("8080")
    }
}


tasks.bootJar {
    enabled = true
}

tasks.jar {
    manifest {

    }
}

dependencies {
    implementation(project(":common"))
    testImplementation("com.h2database:h2:2.2.222")
    implementation("org.springframework.kafka:spring-kafka:2.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}

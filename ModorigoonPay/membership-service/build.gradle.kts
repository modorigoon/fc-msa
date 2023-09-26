tasks.bootJar {
    enabled = true
}

tasks.jar {
    manifest {

    }
}

dependencies {

    implementation(project(":common"))
}

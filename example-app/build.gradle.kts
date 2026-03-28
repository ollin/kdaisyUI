plugins {
    id("kdaisyui.kotlin-library-conventions")
    application
}

application {
    mainClass.set("kdaisyui.example.ApplicationKt")
}

dependencies {
    implementation(project(":lib"))

    val ktorVersion = "3.4.2"
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-html-builder:$ktorVersion")
    implementation("io.ktor:ktor-server-status-pages:$ktorVersion")

    implementation("ch.qos.logback:logback-classic:1.5.18")
}

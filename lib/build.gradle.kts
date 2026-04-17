plugins {
    id("kdaisyui.kotlin-library-conventions")
    `maven-publish`
}

version = project.findProperty("version")?.toString() ?: "0.0.1-SNAPSHOT"
group = "io.github.ollin.kdaisyui"

base.archivesName.set("kdaisyui")

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-html-jvm:${project.property("versions.kotlinx-html")}")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest(project.property("versions.kotlin").toString())
        }
    }
}

val generateComponents = tasks.register<Exec>("generateComponents") {
    group = "codegen"
    description = "Regenerate Kotlin components from DaisyUI source (git submodule)"
    workingDir = rootProject.file("codegen")
    commandLine("sh", "-c", "npm install --silent && node src/index-new.js")
    inputs.dir(rootProject.file("codegen/src"))
    inputs.dir(rootProject.file("daisyui/packages/docs"))
    inputs.file(rootProject.file("codegen/package.json"))
    inputs.file(rootProject.file("codegen/codegen-config.json"))
    outputs.dir(layout.projectDirectory.dir("src/main/kotlin/kdaisyui/components"))
}

tasks.named("compileKotlin") {
    dependsOn(generateComponents)
}

// Sources JAR for Maven Central
val sourcesJar by tasks.registering(Jar::class) {
    dependsOn(tasks.named("generateComponents"))
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

// Javadoc JAR for Maven Central (empty for Kotlin, but required)
val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    dependsOn(tasks.javadoc)
    from(tasks.javadoc.map { it.outputs.files })
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "kdaisyui"
            
            // Attach sources and javadoc JARs
            artifact(sourcesJar.get())
            artifact(javadocJar.get())
            
            // POM metadata required for Maven Central
            pom {
                name.set("kdaisyui")
                description.set("Type-safe DaisyUI component DSL for Kotlin server-rendered HTML")
                url.set("https://github.com/ollin/kdaisyUI")
                
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                
                developers {
                    developer {
                        id.set("ollin")
                        name.set("ollin")
                        email.set("ollin@users.noreply.github.com")
                    }
                }
                
                scm {
                    connection.set("scm:git:git://github.com/ollin/kdaisyUI.git")
                    developerConnection.set("scm:git:ssh://github.com/ollin/kdaisyUI.git")
                    url.set("https://github.com/ollin/kdaisyUI")
                }
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ollin/kdaisyUI")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

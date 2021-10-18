plugins {
    kotlin("multiplatform") version "1.5.31"
    `maven-publish`
    id("org.jetbrains.dokka") version "1.5.0"
}

group = "com.github.nanoflakes"
version = "1.2.2"

repositories {
    mavenCentral()
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js(BOTH) {
        browser {}
    }
    sourceSets {
        val commonMain by getting
        val jvmMain by getting
        val jsMain by getting
    }
}

tasks {
    register<Jar>("dokkaJar") {
        from(dokkaHtml)
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
    }
}

publishing {
    publications.withType<MavenPublication> {
        artifact(tasks["dokkaJar"])
    }
    // select the repositories you want to publish to
    repositories {
        maven {
            url = uri("https://maven.cafeteria.dev/releases")

            credentials {
                username = "${project.property("mcdUsername")}"
                password = "${project.property("mcdPassword")}"
            }
            authentication {
                create("basic", BasicAuthentication::class.java)
            }
        }
        mavenLocal()
    }
}

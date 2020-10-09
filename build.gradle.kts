import com.jfrog.bintray.gradle.BintrayExtension.PackageConfig

plugins {
    kotlin("multiplatform") version "1.4.10"
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.5"
}
apply(plugin = "com.jfrog.bintray")

group = "com.github.nanoflakes"
version = "1.1.1"

repositories {
    mavenCentral()
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

fun findProperty(s: String) = project.findProperty(s) as String?

bintray {
    user = findProperty("bintrayUsername")
    key = findProperty("bintrayApiKey")
    publish = true
    pkg(delegateClosureOf<PackageConfig> {
        repo = "maven"
        name = "nanoflakes-kotlin"
        userOrg = "nanoflakes"
        setLicenses("MIT")
        vcsUrl = "https://github.com/nanoflakes/nanoflakes-kotlin.git"
    })
}
tasks.bintrayUpload {
    doFirst {
        setPublications(*publishing.publications.map { it.name }.toTypedArray())
    }
    dependsOn("build", "publishToMavenLocal")
}

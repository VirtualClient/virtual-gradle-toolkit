plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "gg.virtualclient"
version = "0.1.22-SNAPSHOT"

java.withSourcesJar()

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://maven.fabricmc.net/")
    maven(url = "https://maven.minecraftforge.net")
    maven(url = "https://jitpack.io")
    maven(url = "https://maven.architectury.dev/")
    maven(url = "https://repo.essential.gg/repository/maven-public")
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    api(libs.archloom)
    implementation(libs.archloomPack200)

    compileOnly(libs.kotlin.gradlePlugin)
    implementation(libs.kotlinx.binaryCompatibilityValidator)
    implementation(libs.proguard) {
        exclude(group = "org.jetbrains.kotlin")
    }
    implementation("gradle.plugin.com.github.jengelman.gradle.plugins:shadow:7.0.0")
    api(libs.preprocessor)
    implementation(libs.asm)
    implementation(libs.guava)
    implementation(libs.kotlinx.metadata.jvm)
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
    repositories {
        maven {
            name = "virtualclientRepository"
            credentials(PasswordCredentials::class)
            url = uri("https://repo.virtualclient.gg/artifactory/virtualclient-public/")
        }
    }
}
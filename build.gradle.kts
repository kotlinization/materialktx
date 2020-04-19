plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
    `maven-publish`
}

group = "com.github.kotlinizer"
version = "0.0.1-alpha7"

repositories {
    mavenCentral()
    jcenter()
}

val mwcVersion = "v0.14.1"

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1")
    implementation(npm("source-map-support", "0.5.16"))
    implementation(npm("@material/mwc-button", mwcVersion))
    implementation(npm("@material/mwc-drawer", mwcVersion))
    implementation(npm("@material/mwc-icon-button", mwcVersion))
    implementation(npm("@material/mwc-list", mwcVersion))
    implementation(npm("@material/mwc-top-app-bar", mwcVersion))
}

kotlin.target.browser { }

val jar = tasks.create("jar", org.gradle.jvm.tasks.Jar::class) {
    from("$projectDir/src/main")
}

publishing {
    publications {
        val tmpVersion = version
        create(project.name, MavenPublication::class) {
            pom {
                this.packaging = "jar"
            }
            artifactId = project.name
            version = tmpVersion.toString()
            artifact(jar)
        }
    }
}
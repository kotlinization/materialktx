plugins {
    id("org.jetbrains.kotlin.js")
}

version = "unspecified"

repositories {
    mavenCentral()
}

val mwcVersion = "v0.14.1"
dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.1")
    implementation(npm("source-map-support", "0.5.16"))
    implementation(npm("@material/mwc-button", mwcVersion))
    implementation(npm("@material/mwc-drawer", mwcVersion))
    implementation(npm("@material/mwc-icon-button", mwcVersion))
    implementation(npm("@material/mwc-list", mwcVersion))
    implementation(npm("@material/mwc-top-app-bar", mwcVersion))
}

kotlin.target.browser { }
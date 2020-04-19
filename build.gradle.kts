plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
    `maven-publish`
}

group = "com.github.kotlinizer"
version = "0.0.1-alpha3"

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
    //This npm doesn't really exists, create copy from mwc-list and change main
//    implementation(npm("@material/mwc-list-item", mwcVersion))
    implementation(npm("@material/mwc-top-app-bar", mwcVersion))
}

kotlin.target.browser { }

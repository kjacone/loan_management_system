plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17) // or whatever version you're using
    }
}
dependencies {
    implementation(project(":shared"))

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

}


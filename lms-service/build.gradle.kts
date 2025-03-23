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
val resilience4jVersion = "2.3.0"
dependencies {
    implementation(project(":shared"))

    implementation("io.github.resilience4j:resilience4j-spring-boot3:$resilience4jVersion")
    implementation("io.github.resilience4j:resilience4j-all:$resilience4jVersion") // Optional, only required when you want to use the Decorators class
    implementation("io.github.resilience4j:resilience4j-reactor:$resilience4jVersion")

    implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    runtimeOnly("com.sun.xml.bind:jaxb-impl:4.0.0")
    implementation ("org.apache.httpcomponents:httpclient:4.5.13")

}



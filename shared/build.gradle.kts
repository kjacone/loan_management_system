
plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("java-library")
    kotlin("jvm")
    kotlin("plugin.spring")



}

group = "com.credable.app"
version = "0.0.1-SNAPSHOT"



tasks.jar {
    enabled = true
}

tasks.bootJar{
    enabled = false
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17) // or whatever version you're using
    }
}

dependencies {


    api("com.sun.xml.ws:jaxws-tools:2.3.3")

    implementation("org.apache.cxf:cxf-rt-frontend-jaxws:3.5.5")
    implementation("javax.xml.bind:jaxb-api:2.3.1")

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    // Spring dependencies
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-webflux")
    api("org.springframework.ws:spring-ws-core")

    api("org.springframework.boot:spring-boot-starter-web-services")
    api("wsdl4j:wsdl4j:1.6.3")
    api("org.apache.cxf:cxf-spring-boot-starter-jaxws:4.0.2") {
        exclude(group = "org.apache.cxf", module = "cxf-rt-transports-http")
    }


    // MongoDB
    api("org.springframework.boot:spring-boot-starter-data-mongodb")



    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.4")

    // JSON processing
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // Common utilities
    implementation("org.apache.commons:commons-lang3:3.12.0")

    // Testing
    api("org.springframework.boot:spring-boot-starter-test")
    api("org.springframework.ws:spring-ws-test")
}
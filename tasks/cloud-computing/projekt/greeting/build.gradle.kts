plugins {
    java
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "de.dhbw"
version = "1.0.0"

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

repositories { mavenCentral() }

dependencies { implementation("org.springframework.boot:spring-boot-starter-web") }

tasks.bootJar { archiveFileName.set("app.jar") }
tasks.jar { enabled = false }

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    id("org.springframework.boot") version "2.7.3"
//    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
//    kotlin("plugin.spring") version "1.6.21"
//    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.kotlin-jpa"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.hibernate:hibernate-core:6.0.0.Final")
//    implementation("org.hibernate:hibernate-entitymanager:5.3.6.Final")

    implementation("org.hibernate:hibernate-hikaricp:6.0.0.Final")

    implementation("ch.qos.logback:logback-classic:1.2.11")

    implementation("mysql:mysql-connector-java:8.0.23")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

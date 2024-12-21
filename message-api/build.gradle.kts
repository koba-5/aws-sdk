plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.diffplug.spotless") version "7.0.0.BETA4"
}

group = "message-api"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencyManagement{
	imports{
		mavenBom("io.awspring.cloud:spring-cloud-aws-dependencies:3.0.3")
	}
}

dependencies {
	// Kotlin × Spring boot
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// AWS
	implementation("io.awspring.cloud:spring-cloud-aws-starter-sqs")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

spotless {
	kotlin {
		ktfmt()
	}
}

tasks.compileKotlin{
	dependsOn(tasks.spotlessApply)
}
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"

	kotlin("kapt") version "1.6.21"

	id("com.google.protobuf") version "0.8.15"
}

java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
	group = "com.fone.filmone"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "kotlin")

	repositories {
		mavenCentral()
	}

}

subprojects {
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin-kapt")
	apply(plugin = "org.springframework.boot")

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-webflux")
	}

	dependencyManagement {
		imports {
			mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		enabled = false
		useJUnitPlatform()
	}
}
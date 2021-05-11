plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.32"
    id("org.jetbrains.kotlin.kapt") version "1.4.32"
    id("io.micronaut.library") version "1.5.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.32"
}

version = "0.1"
group = "reproduce.bean.injection"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}
allOpen {
    annotations("javax.inject.Singleton")
}

micronaut {
    runtime("lambda")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("reproduce.bean.injection.*")
    }
}

dependencies {
    kaptTest("io.micronaut:micronaut-inject-java")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.aws:micronaut-function-aws")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut:micronaut-http-client")
    implementation("com.amazonaws:aws-lambda-java-events:3.8.0")

//    testImplementation("io.micronaut.aws:micronaut-function-aws-test")
    testImplementation("io.micronaut.test:micronaut-test-kotest")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.3.0")
    testImplementation( "io.mockk:mockk:1.10.5")
    testImplementation("io.kotest:kotest-assertions-core:4.3.0")
}


java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>{
    kotlinOptions {
        jvmTarget = "11"
    }
}

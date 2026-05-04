plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.poi:poi:5.5.1")
    implementation("org.apache.poi:poi-ooxml:5.5.1")

    implementation("org.apache.logging.log4j:log4j-api:2.25.4")
    implementation("org.apache.logging.log4j:log4j-core:2.25.4")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
    }
}
@file:Suppress("GradlePackageUpdate")

plugins {
  java
  `maven-publish`
}

group = "io.eyesprotocol.validator"
version = "0.0.0"

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

repositories {
  mavenCentral()
}

dependencies {
  // javax.validation api
  implementation("jakarta.validation:jakarta.validation-api:2.0.2")
  implementation("org.bouncycastle:bcprov-jdk15on:1.69")

  // Junit5
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

  // java.validation provider (test)
  testImplementation("org.hibernate:hibernate-validator:6.2.0.Final")
  testImplementation("org.glassfish:jakarta.el:3.0.3")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

publishing {
  repositories {
    maven {
      url = uri("https://jitpack.io")
      credentials {
        username = System.getenv("JITPACK_TOKEN")
      }
    }
  }

  publications {
    create<MavenPublication>("maven") {
      groupId = rootProject.group.toString()
      artifactId = "ethereum-validator"
      version = "0.1.0-SNAPSHOT"

      from(components["java"])

      pom {
        name.set("EYES Protocol Validator - Ethereum")
        description.set("Ethereum validator with JSR380(aka Bean validation)")
        url.set("https://eyesprotocol.io")

        licenses {
          license {
            name.set("GNU Lesser General Public License v3.0")
            url.set("http://www.gnu.org/licenses/")
          }
        }

        scm {
          url.set("https://github.com/eyesprotocol/ethereum-validator")
          connection.set("scm:git:git@github.com:eyesprotocol/ethereum-validator.git")
        }
      }
    }
  }
}

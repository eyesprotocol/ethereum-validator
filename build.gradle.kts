@file:Suppress("GradlePackageUpdate")

plugins {
  java
  jacoco
  `maven-publish`
}

group = "io.eyesprotocol.validator"
version = "0.1.0"

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

tasks.jacocoTestReport {
  reports {
    html.required.set(false)
    xml.required.set(false)
    csv.required.set(true)
  }
}

java {
  withJavadocJar()
  withSourcesJar()
}

publishing {
  publications {
    repositories {
      maven {
        name = "OSSRH"

        val releasesRepoUrl = "https://s01.oss.sonatype.org/content/repositories/releases/"
        val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
        url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

        credentials {
          username = System.getenv("MAVEN_USERNAME")
          password = System.getenv("MAVEN_PASSWORD")
        }
      }

      maven {
        name = "MavenCentral"

        url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
        credentials {
          username = System.getenv("MAVEN_USERNAME")
          password = System.getenv("MAVEN_PASSWORD")
        }
      }
    }

    create<MavenPublication>("maven") {
      groupId = rootProject.group.toString()
      artifactId = rootProject.name
      version = rootProject.version.toString()

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

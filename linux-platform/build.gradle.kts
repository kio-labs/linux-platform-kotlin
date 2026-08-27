plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.maven.publish)
}

kotlin {
    linuxX64 {
        compilations.getByName("main") {
            cinterops {
                val linuxApi by creating {
                    defFile("src/nativeInterop/cinterop/linux-platform.def")
                }
            }
        }
    }
}

mavenPublishing {
    signAllPublications()
    publishToMavenCentral()

    pom {
        name.set("linux-platform-kotlin")
        description.set("Kotlin Native linux api")
        url.set("https://github.com/kio-labs/linux-platform-kotlin")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("andannn")
                name.set("Andannn")
            }
        }

        scm {
            url.set("https://github.com/kio-labs/linux-platform-kotlin.git")
            connection.set("scm:git:git://github.com/kio-labs/linux-platform-kotlin.git")
            developerConnection.set("scm:git:ssh://git@github.com/kio-labs/linux-platform-kotlin.git")
        }
    }
}
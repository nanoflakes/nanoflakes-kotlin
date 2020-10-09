# Nanoflakes - Kotlin

Reference implementation of [nanoflakes](https://github.com/nanoflakes/nanoflakes) for Kotlin.

Licensed under the [MIT License](https://github.com/nanoflakes/nanoflakes-java/blob/master/LICENSE).

### Installation

![Latest Version](https://api.bintray.com/packages/nanoflakes/maven/nanoflakes-kotlin/images/download.svg)

Using in Gradle:

```gradle
repositories {
  maven { url "https://dl.bintray.com/nanoflakes/maven"  }
}

dependencies {
  // replace FLAVOR with either "js" or "jvm", replace LATEST with the version above
  compile 'com.github.nanoflakes:nanoflakes-kotlin-FLAVOR:LATEST'
}
```

Using in Maven:

```xml
<repositories>
  <repository>
    <id>central</id>
    <name>bintray</name>
    <url>http://jcenter.bintray.com</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.nanoflakes</groupId>
    <artifactId>nanoflakes-kotlin-FLAVOR</artifactId> <!-- replace FLAVOR with either "js" or "jvm" -->
    <version>LATEST</version> <!-- replace LATEST with the version above -->
  </dependency>
</dependencies>
```

### Usage

- The `Ǹanoflakes` class contains utility methods for handling with nanoflakes.
- Use `Nanoflakes.localGenerator(epoch, generatorId)` to create a local nanoflake generator.
    - You can get an epoch by calling `System.currentTimeMillis()` in a Java shell (`jjs`, `jshell`, etc).
    - A generator ID must be in the 0-1023 range.
- Use `NanoflakeGenerator.next()` to get a new nanoflake.
- The `Nanoflake` class is the result type `NanoflakeGenerator.next()`. It can be used as-is, or getting it's raw or encoded value. It also features utility methods such as getting the creation time of the nanoflake.

### Support

Extra support is given on [Aru's Discord Server](https://discord.gg/URPghxg).

[![Aru's Discord Server](https://discordapp.com/api/guilds/403934661627215882/embed.png?style=banner2)](https://discord.gg/URPghxg)

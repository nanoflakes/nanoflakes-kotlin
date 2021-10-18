# Nanoflakes - Kotlin

[![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmaven.cafeteria.dev%2Freleases%2Fcom%2Fgithub%2Fnanoflakes%2Fnanoflakes-kotlin%2Fmaven-metadata.xml)](https://maven.cafeteria.dev/releases/com/github/nanoflakes/nanoflakes-kotlin)
[![GitHub issues](https://img.shields.io/github/issues/nanoflakes/nanoflakes-kotlin)](https://github.com/nanoflakes/nanoflakes-kotlin/issues)
[![License](https://img.shields.io/github/license/nanoflakes/nanoflakes-kotlin)](https://github.com/nanoflakes/nanoflakes-kotlin/tree/master/LICENSE)
[![Twitter](https://img.shields.io/twitter/url?style=social&url=https%3A%2F%2Fgithub.com%2Fnanoflakes%2Fnanoflakes-kotlin)](https://twitter.com/intent/tweet?text=Wow:&url=https%3A%2F%2Fgithub.com%2Fnanoflakes%2Fnanoflakes-kotlin)

Reference implementation of [nanoflakes](https://github.com/nanoflakes/nanoflakes) for Kotlin.

Licensed under the [MIT License](https://github.com/nanoflakes/nanoflakes-kotlin/blob/master/LICENSE).

### Installation

Using in Gradle:

```gradle
repositories {
  maven { url = 'https://maven.cafeteria.dev' }
}

dependencies {
  implementation 'com.github.nanoflakes:nanoflakes-kotlin:VERSION'
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
    <artifactId>nanoflakes-kotlin</artifactId>
    <version>VERSION</version>
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

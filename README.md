# Greek TIN/AFM Validator and Generator

[![Linux Build Status](https://img.shields.io/travis/clytras/afm-java.svg?style=flat)](https://travis-ci.org/clytras/afm-java?branch=master) [![Maven Central](https://img.shields.io/maven-central/v/io.lytrax/lytrax-afm)](https://search.maven.org/artifact/io.lytrax/lytrax-afm)


![Logo](https://github.com/clytras/afm-java/raw/master/resources/LytraxAFM_logo.png)

Validate and generate Greek TIN (*Tax Identification Number*) / AFM (*Αριθμός Φορολογικού Μητρώου*). Generation function can create valid or invalid numbers including parameters for old format, individuals, legal entities and repet tolerance digits control.

## Online demo and presentation

https://lytrax.io/blog/projects/greek-tin-validator-generator

## Installation

Get [Maven](https://search.maven.org/artifact/io.lytrax/lytrax-afm) artifacts using Gradle (`build.gradle`):

```gradle
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.lytrax:lytrax-afm:1.0.1'
}
```

Or go to [project releases](https://github.com/clytras/afm-java/releases), download and use the latest jar package.

## Usage

Import functions:

```java
import io.lytrax.afm.ValidateAFM;
import io.lytrax.afm.GenerateAFM;
```

Validate a number:

```java
ValidateAFM.Validate("090000045");
< true

ValidateAFM.Validate("123456789");
< false
```

Generate a valid number:

```java
GenerateAFM generator = new GenerateAFM();

generator.reset().generateValid();
< "731385437"
```

Validate using `ValidateAFMExtendedResult`:

```java
import io.lytrax.afm.ValidateAFM.ValidateAFMExtendedResult;

ValidateAFMExtendedResult result = ValidateAFM.ValidateExtended("ab1234");

result.toString();
< "ValidateAFMExtendedResult { Error()=\"length\", Valid()=false }"
```

Generate an invalid number:

```java
GenerateAFM generator = new GenerateAFM();

generator.reset().generateValid();
< "853003357"
```

Generate a valid number using function parameters:

```java
GenerateAFM generator = new GenerateAFM();

generator
    .reset()
    .forceFirstDigit(3)
    .repeatTolerance(1)
    .valid(true)
    .generate();
< "335151580"

generator
    .reset()
    .pre99(true)
    .generateValid();
< "070825250"

generator
    .reset()
    .legalEntity(true)
    .generateInvalid();
< "877577341"
```

**CAUTION**: Always use `reset()` before each number generation when changing parameters and reusing an object of the same instance, because every parameter is saved to private variables for repeated usage.


## API

[JavaDoc API Github page](https://clytras.github.io/afm-java/)

## Test

Clone this repository and then use an IDE like [Netbeans](https://netbeans.org/) to run tests or use [Apache Ant™](https://ant.apache.org/):

```
git clone https://github.com/clytras/afm-java.git && cd afm-java
ant -f Src/LytraxAFM test
```

## Changelog

See [CHANGELOG](https://github.com/clytras/afm-java/blob/master/CHANGELOG.md)


## License

MIT License - see the [LICENSE](https://github.com/clytras/afm-java/blob/master/LICENSE) file for details

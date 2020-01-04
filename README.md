# Greek TIN/AFM Validator and Generator

[![Linux Build Status](https://img.shields.io/travis/clytras/afm-java.svg?style=flat)](https://travis-ci.org/clytras/afm-java.svg?branch=master)

![Logo](https://github.com/clytras/afm-java/raw/master/resources/LytraxAFM_logo.png)

Validate and generate Greek TIN (*Tax Identification Number*) / AFM (*Αριθμός Φορολογικού Μητρώου*). Generation function can create valid or invalid numbers including parameters for old format, individuals, legal entities and repet tolerance digits control.

## Online demo and presentation

https://lytrax.io/blog/projects/greek-tin-validator-generator

## Installation


## Usage

Import functions:

```java
import io.lytrax.afm.ValidateAFM;
import io.lytrax.afm.GenerateAFM;
```

Validate a number:

```java
```

Generate a valid number:

```java
```

Generate an invalid number:

```java
```

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

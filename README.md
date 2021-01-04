# MissPuzzle

Simple runner and organizer for coding puzzles.

## Feature
Write your puzzle and use Junit to test.

## Dependency
Maven 3+
Junit 4+

## Usage
Build the project:
```
mvn clean package
```

To run a single test (replace testname with your class name. Wildcard is ok, e.g. Q6*):
```
mvn -Dtestname test
```

To run multiple tests method:
```
mvn -Dtestname1,testname2 test
```

To run a single method:
```
mvn -Dtestname#method test
```

To run multiple methods:
```
mvn -Dtestname#method1+method2 test
```
AngularGWT: Write Angular Controllers, Filters, Directives in GWT.
===

Usage
---
angulargwt is available in [maven central](http://search.maven.org/#artifactdetails%7Cru.finam%7Cangulargwt%7C1.0%7Cjar)

Just include it in your pom.xml
```xml
<dependency>
    <groupId>ru.finam</groupId>
    <artifactId>angulargwt</artifactId>
    <version>1.0</version>
</dependency>
```
or gradle build:
```groovy
dependencies {
    compile 'ru.finam:angulargwt:1.0'
}
```

or ivy:
```xml
<dependency org="ru.finam" name="angulargwt" rev="1.0" />
```

Add dependency in your gwt module descriptor (*.gwt.xml)
and turn gwt logging on:
```xml
<inherits name="com.google.gwt.angular.angulargwt"/>
```

Look at TodoMVC app to learn how to angulargwt in your project.

WARNING: Recommended that you use SuperDevMode develop, completely untested in DevMode. Uses lots of compiler casting 
magic to reduce code size, but is likely to break when running inside a JVM.

Currently undone: 

* More JavaDoc.
* Unit tests.
* Transitive dependencies, modules that depend on modules.
* JSO wrappers for the rest of the AngularJs API. I only implemented that which was needed for TodoMVC.


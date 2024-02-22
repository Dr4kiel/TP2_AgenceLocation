
## Outils

Pour les outils, j'ai utilisé :
- Java 17
- Gradle (7.6.4)
- JUnit 5
- AssertJ (3.6.1)
- Jacoco (0.8.11)

## Créer un projet Java avec Gradle

Pour créer un projet Java avec gradle, il suffit d'entrer la commande :
```sh
gradle init
```

## Importer les librairies

Pour importer les différentes librairies, il faut ajouter dans le `build.gradle` les dépendances et plugins nécessaires :

```gradle
plugins {  
    id 'java'  
    id 'jacoco'  
}  
  
group = 'fr.tristang'  
version = '1.0-SNAPSHOT'  
  
repositories {  
    mavenCentral()  
}  
  
dependencies {  
    testImplementation platform('org.junit:junit-bom:5.9.1')  
    testImplementation 'org.junit.jupiter:junit-jupiter'  
  
    testImplementation group: 'org.assertj', name: 'assertj-core', version: '3.6.1'  
  
    // Mockito  
    testImplementation 'org.mockito:mockito-core:4.+'  
    testImplementation 'org.mockito:mockito-junit-jupiter:4.+'  
}  
  
tasks.named('test', Test) {  
    useJUnitPlatform()  
}  
  
test {  
    finalizedBy jacocoTestReport // report is always generated after tests run  
}  
  
jacoco {  
    toolVersion = "0.8.11"  
    reportsDirectory = layout.buildDirectory.dir('reports/jacoco')  
}  
  
jacocoTestReport {  
    reports {  
        xml.required = true  
        csv.required = false  
        html.outputLocation = layout.buildDirectory.dir('JacocoReport')  
    }}  
  
tasks.register('util', Test) {  
    // Use JUnit Platform for integration tests.  
    useJUnitPlatform {  
        includeTags "util"  
    }  
    finalizedBy(jacocoTestReport)  
}  
  
tasks.register('agency', Test) {  
    // Use JUnit Platform for integration tests.  
    useJUnitPlatform {  
        includeTags "agency"  
    }  
    finalizedBy(jacocoTestReport)  
}
```

## Lancer les tests avec Gradle

Pour lancer les différents tests, il faut entrer les commandes suivantes :

- Pour lancer les tests du package `agency` :
```sh
gradle agency
```
- Pour lancer les tests du package `utils` :
```sh
gradle utils
```
- Pour lancer tous les tests :
```sh
gradle test
```
- Pour générer les rapports de tests :
```sh
gradle JacocoTestReport
```
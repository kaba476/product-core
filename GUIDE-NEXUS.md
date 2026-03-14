# Guide de publication dans Nexus - product-core

## Prérequis

- Java 17
- Maven installé
- Accès au serveur Nexus

## Étape 1 : Configurer les identifiants Maven

Créer ou modifier le fichier `~/.m2/settings.xml` (sur Windows : `C:\Users\<ton-user>\.m2\settings.xml`) :

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">

    <servers>
        <server>
            <id>nexus-releases</id>
            <username>Admin</username>
            <password>Devops12EX</password>
        </server>
        <server>
            <id>nexus-snapshots</id>
            <username>Admin</username>
            <password>Devops12EX</password>
        </server>
    </servers>

</settings>
```

Les `<id>` doivent correspondre exactement à ceux du `pom.xml`.

## Étape 2 : Vérifier le pom.xml

Le bloc `<distributionManagement>` dans le `pom.xml` doit pointer vers ton Nexus :

```xml
<distributionManagement>
    <repository>
        <id>nexus-releases</id>
        <url>https://picaresque-dilatometrically-demetria.ngrok-free.dev/repository/maven-releases/</url>
    </repository>
    <snapshotRepository>
        <id>nexus-snapshots</id>
        <url>https://picaresque-dilatometrically-demetria.ngrok-free.dev/repository/maven-snapshots/</url>
    </snapshotRepository>
</distributionManagement>
```

Si tu utilises un Nexus local, remplace l'URL par `http://localhost:8081/repository/maven-releases/` et `http://localhost:8081/repository/maven-snapshots/`.

## Étape 3 : Publier les 5 versions

Ouvrir un terminal dans le dossier `product-core` et exécuter les commandes suivantes dans l'ordre.

### Version 1 — Ajout de produit (SNAPSHOT)

```bash
mvn versions:set "-DnewVersion=1.0-SNAPSHOT"
mvn clean deploy -DskipTests
```

### Version 2 — Liste des produits (SNAPSHOT)

```bash
mvn versions:set "-DnewVersion=2.0-SNAPSHOT"
mvn clean deploy -DskipTests
```

### Version 3 — Modification du stock (SNAPSHOT)

```bash
mvn versions:set "-DnewVersion=3.0-SNAPSHOT"
mvn clean deploy -DskipTests
```

### Version 4 — Calcul du stock faible (SNAPSHOT)

```bash
mvn versions:set "-DnewVersion=4.0-SNAPSHOT"
mvn clean deploy -DskipTests
```

### Version finale stable (RELEASE)

```bash
mvn versions:set "-DnewVersion=1.0.0"
mvn clean deploy -DskipTests
```

**Important (PowerShell)** : Les guillemets autour de `-DnewVersion=...` sont obligatoires sinon PowerShell coupe la valeur au tiret.

## Étape 4 : Vérifier dans Nexus

1. Ouvrir le navigateur sur l'URL Nexus
2. Aller dans **Browse** > **maven-snapshots** pour voir les versions SNAPSHOT
3. Aller dans **Browse** > **maven-releases** pour voir la version 1.0.0

Les artefacts publiés :

| Version | Type | Repository |
|---|---|---|
| 1.0-SNAPSHOT | Développement | maven-snapshots |
| 2.0-SNAPSHOT | Développement | maven-snapshots |
| 3.0-SNAPSHOT | Développement | maven-snapshots |
| 4.0-SNAPSHOT | Développement | maven-snapshots |
| 1.0.0 | Release finale | maven-releases |

## Résolution de problèmes

| Erreur | Solution |
|---|---|
| `401 Unauthorized` | Vérifier username/password dans `settings.xml` |
| `Connection refused` | Vérifier que Nexus est démarré |
| `502 Bad Gateway` | Le serveur Nexus est en redémarrage, réessayer |
| `Unknown lifecycle phase .0-SNAPSHOT` | Ajouter les guillemets autour de `-DnewVersion=...` |

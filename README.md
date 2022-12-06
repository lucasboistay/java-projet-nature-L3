# java-projet-nature-L3
## Résumé :
Un projet en java pour gérer les classes, les héritages, les exceptions et les interfaces sur le thème de la nature.
Version de développement.

## Fichiers :
/src contient toutes les classes du projet.
/classes contient les classes initiales de l'énoncé.

## Installation : 

### Ouvrir le terminal et copier :

```sh
git clone https://github.com/Rockinfox91/java-projet-nature-L3.git
cd java-projet-nature-L3/
```

### Puis, lancer les commande :
```sh
javac -cp classes -d bin src/*.java
java -cp bin TestSimulation
```

## Arguments
### Les options possibles sont :
```sh
-i [int]
```
Pour gérer le nombre d'itération

```sh
-log
```
Pour afficher les logs à chaque itération

## JavaDoc

Pour avoir une doc java client, entrez :
```sh
javadoc -cp src -d doc src/*.java
```
et pour une doc java fournisseur : 
```sh
javadoc -cp src -private -d privatedoc src/*.java
``` 

## Améliorations possibles :

- Affichage graphique plus intéressant
- Faire plusieurs fourmilières
- Faire de nouvelles ressources

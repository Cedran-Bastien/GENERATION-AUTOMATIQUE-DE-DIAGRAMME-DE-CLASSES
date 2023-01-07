# Groupe 4 (C-D)

Votre README ne contient pas les noms du groupe.
- BASTIEN
- AKOO OBONO
- AUBURTIN


# Contenu itération V3

## Contenu du dépot  (B)

certain repertoires avec ou sans majuscules.
(ex iteration 3)

## Trello (D)

Trello mis àjour sprint 2

Sprint 3 pas de mise à jour 
- tout est dans a faire
- il n'y a pas de enCours
- il n'y a pas d'affectation aux membres du groupe
On ne sait pas du tout où vous en êtes.

Mais ++ => ok pour les checklist

Vous devez lire le document utilisation de trello.

## Liste fonctionnalites (F)

Pas de liste de fonctionnalité pour la v3
Il faut
- une liste de fonctionnalités
- une affectation dans le groupe
- un diagramme de séquence et des tests pour chaque fonctionnalité

Pas de liste non plus en v2 !!!

##  Conception
### diag classes 

Vos diagrammes de classe doivent aussi être sauvés en png.

Il faut deux diagrammes de classe
- un diagramme en début d'iteration fait manuellement
- un diagramme en fin d'iteration fait par intellij

L'objectif est de comparer ces deux diagrammes pour voir si votre conception est restée stable ou si elle a évoluée lors du développement de l'itération.

++ => Votre diagramme me parait clair et bien structuré
Vous pouvez aussi mettre des couleurs (ou copiercoller dans des diagrammes séparés) soit pour 
- faire ressortir un patron de conception particulier
- faire ressortir les nouveautés de l'itération en cours 

### diag sequence (C)

- creationinstance
  - vos diagrammes doivent avoir un titre
  - ils doivent aussi avoir un petit descriptif pour qu'on sache de quoi cela traite (en lien avec une fonctionnalité)
  - Ici je ne suis pas sur de tout comprendre
  - dans votre diagramme, un probleme pourrait se poser quand une classe est utilisée deux fois : en 17, vous créez un nouvel objet qui représente une classe mais si la classe existe déjà ailleurs, vous le créez deux fois.. Est ce le cas ?
  - ce diagramme pourrait être amélioré mais il a permis de poser cette question, ce qui le valide en partie (et montre son interet)

- Sequ_generation_diagramme
  - diagramme inutile
  - ne devrait pas etre dans le depot

- vueInstance
  - le diagramme vueInstance est interessant
  - mais il est difficle de savoir ce qu'il présente (titre + descriptif)
  - en particulier, je pense que la chose importante à présenter et votre adaptation de MVC (si c'est de cela qu'il s'agit) et cela ne me semble pas tres clair car votre diagramme devrait avoir un contexte plus grand.

## Démonstration  (B-C)

Ok ,vous semblez proposer un point de départ pour les démos dans le README.
- peut etre ajouter ce que la démo fait.

## Sources (D)

- javadoc souvent présente (mais pas dans les vues)
- manque de commentaires internes

- je vous conseille fortement pour les méthodes complexes de rédiger les commentaires avant le code, c'est a dire
  - de mettre des commentaires qui structurent les étapes de votre méthode
  - de faire ensuite le code
- cela permet
  - de structurer votre code
  - de le rendre lisible et de faire ressortir les étapes de votre code
  - de réduire vos erreurs
  - de montrer que vous avez pensé votre code et que vous n'avez pas simplement codé au fur et à mesure des besoins (par essai-erreur).
  - d'avoir des commentaires pertinents

## Tests (D)

plutot qu'utiliser des toString, passez par des gets
vos tests devraient être liés à vos fonctionnalités sinon, vous risquez de faire de nombreux tests inutiles et d'en oublier d'autres.

## Bilan (F)

pas de bilan ni V2 ni v3


----------------


# Contenu itération V1

## Contenu du dépot (A)

- ok pour la structure de votre dépot.
- les documents sont bien organisés par version.
- votre gitignore semble complet

## Liste fonctionnalites (F)

- pas de liste des fonctionnalités détaillées dans votre dossier de conception
- il faudrait les faire apparaitre et préciser si elles sont validées ou non (meme si cela apparait sur le trello)

## Conception

### diag classes (C)

- difficile de se faire une idée du diagramme puisque les fonctionnalités ne sont pas explicites (meme si elles apparaissent sur le trello)
- votre diagramme de classe me semble un peu bizarre. Pourquoi composante hérite de Instance
- attention, vous confondez héritage (--|>) et implements (..|>). Dans votre cas, les relations entre Classe et Instance sont des relation d'héritage.

### diag sequence (C)

- il manque les images de vos diagrammes de séquence dans le dépot. Il faut les ajouter pour ne pas avoir besoin de regénérer les images pour lire vos diagrammes. 
- dans ajouterClasse, on ne sait pas trop comment les propriétés sont stockées. mais ok
- ok pour Sequ_Constructeur_modele
- dans Sequ_CreationRelation, l'objet c n'est jamais utilisé, l'ajout de la relation n'est pas trés clair (this.rel.addRelation). Les relations sont toutes stockées dans le modèle ? On ne sait pas trop ce que fait cette fonctionnalités

Il faut impérativement lier vos diagrammes de séquences à vos fonctionnalités
- cela permet de comprendre l'objectif de la fonctionnalité
- cela permet de vérifier si ce que vous dessinez et correct ou non
Par exemple, je ne sais pas ce que doit faire "Sequ_CreationRelation" => S'agit-il d'ajouter une relation ou une aute classe au modèle ?

Vos diagrammes sont intéressants mais ils ne sont pas complétement compréhensible sans un texte qui les accompagne (par exemple l'explication de la fonctionnalité à laquelle ils sont rattachés)

## Code source (D)

- votre code n'est pas complétement commenté.

## Lancement de la démo (F)

- je ne sais pas s'il est possible de lancer une démonstration de la v1
- il faut ajouter la classe à lancer dans le readme.

Normalement, chaque itération doit conduire à une démonstration (une application viable)

## Tests (F)

- certains tests sont étranges. Par exemple, la plupart des tests comme TestAssociation ne testent rien.

Vous devez 
(1) ne faire les tests que si la fontionnalité est à faire (il est inutile de préparer des tests qui serviront peut etre plus tard - concentrez vous sur le présent de l'application)
(2) lier vos tests à vos fonctionnalités, sinon vous risquez de ne pas tester ce que vous souhaitez faire mais vous allez tester tout sans savoir ce qu'il est important de tester et de vérifier.

Les tests devraient être liés aux fonctionnalités.

## Trello (C)

Ok, le trello est bien mis à jour.
- Par contre, c'est étrange que les choses censées être faites sont codées en "enCours" (cf icone bleue)
- De plus, dans la seconde fonctionnalité, vous parlez de visibilité. Pourquoi ? cette fonctionnalité est-elle implémentée ?
  - si oui, elle devrait être testée
  - si non, cela ne devrait pas apparaitre ici.

## Bilan de l'itération (F)

Il manque un bilan de l'itération, on ne sait pas ce qui fonctionne et ce qui n'est pas réalisé.


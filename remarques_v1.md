# Groupe 4 (C-D)

Votre README ne contient pas les noms du groupe.
- BASTIEN
- AKOO OBONO
- AUBURTIN

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


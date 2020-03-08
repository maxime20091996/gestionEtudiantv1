# gestionetudiant

<b>0- Installation</b>

a- TomcatServer 9.0 | Utilisation de Java v.8.x - 

b- Créer une base mysql à l'aide de wamp qui se nomera `gestionetudiant` et importer le fichier gestionetudiant.sql 
permettant d'avoir des données exemples et de connection.

<b>0bis- Récupération du war</b>

Au niveau de votre disque C, ouvirir une console cmd et ecrire:
`mkdir c:\GTMGestionEtudiant`

`cd c:\GTMGestionEtudiant`

`mvn scm:checkout  -DconnectionUrl=scm:git:https://github.com/BenKapoor/GestionEtudiant`

Aller dans `target\checkout\GestionEtudiant`

Exécuter la commande :
`mvn install`

Aller dans le dossier `target` et récupérer le war génréré.

<b>1- Deplacer le fichier DemoFormation.war dans le dossier `webapps` de Tomcat </b>

<b>2- Executer startup.bat situé dans le dossier `bin` de tomcat </b>

<b>3- Dans l'url du navigateur internet, entrer la commande suivante : http://localhost:8080/GestionEtudiant/ </b>

<b>Fonctionnalités présentes : </b>
- Ajouter un thème à la formation

<b>Technologies : </b>
- servlet
- HTML
- JSP
- Bootstrap
- JPA

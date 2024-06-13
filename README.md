
# Getting Started


## Aperçu
Cette application Java  simule un aventurier naviguant à travers une grille basée sur une carte. L'aventurier se déplace en suivant des instructions fournies dans un fichier en entrée, tout en évitant les obstacles définis sur la carte par # il peut se naviguer seulement sur les caractère " ".


## Structure du Projet
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── ahmed/
│ │ │ └── aventurier/
│ │ │ ├── App.java
│ │ │ ├── exceptions/
│ │ │ │ └── AlreadyInWoodsException.java
│ │ │ ├── reader/
│ │ │ │ ├── CardReader.java
│ │ │ │ └── InputReader.java
│ │ │ ├── solver/
│ │ │ │ └── AventurierSolver.java
│ │ │ ├── model/
│ │ │ ├── Card.java
│ │ │ └── Aventurier.java
│ └── test/
│  ├── java/
│  │ └── com/
│  │ └── ahmed/
│  │ └── aventurier/
│  │ ├── AppTest.java
│  │ ├── reader/
│  │ │ ├── CardReaderTest.java
│  │ │ └── InputReaderTest.java
│  │ ├── solver/
│  │ └── AventurierSolverTest.java
└── pom.xml


## Prerequis
- Java 8 or later
- Maven

## Building the Project
To build the project, navigate to the project root directory and run:

- mvn clean install

## Exécution de l'Application
- Après avoir construit le projet, vous pouvez exécuter l'application en utilisant la commande suivante :
- java -jar target/AdventureGame-1.jar
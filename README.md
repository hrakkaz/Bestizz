# Bestizz - Application de Quiz Android 🎯📱

**Auteures** : Elsa Letellier & Hafsa Rakkaz  
**Formation** : ESGI – Cours "Introduction au développement Android"  
**Encadrant** : Nathaniel Vaur Henel

---

## 📌 Présentation

**Bestizz** est une application Android de quiz développée dans le cadre du cours de développement mobile. Le but est de proposer une expérience ludique, interactive et multilingue autour de 5 questions à choix multiples. L'utilisateur renseigne son prénom, répond aux questions, et reçoit un score ainsi qu’un message personnalisé selon sa performance.

L’application inclut également des illustrations et une bande sonore pour rendre l'expérience plus immersive. Elle est disponible en **français** et **anglais**.

---

## 🎮 Fonctionnalités

- Écran d’accueil avec saisie du prénom
- Quiz de 5 questions à choix multiples
- Calcul automatique du score
- Écran de résultat avec image, score et message personnalisé
- Navigation fluide entre les écrans
- Prise en charge du **multilingue (FR/EN)**
- **Illustrations** dynamiques selon le score
- **Musique de fond**
- Sauvegarde du prénom avec `SharedPreferences`
- Relancer ou recommencer une partie

---

## ⚙️ Prérequis

- Android Studio Arctic Fox ou supérieur
- JDK 8 ou plus récent
- SDK Android API 24 minimum (Android 7.0)

---

## 🧰 Technologies utilisées

- **Langage** : Java
- **Environnement** : Android Studio
- **UI** : XML avec ViewBinding
- **Stockage local** : SharedPreferences
- **Audio** : MediaPlayer
- **Ressources** : fichiers XML (`strings.xml`, `colors.xml`, images `drawable/`, sons `raw/`)

---

## 📦 Structure des fichiers

```text
├── java/
│   └── com.example.bestizz/
│       ├── MainActivity.java     # Écran d’accueil
│       ├── Quizz.java            # Écran du quiz
│       └── Result.java           # Écran de résultats
├── res/
│   ├── layout/           # Fichiers XML des écrans
│   ├── values/           # Strings fr
│   ├── values-en/        # Strings en
│   ├── drawable/         # Illustrations selon le score
│   └── raw/              # Musique de fond

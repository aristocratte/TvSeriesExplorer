## Auteur

- GIL Mathis
- CORDONNIER Aristide

## Fonctionnalités

- Affichage des séries TV populaires
- Recherche de séries par titre
- Consultation des détails d'une série (résumé, rating, nombre d'épisodes, etc.)
- Gestion des états de chargement et d'erreur
- 
### Structure

```
app/
├── data/
│   ├── api/           # Services API (Retrofit)
│   ├── model/         # Modèles de données
│   └── repository/    # Couche d'accès aux données
├── di/                # Injection de dépendances (Hilt)
├── ui/
│   ├── screens/       # Écrans de l'application
│   ├── components/    # Composants réutilisables
│   └── theme/         # Thème de l'application
├── viewmodel/         # ViewModels (logique métier)
└── navigation/        # Navigation Compose
```

### Composants principaux

- **Model** : Représente les données de l'application (séries TV, détails, etc.)
- **View** : Interface utilisateur développée avec Jetpack Compose
- **ViewModel** : Gère la logique métier et expose les données à l'interface

## API utilisée

L'application utilise l'API publique **Episodate** pour récupérer les données sur les séries TV.

**Base URL** : `https://www.episodate.com/api/`

### Endpoints principaux

- `GET /most-popular?page={page}` : Récupère la liste des séries populaires
- `GET /show-details?q={id}` : Obtient les détails d'une série spécifique
- `GET /search?q={query}` : Recherche des séries par titre

## Technologies et bibliothèques

### Développement

- **Kotlin** : Langage de programmation
- **Jetpack Compose** : Framework UI déclaratif
- **Material 3** : Design system

### Architecture et patterns

- **MVVM** : Architecture pattern
- **Hilt** : Injection de dépendances
- **StateFlow** : Gestion d'état réactif

### Réseau et données

- **Retrofit** : Client HTTP pour les appels API
- **Gson** : Sérialisation/désérialisation JSON
- **Coil** : Chargement et mise en cache d'images

### Navigation

- **Navigation Compose** : Gestion de la navigation entre écrans

## Dépendances principales

```kotlin
// Navigation
androidx.navigation:navigation-compose:2.8.5

// Hilt
com.google.dagger:hilt-android:2.52
androidx.hilt:hilt-navigation-compose:1.2.0

// Lifecycle
androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7
androidx.lifecycle:lifecycle-runtime-ktx:2.8.7

// Retrofit
com.squareup.retrofit2:retrofit:2.11.0
com.squareup.retrofit2:converter-gson:2.11.0

// Coil
io.coil-kt:coil-compose:2.7.0
```



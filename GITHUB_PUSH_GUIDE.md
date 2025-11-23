# 📤 Guide pour Pousser sur GitHub

## Repository GitHub
**URL**: https://github.com/aristocratte/TvSeriesExplorer  
**Branche**: main

---

## 🚀 Option 1 : Script Automatisé (RECOMMANDÉ)

### Étapes :

1. **Ouvrir le Terminal**
   ```bash
   cd /Users/mathis/AndroidStudioProjects/AppTV
   ```

2. **Rendre le script exécutable**
   ```bash
   chmod +x push_to_github.sh
   ```

3. **Lancer le script**
   ```bash
   ./push_to_github.sh
   ```

4. **Suivre les instructions**
   - Le script vous demandera un message de commit (optionnel)
   - Il poussera automatiquement sur la branche main

---

## 🔧 Option 2 : Commandes Manuelles

### Si Git n'est pas encore initialisé :

```bash
# Se placer dans le dossier du projet
cd /Users/mathis/AndroidStudioProjects/AppTV

# Initialiser Git
git init

# Configurer la branche main
git branch -M main

# Ajouter tous les fichiers
git add .

# Créer le commit
git commit -m "🚀 Initial commit - TV Series Explorer App

- Application Android en Jetpack Compose
- Architecture MVVM avec Hilt
- Intégration API Episodate
- Navigation Compose
- Gestion des états UI

Fonctionnalités:
✅ Page d'accueil avec séries populaires
✅ Recherche de séries
✅ Détails des séries
✅ Navigation fluide"

# Ajouter le remote GitHub
git remote add origin https://github.com/aristocratte/TvSeriesExplorer.git

# Pousser vers GitHub
git push -u origin main
```

### Si Git est déjà initialisé :

```bash
# Se placer dans le dossier du projet
cd /Users/mathis/AndroidStudioProjects/AppTV

# Ajouter les fichiers modifiés
git add .

# Créer le commit
git commit -m "Update: [votre message]"

# Pousser vers GitHub
git push origin main
```

---

## 🔑 Authentification GitHub

### Si c'est la première fois, vous devrez vous authentifier :

#### Option 1 : Personal Access Token (Recommandé)

1. Aller sur GitHub : https://github.com/settings/tokens
2. Cliquer sur "Generate new token" → "Classic"
3. Cocher les permissions :
   - `repo` (tous)
   - `workflow`
4. Copier le token généré
5. Lors du push, utiliser :
   - **Username** : aristocratte
   - **Password** : [votre token]

#### Option 2 : SSH

1. Générer une clé SSH :
   ```bash
   ssh-keygen -t ed25519 -C "votre@email.com"
   ```

2. Ajouter la clé à GitHub :
   - Copier la clé : `cat ~/.ssh/id_ed25519.pub`
   - Aller sur : https://github.com/settings/keys
   - Ajouter la nouvelle clé SSH

3. Changer l'URL du remote :
   ```bash
   git remote set-url origin git@github.com:aristocratte/TvSeriesExplorer.git
   ```

---

## ⚠️ Problèmes Possibles et Solutions

### Problème 1 : "Repository not found"

**Cause** : Le repository n'existe pas encore sur GitHub

**Solution** :
1. Aller sur https://github.com/new
2. Créer un repository nommé `TvSeriesExplorer`
3. **NE PAS** initialiser avec README, .gitignore ou licence
4. Relancer le push

---

### Problème 2 : "Updates were rejected"

**Cause** : Le repository distant a des commits que vous n'avez pas

**Solution** :
```bash
# Récupérer les changements distants
git pull origin main --rebase

# Pousser à nouveau
git push origin main
```

**OU si vous voulez écraser** (⚠️ attention) :
```bash
git push origin main --force
```

---

### Problème 3 : "Authentication failed"

**Cause** : Identifiants incorrects ou token expiré

**Solution** :
1. Générer un nouveau Personal Access Token
2. Utiliser le token comme mot de passe
3. OU configurer SSH (voir ci-dessus)

---

### Problème 4 : Fichiers trop volumineux

**Cause** : Certains fichiers dépassent 100MB

**Solution** :
```bash
# Vérifier les gros fichiers
find . -type f -size +50M

# Les ajouter au .gitignore
echo "chemin/vers/gros-fichier" >> .gitignore

# Recommencer
git rm --cached chemin/vers/gros-fichier
git add .
git commit -m "Remove large files"
git push origin main
```

---

## 📋 Checklist Avant de Pousser

- [ ] Le repository existe sur GitHub
- [ ] Vous avez les droits d'accès
- [ ] Les fichiers sensibles sont dans .gitignore (ex: local.properties)
- [ ] Le code compile sans erreur
- [ ] Les gros fichiers sont exclus

---

## 🎯 Après le Push

### Vérifications :

1. **Visiter le repository**
   ```
   https://github.com/aristocratte/TvSeriesExplorer
   ```

2. **Vérifier que les fichiers sont présents**
   - Fichiers source (.kt)
   - Configuration Gradle
   - README.md
   - Documentation

3. **Configurer le repository**
   - Ajouter une description
   - Ajouter des topics : `android`, `kotlin`, `jetpack-compose`, `mvvm`, `hilt`
   - Mettre le README.md à la racine pour qu'il s'affiche

4. **Ajouter un .gitignore GitHub**
   Si vous n'en avez pas déjà un, GitHub peut en générer un pour Android

---

## 🔄 Pour les Mises à Jour Futures

```bash
# Ajouter les changements
git add .

# Commit
git commit -m "Description des changements"

# Push
git push origin main
```

---

## 📝 Messages de Commit Recommandés

Exemples de bons messages :

```bash
# Feature
git commit -m "✨ Add search functionality"

# Bug fix
git commit -m "🐛 Fix crash on detail screen"

# Update
git commit -m "⬆️ Update dependencies"

# Documentation
git commit -m "📝 Update README"

# Refactor
git commit -m "♻️ Refactor ViewModels"
```

---

## 🆘 Besoin d'Aide ?

Si vous rencontrez des problèmes :

1. Vérifier les messages d'erreur
2. Consulter ce guide
3. Essayer le script automatisé
4. Vérifier que le repository existe

---

## ✅ Résumé Rapide

```bash
cd /Users/mathis/AndroidStudioProjects/AppTV
chmod +x push_to_github.sh
./push_to_github.sh
```

C'est tout ! 🎉

---

*Guide créé le 23 novembre 2025 pour le projet TV Series Explorer*


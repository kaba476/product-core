# Guide Git & GitHub - product-core et product-api

## Étape 1 : Créer les repositories GitHub

1. Aller sur https://github.com/new
2. Créer un repository **product-core** (Public ou Private)
3. Créer un repository **product-api** (Public ou Private)
4. Ne pas cocher "Initialize with README" (on push depuis le local)

## Étape 2 : Initialiser product-core

```bash
cd product-core

git init
git add .
git commit -m "feat: initialisation du projet product-core avec modèle Product"
git branch -M main
git remote add origin https://github.com/<ton-username>/product-core.git
git push -u origin main
```

## Étape 3 : Créer les branches par fonctionnalité

### Branche 1 — Modèle Product + Repository JPA

```bash
git checkout -b feature/product-model
git add .
git commit -m "feat: ajout du modèle Product et du ProductRepository JPA"
git push -u origin feature/product-model
git checkout main
git merge feature/product-model
git push origin main
```

### Branche 2 — Service : ajout de produit

```bash
git checkout -b feature/add-product
git add .
git commit -m "feat: ajout de la méthode addProduct dans ProductService"
git push -u origin feature/add-product
git checkout main
git merge feature/add-product
git push origin main
```

### Branche 3 — Service : lister les produits

```bash
git checkout -b feature/list-products
git add .
git commit -m "feat: ajout de la méthode listAllProducts dans ProductService"
git push -u origin feature/list-products
git checkout main
git merge feature/list-products
git push origin main
```

### Branche 4 — Service : modifier la quantité

```bash
git checkout -b feature/update-quantity
git add .
git commit -m "feat: ajout de la méthode updateQuantity dans ProductService"
git push -u origin feature/update-quantity
git checkout main
git merge feature/update-quantity
git push origin main
```

### Branche 5 — Service : stock faible

```bash
git checkout -b feature/low-stock
git add .
git commit -m "feat: ajout de la méthode countLowStockProducts dans ProductService"
git push -u origin feature/low-stock
git checkout main
git merge feature/low-stock
git push origin main
```

## Étape 4 : Initialiser product-api

```bash
cd product-api

git init
git add .
git commit -m "feat: initialisation de product-api avec API REST et 4 endpoints"
git branch -M main
git remote add origin https://github.com/<ton-username>/product-api.git
git push -u origin main
```

### Branche — Endpoints REST

```bash
git checkout -b feature/rest-endpoints
git add .
git commit -m "feat: ajout du ProductController avec les 4 endpoints REST"
git push -u origin feature/rest-endpoints
git checkout main
git merge feature/rest-endpoints
git push origin main
```

## Bonnes pratiques respectées

| Pratique | Description |
|---|---|
| Une branche par fonctionnalité | `feature/product-model`, `feature/add-product`, etc. |
| Commits clairs | Préfixe `feat:` + description courte et précise |
| Fusion dans main | Chaque branche est mergée dans `main` après validation |
| Deux repositories séparés | `product-core` et `product-api` sont indépendants |

## Convention de nommage des commits

| Préfixe | Utilisation |
|---|---|
| `feat:` | Nouvelle fonctionnalité |
| `fix:` | Correction de bug |
| `docs:` | Documentation |
| `refactor:` | Refactorisation du code |
| `config:` | Configuration (pom.xml, properties, etc.) |

## Résumé des branches pour product-core

```
main
├── feature/product-model       → Modèle Product + JPA Repository
├── feature/add-product         → ProductService.addProduct()
├── feature/list-products       → ProductService.listAllProducts()
├── feature/update-quantity     → ProductService.updateQuantity()
└── feature/low-stock           → ProductService.countLowStockProducts()
```

# Checkpoint 4: Diseño de interfaz

**Proyecto:** Tienda de Artículos Deportivos (Kotlin + Jetpack Compose)

La aplicación tiene dos pantallas que listan dos de los objetos implementados: `Categoria` y `Producto`. El boceto está en `diseno_pantallas.png`.

---

## Pantalla 1: Lista de Categorías

**Objetivo:** mostrar todas las categorías de la tienda (objetos `Categoria`).

**Contenido:**
- Barra superior con el título "Categorías".
- Lista vertical de tarjetas. Cada tarjeta muestra el nombre y la descripción de una categoría.
- Botón "Ver productos" que lleva a la Pantalla 2.

| Componente de Jetpack Compose | Uso en la pantalla |
|---|---|
| `Scaffold` | Estructura base: barra superior y contenido |
| `TopAppBar` | Barra superior con el título "Categorías" |
| `LazyColumn` | Lista desplazable de categorías |
| `Card` | Contenedor de cada categoría |
| `Column` | Ordena el nombre y la descripción dentro de la tarjeta |
| `Text` | Muestra el nombre y la descripción |
| `Button` | Navega a la pantalla de productos |
| `Modifier` (`padding`, `fillMaxWidth`) | Espaciado y tamaño de los elementos |

---

## Pantalla 2: Lista de Productos

**Objetivo:** mostrar los productos disponibles (objetos `Producto`).

**Contenido:**
- Barra superior con flecha de regreso y el título "Productos".
- Lista vertical de tarjetas. Cada tarjeta muestra nombre, marca, precio y stock de un producto.

| Componente de Jetpack Compose | Uso en la pantalla |
|---|---|
| `Scaffold` | Estructura base: barra superior y contenido |
| `TopAppBar` | Barra superior con el título "Productos" |
| `IconButton` + `Icon` | Flecha para volver a la pantalla anterior |
| `LazyColumn` | Lista desplazable de productos |
| `Card` | Contenedor de cada producto |
| `Column` | Ordena nombre, marca y la fila de precio y stock |
| `Row` | Muestra el precio y el stock en una misma línea |
| `Text` | Muestra los datos del producto |
| `Modifier` (`padding`, `fillMaxWidth`) | Espaciado y tamaño de los elementos |

---

## Navegación entre pantallas

- Desde **Categorías**, el botón "Ver productos" abre **Productos**.
- Desde **Productos**, la flecha de regreso vuelve a **Categorías**.
- Se implementará con `NavHost` y `NavController` (Navigation Compose).

## Datos que mostrará la aplicación

Objetos creados en el código con las clases del paquete `model`:

- **Categorías:** Fútbol, Running, Ciclismo.
- **Productos:** Balón Pro (Nike), Zapatillas Run X (Adidas), Casco Ciclista (Giro).

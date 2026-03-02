# 📦 Sistema de Gestión de Inventario (Java CLI)
Este es un sistema de gestión de inventario desarrollado en Java, diseñado para funcionar a través de la consola (interfaz de línea de comandos). Permite administrar de forma eficiente un catálogo de productos organizados por categorías de manera profesional y segura.

# ✨ Funcionalidades Principales
# 📁 Gestión de Categorías
1. **Creación Segura:** Validación de nombres únicos y con longitud mínima de 5 caracteres.
2. **Auto-ID:** Generación correlativa y automática de identificadores.
3. **Reajuste Dinámico:** Al eliminar una categoría, el sistema reorganiza automáticamente los IDs restantes para mantener el orden secuencial (1, 2, 3...).

# 🍎 Gestión de Productos
1. **Validación Estricta de Datos:**
 a) **Precios:** Deben ser mayores a 0 (el sistema acepta formatos con punto o coma mediante .replace(",", ".")).
 b) **Stock:** Protección contra valores negativos.
2)**Integridad Referencial:** Un producto solo puede crearse si se vincula a un ID de categoría que exista actualmente en el sistema.
3) **Edición Selectiva:** Menú interno que permite modificar campos específicos (solo nombre, solo precio, solo categoría, etc.) sin necesidad de sobreescribir todo el objeto.

# 📊 Visualización de Datos
1)** Listado Simple:** Vista rápida de IDs y nombres.
2)** Lista Completa:** Mapeo inteligente que cruza las listas de productos y categorías para mostrar el nombre de la categoría en lugar de solo el ID numérico.

# 🛠️ Tecnologías Utilizadas
1)**Lenguaje:** Java SE (Standard Edition)
2)**Entrada de Datos:** Uso avanzado de Scanner con manejo de búfer mediante Integer.parseInt(sc.nextLine()) para evitar errores de salto de línea.
3)**Formateo de Salida:**
	a)**NumberFormat:** Para mostrar precios según la moneda local.
	b)**printf:** Para la generación de tablas alineadas y legibles en consola.
4)**Control de Versiones:** Git alojado en GitHub.

# 🚀 Instalación y Ejecución
1)**Requisitos previos**
 a)Tener instalado el JDK 17 o superior.
 b)Un IDE compatible (Eclipse, IntelliJ o VS Code).
2)**Pasos para ejecutar**
 a)Clonar o descargar el proyecto.
 b)Importar la carpeta en tu IDE como un proyecto Java existente.
 c)Localizar el archivo: src/principal/Principal.java.
 d)Ejecutar (Run) la clase Principal.java.
 e)Interactuar con el sistema mediante el menú numérico (opciones 0 a 9).

# 📌 Validaciones de Robustez
Para garantizar que el programa no falle ante entradas inesperadas, se implementaron:
1) **Bucles do-while:** Aseguran que el usuario corrija los datos antes de avanzar si deja campos vacíos o ingresa valores inválidos.
b) **Estructuras switch-case:** Proporcionan una navegación limpia y evitan errores de lógica en el flujo del menú.
c)**Método trim():** Limpieza automática de espacios accidentales al inicio o final de las entradas de texto.

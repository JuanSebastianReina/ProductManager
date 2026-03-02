//''''''''''''''''''''''''''''
// IMPORTANCIONES
//''''''''''''''''''''''''''''
package principal;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

//''''''''''''''''''''''''''''
//CREACIÓN DE CLASE CATEGORÍA
//''''''''''''''''''''''''''''

class Producto {
    int id;
    String nombre;
    String descripcion;
    double precio;
    int stock;
    int categoriaId;

    public Producto(int id, String nombre, String descripcion, double precio, int stock, int categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
    }

    public void imprimirCompleto(NumberFormat formatoMoneda) {
        System.out.printf("%-5d %-20s %-25s %-15s %-10d %-15d%n",
                id,
                nombre,
                descripcion,
                formatoMoneda.format(precio),
                stock,
                categoriaId);
    }
    
    public void imprimirCompleto2(NumberFormat formatoMoneda, String nombreCategoria) {
        System.out.printf("%-5d %-20s %-25s %-15s %-10d %-15s%n",
                id,
                nombre,
                descripcion,
                formatoMoneda.format(precio),
                stock,
                nombreCategoria); // <--- Ahora imprimimos el nombre recibido
    }

    public void imprimirBasico() {
        System.out.printf("%-5d %-20s%n", id, nombre);
    }
    
    public int retornarIdProd() {
        return id;
    }
       
    public void cambiarIdProd(int id) {
            this.id = id; 
    }
   
    public void CambiarDescripcionProd(String descripcion) {
        this.nombre = descripcion;    
    }
}

//''''''''''''''''''''''''''''
//CREACIÓN DE CLASE CATEGORÍA
//''''''''''''''''''''''''''''
    class Categoria {
	
        int id;
        String nombre;
    
        public Categoria(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
        
        public void imprimirCategorias() {
            System.out.printf("%-5d %-20s%n", id, nombre);
        }
        
        public int retornarIdCat() {
            return id;
        }

        public String retornarDescripcionCat() {
            return nombre;
        }	

        public void CambiarDescripcion(String descripcion) {
            this.nombre = descripcion;
        }
        
        public void cambiarIdCat(int id) {
            this.id = id; 
        }
       
   }
  
public class Principal {

	static Scanner sc = new Scanner(System.in);
	static  List<Categoria> categorias = new ArrayList<>();
	static List<Producto> productos = new ArrayList<>();
	
	public static void main(String[] args) {
	   
		categorias.add(new Categoria(1, "Computadores"));
		categorias.add(new Categoria(2, "Periféricos"));
		categorias.add(new Categoria(3, "Componentes"));

	    productos.add(new Producto(1, "Laptop", "Portátil 16GB RAM", 3500000, 10, 1));
	    productos.add(new Producto(2, "Mouse", "Mouse inalámbrico", 50000, 50, 2));
	    productos.add(new Producto(3, "Teclado", "Teclado mecánico", 120000, 30, 2));
	    productos.add(new Producto(4, "Memoria Ram", "Memoria Ram 8GB", 105000, 15, 3));
		
	    /* IMPRESIÓN DE OPCIONALES
	          
         	 Ahora para saber el nombre de la categoría:  
  	for (Producto p : productos) {
        	 for (Categorias c : categorias) {
        	    if (p.categoriaId == c.id) {
        	        System.out.println(p.nombre + " pertenece a " + c.nombre);
        	    }
        	 }
        	 }
  	 */
        	    
         System.out.println("");
         int option;
                  do { System.out.println("\n===== MENÚ PRINCIPAL =====");
             System.out.println("1) Crear Categoría");
             System.out.println("2) Listar Categorías");
             System.out.println("3) Editar Categoría");
             System.out.println("4) Eliminar Categoría");
             System.out.println("5) Crear Producto");
             System.out.println("6) Listar Productos");
             System.out.println("7) Editar Producto");
             System.out.println("8) Eliminar Producto");
             System.out.println("9) Lista Completa");
             System.out.println("0) Salir");

             System.out.print("Seleccione una opción: ");
             option = Integer.parseInt(sc.nextLine()); 

             switch (option) {
                   
                 case 1: crearCategorias(); break;
                 case 2: listarCategorias(); break;
                 case 3: editarCategorias(); break;
                 case 4: eliminarCategorias(); break;
                 case 5: crearProductos(); break;
                 case 6: listarProductos(); break;
                 case 7: editarProductos(); break;
                 case 8: eliminarProductos(); break;
                 case 9: listaCompleta(); break;
                          
             }

         } while (option != 0);
         {
        	 System.out.println("Hasta pronto, gracias!");
         }                 
	}
	
	 //---------------------
	 //MÉTODOS PARA CATEGORÍAS
	 //---------------------	

	 public static void crearCategorias() {
		  
		    String nombre;
		 		    
		    boolean existe;
		    do {
		       existe=false;
		    	System.out.print("Escriba el nombre de la nueva categoría: ");
		        nombre = sc.nextLine().trim();

		        if (nombre.isEmpty()) {
		            System.out.println("El nombre no puede estar vacío. Debe ingresar un nombre para la categoría.");
		        }
		        else if	(nombre.length()<5) {
		    	   System.out.println("El nombre debe ser de al menos 5 carácteres. Debe ingresar un nuevo nombre para la categoría.");
		            } 
		        else { 
		        	for (Categoria c : categorias) {
		                if (c.nombre.equalsIgnoreCase(nombre)) {
		                    System.out.println("Error: La categoría '" + nombre + "' ya existe.");
		                    existe = true;
		                    break;
		                }
		              }
		           }
		        } while (nombre.isEmpty() || nombre.length() < 5 || existe);
		    int nuevoId = 1;

		    if (!categorias.isEmpty()) {
		        nuevoId = categorias.get(categorias.size() - 1).id + 1;
		    }

		    categorias.add(new Categoria(nuevoId, nombre));
		    System.out.println("NUEVA CATEGORIA CREADA");
		    System.out.println(nombre + " es la categoría con ID: " + nuevoId);
		}
         
	 public static void listarCategorias() {
		 System.out.println("");
         System.out.println("Tabla de Categorías:");
         System.out.println("ID    Nombre");
       	 System.out.println("----------------------");
         for (Categoria c:categorias) {
        	 c.imprimirCategorias();
              }
	     }     
      
	 public static void editarCategorias() {
		 System.out.print("Escriba el ID de la categoría que quiere actualizar ");
		  int IdBuscado = Integer.parseInt(sc.nextLine()); 
		    
		    boolean encontrado = false;
		    
		    for (Categoria cat : categorias) {
		        if (cat.retornarIdCat() == IdBuscado) {
		            encontrado = true;
		            String nuevoNombre;

				            do {
		                System.out.print("Ingrese el nuevo nombre (mínimo 5 caracteres): ");
		                nuevoNombre = sc.nextLine().trim();

		                if (nuevoNombre.isEmpty()) {
		                    System.out.println("❌ El nombre no puede estar vacío.");
		                } else if (nuevoNombre.length() <= 4) {
		                    System.out.println("❌ El nombre es muy corto (debe tener 5 letras o más).");
		                }

		            } while (nuevoNombre.length() <= 4); // Se repite MIENTRAS sea menor o igual a 5

		            cat.CambiarDescripcion(nuevoNombre);
		            System.out.println("✅ Categoría actualizada con éxito.");
		            break;
		        }
		    }

		    if (!encontrado) {
		        System.out.println("❌ No se encontró ninguna categoría con el ID: " + IdBuscado);
		    }
		}
	
	 public static void eliminarCategorias() {
		 System.out.print("Escriba el ID de la categoría que desea eliminar: ");
		    
		    int idABuscar = Integer.parseInt(sc.nextLine()); 		    
		    boolean encontrado = false;

		    for (int i = 0; i < categorias.size(); i++) {
		        if (categorias.get(i).retornarIdCat() == idABuscar) {
		            categorias.remove(i);
		            encontrado = true;
		            System.out.println("✅ Categoría eliminada.");
		            break; 
		        }
		    }

		    if (encontrado) {
		        for (int i = 0; i < categorias.size(); i++) {
		          
		            int nuevoId = i + 1;
		            
		            categorias.get(i).cambiarIdCat(nuevoId); 
		        }
		        System.out.println("🔄 IDs reajustados automáticamente.");
		    } else {
		        System.out.println("❌ No se encontró el ID: " + idABuscar);
		    }
		}
	//---------------------
	//MÉTODOS PARA PRODUCTOS
    //---------------------	 
	 public static void crearProductos() {
			    String nombre, descripcion;
		    double precio;
		    int stock;
		    int categoriaId;
		    boolean existe;
		    do {
		    	
		    // 1. Nombre
		       existe=false;
		    	System.out.print("Escriba el nombre del nuevo producto: ");
		        nombre = sc.nextLine().trim();

		        
		        if (nombre.isEmpty()) {
		            System.out.println("El nombre no puede estar vacío. Debe ingresar un nombre para el producto.");
		        }
		        else if	(nombre.length()<5) {
		    	   System.out.println("El nombre debe ser de al menos 5 carácteres. Debe ingresar un nuevo nombre para el producto.");
		            } 
		        else { 
		        	for (Producto p : productos) {
		                if (p.nombre.equalsIgnoreCase(nombre)) {
		                    System.out.println("Error: El producto '" + nombre + "' ya existe.");
		                    existe = true;
		                    break;
		                }
		              }
		           }
		        } while (nombre.isEmpty() || nombre.length() < 5 || existe);
		   
		    // 2. Descripción (Opcional)
		    System.out.print("Descripción (opcional, presiona Enter para saltar): ");
		    descripcion = sc.nextLine().trim();

		    // 3. Precio
		    do {
		    System.out.print("Precio (usa punto o coma según tu región): ");
		    precio = Double.parseDouble(sc.nextLine().replace(",", "."));
		     
		    if (precio<= 0) System.out.println("El Precio debe ser positivo.");
		    
		    }
		    while (precio <= 0);
		    

		    // 4. Stock (Validar que sea positivo o 0)
		    do {
		        System.out.print("Stock inicial: ");
		        stock = Integer.parseInt(sc.nextLine());
		        if (stock < 0) System.out.println("El stock no puede ser negativo.");
		    } while (stock < 0);

		    // 5. Categoría
		    boolean categoriaValida = false;
		    do {
		    
		    System.out.println("");
	         System.out.println("Tabla de Categorías Disponibles:");
	         System.out.println("ID    Nombre");
	       	 System.out.println("----------------------");
	         for (Categoria c:categorias) {
	        	 c.imprimirCategorias();
	              }
	         
		    System.out.print("Ingrese el ID de Categoría, en el que quiere incluir el nuevo producto : ");
		    categoriaId = Integer.parseInt(sc.nextLine());
		    for (Categoria c : categorias) {
	            if (c.id == categoriaId) { // Suponiendo que tu clase Categoria tiene un atributo .id
	                categoriaValida = true;
	                break;
	            }
	        }
		    if (!categoriaValida) {
	            System.out.println("❌ Error: El ID de categoría no existe. Intente de nuevo.");
	        } 
		    }while(!categoriaValida);
		  
		    // 6. Creación de ID
		    int nuevoId = 1;

		    if (!productos.isEmpty()) {
		        nuevoId = productos.get(productos.size() - 1).id + 1;
		    }
		 
		    Producto nuevoProducto = new Producto(nuevoId, nombre, descripcion, precio, stock, categoriaId);
		    productos.add(nuevoProducto);
		    System.out.println("NUEVO PRODUCTO CREADO");
		    System.out.println("---------------------------------------------------------------------------------------");
		    System.out.printf("%-5s %-20s %-25s %-15s %-10s %-15s%n", "ID", "Nombre", "Descripción", "Precio", "Stock", "Cat ID");
		    System.out.println("---------------------------------------------------------------------------------------");
		    NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
		    nuevoProducto.imprimirCompleto(formatoMoneda);
		    
	      }
	 
	 public static void listarProductos() {
		  NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
		    System.out.println("Tabla de productos");
		    System.out.println("---------------------------------------------------------------------------------------");
		    System.out.printf("%-5s %-20s %-25s %-15s %-10s %-15s%n", "ID", "Nombre", "Descripción", "Precio", "Stock", "Cat ID");
		    System.out.println("---------------------------------------------------------------------------------------");
		  
		    for (Producto p:productos) {
        	 p.imprimirCompleto(formatoMoneda);
              }
	     } 
	 
	 public static void eliminarProductos() {
		    System.out.print("Escriba el número del producto que desea eliminar: ");
		    
		    int idABuscar = Integer.parseInt(sc.nextLine()); 
		    	    
		    boolean encontrado = false;

		    for (int i = 0; i < productos.size(); i++) {
		        if (productos.get(i).retornarIdProd() == idABuscar) {
		            productos.remove(i);
		            encontrado = true;
		            System.out.println("Producto eliminado.");
		            break; 
		        }
		    }

		    if (encontrado) {
		        for (int i = 0; i < productos.size(); i++) {
		          
		            int nuevoId = i + 1;
		            
		            productos.get(i).cambiarIdProd(nuevoId); 
		        }
		        System.out.println("La enumeración de los productos se ha ajustado automáticamente.");
		    } else {
		        System.out.println("❌ No se encontró el producto : " + idABuscar);
		    }
		}
	 
	 public static void editarProductos() {
		
		 System.out.print("Escriba el ID del producto que quiere actualizar ");
		    int idBuscado = Integer.parseInt(sc.nextLine());
		  		    
		    boolean encontrado = false;
		    
		    for (Producto p : productos) {
		        if (p.retornarIdProd() == idBuscado) {
		            encontrado = true;
		            System.out.println("\nProducto encontrado: " + p.nombre);
		            System.out.println("1. Nombre | 2. Descripción | 3. Precio | 4. Stock | 5. Categoría");
		            System.out.print("¿Qué desea modificar? (Elija una opción): ");
		            int opcion = Integer.parseInt(sc.nextLine());

		            switch (opcion) {
		                case 1: // Nombre
		                    String nuevoNombre;
		                    do {
		                        System.out.print("Nuevo nombre (mín. 5 caracteres): ");
		                        nuevoNombre = sc.nextLine().trim();
		                    } while (nuevoNombre.length() < 5);
		                    p.nombre = nuevoNombre; // O p.setNombre(nuevoNombre);
		                    break;

		                case 2: // Descripción
		                    System.out.print("Nueva descripción: ");
		                    p.descripcion = sc.nextLine().trim();
		                    break;

		                case 3: // Precio
		                    double nuevoPrecio;
		                    do {
		                        System.out.print("Nuevo precio (mayor a 0): ");
		                        nuevoPrecio = Double.parseDouble(sc.nextLine().replace(",", "."));
		                    } while (nuevoPrecio <= 0);
		                    p.precio = nuevoPrecio;
		                    break;

		                case 4: // Stock
		                    int nuevoStock;
		                    do {
		                        System.out.print("Nuevo stock (0 o más): ");
		                        nuevoStock = Integer.parseInt(sc.nextLine());
		                    } while (nuevoStock < 0);
		                    p.stock = nuevoStock;
		                    break;

		                case 5: // Categoría
		                	  boolean categoriaValida = false;
		                	  int nuevaCatId;
		          		    do {
		          		    
		          		    System.out.println("");
		          	         System.out.println("Tabla de Categorías Disponibles:");
		          	         System.out.println("ID    Nombre");
		          	       	 System.out.println("----------------------");
		          	       
		          	       	 for (Categoria c:categorias) {
		          	        	 c.imprimirCategorias();
		          	              }
		          	         
		          		    System.out.print("Ingrese el nuevo ID de Categoría");
		          		    nuevaCatId = Integer.parseInt(sc.nextLine());
		          		   
		          		    for (Categoria c : categorias) {
		          		    	if (c.retornarIdCat() == nuevaCatId) { 
		          		    		{ 
		          		    	}
		          	                categoriaValida = true;
		          	                break;
		          	            }
		          	        }
		          		    if (!categoriaValida) {
		          	            System.out.println("❌ Error: El ID de categoría no existe. Intente de nuevo.");
		          	        } 
		          		    }while(!categoriaValida);

		          		  p.categoriaId = nuevaCatId; // Guardar el cambio en el producto
		          	      break;
		          	    
		                default:
		                    System.out.println("Opción no válida.");
		                    break;
		            }
		            System.out.println("✅ Cambio realizado con éxito.");
		            break;
		        }
		    }

		    if (!encontrado) {
		        System.out.println("❌ No se encontró el producto con ID: " + idBuscado);
		    }
		}
	
	 public static String obtenerNombreCategoria(int idCat) {
		    for (Categoria c : categorias) {
		        if (c.retornarIdCat() == idCat) {
		            return c.nombre; // Retorna el nombre si lo encuentra
		        }
		    }
		    return "Sin Categoría"; // Por si el ID no existe
		}
	 
	 public static void listaCompleta() {
		    NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();

		    System.out.println("\n--- TABLA DE PRODUCTOS ---");
		    System.out.println("---------------------------------------------------------------------------------------");
		    System.out.printf("%-5s %-20s %-25s %-15s %-10s %-15s%n", "ID", "Nombre", "Descripción", "Precio", "Stock", "Categoría");
		    System.out.println("---------------------------------------------------------------------------------------");
		    
		    for (Producto p : productos) {
		        // Buscamos el nombre de la categoría usando su ID
		        String nombreCat = obtenerNombreCategoria(p.categoriaId);
		        
		        // Pasamos el formato Y el nombre de la categoría al método
		        p.imprimirCompleto2(formatoMoneda, nombreCat); 
		    }
		    System.out.println("---------------------------------------------------------------------------------------");
		}
	 }   
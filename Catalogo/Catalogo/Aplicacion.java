package Catalogo;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Aplicacion {//modificador de acceso clase nombre clase
	//declaracion del metodo
    public static void main(String[] args) {//modificador de acceso al tener el main es el principal
        Scanner scanner = new Scanner(System.in);
        TiendaHasbonOnline tienda = new TiendaHasbonOnline();
        tienda.cargarCatalogo();

        int opcion = 0;//declaraciones de variables
        String idUsuario = "";
        String idPedido = "";
        String direccionEntrega = "";
        String input;
        while (opcion != 9) {
        
        	  input = JOptionPane.showInputDialog(null, "**********  MENU  **********\n"
                      + "1. Ingresar ID de usuario\n"
                      + "2. Visualización del catálogo (ordenado por marca)\n"
                      + "3. Visualización del catálogo (ordenado por tipo)\n"
                      + "4. Visualización del catálogo (ordenado por estilo)\n"
                      + "5. Agregar al carrito de compra\n"
                      + "6. Envío del paquete y/o compra\n"
                      + "7. Mostrar dirección de entrega y carrito de compras\n"
                      + "8. Búsqueda del pedido\n"
                      + "9. Salir\n"
                      + "Ingrese una opción:");

              opcion = Integer.parseInt(input);


            switch (opcion) {
            
            case 1:
                idUsuario = JOptionPane.showInputDialog(null, "Ingrese su ID de usuario:");
                JOptionPane.showMessageDialog(null, "ID de usuario ingresado con éxito: " + idUsuario);
                break;

                case 2:
                    tienda.mostrarCatalogoOrdenado("marca");
                    break;
                case 3:
                    tienda.mostrarCatalogoOrdenado("tipo");
                    break;
                case 4:
                    tienda.mostrarCatalogoOrdenado("estilo");
                    break;
               
                case 5:
                    String indiceProductoStr = JOptionPane.showInputDialog(null, "Ingrese el índice del producto a agregar al carrito:", "Agregar al carrito", JOptionPane.PLAIN_MESSAGE);
                    int indiceProducto = Integer.parseInt(indiceProductoStr);
       
                    tienda.agregarAlCarrito(indiceProducto - 1);
                    break;
              
                case 6:
                    direccionEntrega = JOptionPane.showInputDialog(null, "Ingrese la dirección de entrega:");
                    tienda.ingresarDireccionEntrega(direccionEntrega);
                    JOptionPane.showMessageDialog(null, "Ingreso de direccion correcto");
                    break;
                case 7:
                    if (direccionEntrega.isEmpty()) {
                    	JOptionPane.showMessageDialog(null,"Dirección de entrega no ingresada. Por favor, ingrese una dirección primero.");
                    } else {
                    	JOptionPane.showMessageDialog(null,"Dirección de entrega: " + direccionEntrega+ "\nID del usuario: " + idUsuario);
                        
                        tienda.mostrarCarrito();
                    }
                    break;
               
                case 8:
                	
                	idPedido = JOptionPane.showInputDialog("Ingrese el ID de Usuario :  ");
                 
                    if (idPedido.equals(idUsuario)) {
                    	JOptionPane.showMessageDialog(null,"ID del usuario: " + idUsuario+"Dirección de entrega: " + direccionEntrega);
                       
                        tienda.mostrarCarrito();
                    } else {
                    	JOptionPane.showMessageDialog(null,"ID del pedido no coincide con el ID del usuario.");
                    }
                    break;
                case 9:
                	JOptionPane.showMessageDialog(null,"Gracias por visitar mi tienda Surron ¡Hasta luego!");
                    break;
                default:
                	JOptionPane.showMessageDialog(null,"Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
}
        


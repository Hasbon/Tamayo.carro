package Catalogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import java.util.Comparator;
//CLASE
public class TiendaHasbonOnline {
    private List<Producto> catalogo;//modificador de acceso privado
    private List<Producto> carrito;
    private Map<String, String> pedidos;

    public TiendaHasbonOnline() {
        catalogo = new ArrayList<>();//nombre de la clase nombre del objeto nombre constructor
        carrito = new ArrayList<>();
        pedidos = new HashMap<>();
    }
//METODO en el se llenan los atributos de la clase
    public void cargarCatalogo() {//void es el valor de retorno estamos agrgando el listado de productos
        catalogo.add(new Producto("Nike", "Moda Deportiva", "Camiseta"));
        catalogo.add(new Producto("Adidas", "Moda Casual", "Pantalón"));
        catalogo.add(new Producto("Nike", "Calzado", "Zapatilas"));
        catalogo.add(new Producto("Adidas", "Moda Deportiva", "Sudadera"));
        catalogo.add(new Producto("Nike", "Moda de Alta Costura", "Vestido"));
        catalogo.add(new Producto("Adidas", "Calzado", "Tenis"));
        catalogo.add(new Producto("Nike", "Moda casual", "Camiseta POLO"));
        catalogo.add(new Producto("Adidas", "Moda de Alta Costura", "Traje"));
        catalogo.add(new Producto("Nike", "Calzado", "Botas"));
        catalogo.add(new Producto("Adidas", "Moda Deportiva", "Gorra"));
        catalogo.add(new Producto("Nike", "Moda Casual", "Camisa"));
        catalogo.add(new Producto("Adidas", "Calzado", "Sandalias"));
        catalogo.add(new Producto("Nike", "Moda de Alta Costura", "Blazer"));
        catalogo.add(new Producto("Adidas", "Moda Deportiva", "Top"));
        catalogo.add(new Producto("Nike", "Calzado", "Tacones"));
        catalogo.add(new Producto("Adidas", "Moda Casual", "Blusa"));
        catalogo.add(new Producto("Nike", "Moda Deportiva", "Traje de baño"));
        catalogo.add(new Producto("Adidas", "Moda de Alta Costura", "Corbatines"));
        catalogo.add(new Producto("Nike", "Calzado", "Chanclas"));
        catalogo.add(new Producto("Adidas", "Moda Casual", "Pantalóneta"));
    }
//metodo tosos los procesos
    public void mostrarCatalogoOrdenado(String opcionOrden) {
        Comparator<Producto> comparator;

        switch (opcionOrden) {
            case "marca":
                comparator = Comparator.comparing(Producto::getMarca);
                break;
            case "tipo":
                comparator = Comparator.comparing(Producto::getTipo);
                break;
            case "estilo":
                comparator = Comparator.comparing(Producto::getEstilo);
                break;
            default:
            	JOptionPane.showMessageDialog(null,"Opción inválida. Se mostrará el catálogo sin ordenar.");
               
                return;
        }

        catalogo.sort(comparator);

        System.out.println("Catálogo de productos:");
        int size = catalogo.size();
        for (int i = 0; i < size; i++) {
            Producto producto = catalogo.get(i);
            System.out.println((i + 1) + "    Marca: " + producto.getMarca() +
                    ", Tipo: " + producto.getTipo() +
                    ", Estilo: " + producto.getEstilo());
        }
    }

    public void agregarAlCarrito(int indiceProducto) {
        if (indiceProducto >= 0 && indiceProducto < catalogo.size()) {
            Producto producto = catalogo.get(indiceProducto);
            carrito.add(producto);
            JOptionPane.showMessageDialog(null,"El producto ha sido agregado al carrito de compras.");
        } else {
        	JOptionPane.showMessageDialog(null,"Índice de producto inválido.");
        }
    }

    public void mostrarCarrito() {
    	JOptionPane.showMessageDialog(null,"Carrito de compras:");
        for (int i = 0; i < carrito.size(); i++) {
            Producto producto = carrito.get(i);
            JOptionPane.showMessageDialog(null,(i + 1) + ". Marca: " + producto.getMarca() +
                    ", Tipo: " + producto.getTipo() +
                    ", Estilo: " + producto.getEstilo());
        }
    }

    public void ingresarDireccionEntrega(String direccion) {
        pedidos.put("ID-001", direccion);
    }

    public void mostrarPedido(String idPedido) {
        if (pedidos.containsKey(idPedido)) {
            String direccion = pedidos.get(idPedido);
            JOptionPane.showMessageDialog(null,"Pedido: " + idPedido+ "\nDirección de entrega: " + direccion );
          
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró el pedido con el ID especificado.");
        }
    }
}

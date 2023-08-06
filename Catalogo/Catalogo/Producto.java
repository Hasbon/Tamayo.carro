package Catalogo;

class Producto {//las clases deben tener atributos y metodos
	private String marca;//propiedad
    private String tipo;
    private String estilo;

    //METODO
    public Producto(String marca, String tipo, String estilo) {
        this.marca = marca;//instancia de la clase, tanbien se usa para reenviar la llamada a un constructor
        this.tipo = tipo;// como es una clase privada se debe de llamar con this
        this.estilo = estilo;
    }

    public String getMarca() {//get me permite llamar de la clase producto privada
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstilo() {
        return estilo;
    }
}

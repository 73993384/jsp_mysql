package models;

public class VentaM {
    //ESTRUCTURA (PROPIEDADES, ENCAPSULADOS Y CONSTRUCTORES) = CAPA ENTIDAD
    private int id;
    private int idVenta;
    private int idProducto;
    private int cantidad;

    public VentaM() {
    }

    public VentaM(int id, int idVenta, int idProducto, int cantidad) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}

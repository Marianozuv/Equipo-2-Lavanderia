package com.javarevolutions.ws.rest.DAO;


import java.util.Date;

public class Pedido {
	
	private int idPedido;
    private float total_Kilo;
    private int total_Prenda;
    private String tipo_Ropa;
    private String tipo_Servicio;
    private Date fechaP;


    public Pedido(int idPedido, float total_Kilo, int total_Prenda, String tipo_Ropa, String tipo_Servicio, Date fechaP){

        super();
        this.idPedido= idPedido;
        this.total_Kilo=total_Kilo;
        this.total_Prenda=total_Prenda;
        this.tipo_Ropa=tipo_Ropa;
        this.tipo_Servicio=tipo_Servicio;
        this.fechaP=fechaP;
    }

    public Pedido(){

    }



    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getTotal_Kilo() {
        return total_Kilo;
    }
    public void setTotal_Kilo(float total_Kilo) {
        this.total_Kilo = total_Kilo;
    }

    public int getTotal_Prenda() {
        return total_Prenda;
    }
    public void setTotal_Prenda(int total_Prenda) {
        this.total_Prenda = total_Prenda;
    }

    public String getTipo_Ropa() {
        return tipo_Ropa;
    }
     public void setTipo_Ropa(String tipo_Ropa) {
        this.tipo_Ropa = tipo_Ropa;
    }

    public String getTipo_Servicio() {
        return tipo_Servicio;
    }
    public void setTipo_Servicio(String tipo_Servicio) {
        this.tipo_Servicio = tipo_Servicio;
    }

    public Date getFechaP() {
        return fechaP;
    }
    public void setFechaP(Date fechaP) {
        this.fechaP = fechaP;
    }


    public String toString(){
        return "ID Pedido [id="+idPedido+", Total de kilos:"+total_Kilo+", Total de prendas:"+total_Prenda+", Tipo de ropa:"+tipo_Ropa+", Servicio:"+tipo_Servicio+", Fecha de creacion del pedido:"+fechaP;
    }

}

package com.javarevolutions.ws.rest.DAO;

public class Administrador {
	private String correoA;
    private String contrasenia;

    public Administrador(String correoA, String contrasenia) {
        this.setCorreoA(correoA);
        this.setContrasena(contrasenia);
       
    }

    public String getCorreoA() {
        return correoA;
    }

    public void setCorreoA(String correoA) {
        this.correoA = correoA;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasena(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}

package com.javarevolutions.ws.rest.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//https://www.youtube.com/watch?v=k5RKM3r2Srk
//http://localhost:8080/RestJR/services/JavaRevolutions/validaUsuario  Para probar en el postmain
/*
 {
	"usuario":"Java",
	"password": "Revolutions"
}
 */
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.javarevolutions.ws.rest.DAO.AltaClienteDAO;
import com.javarevolutions.ws.rest.DAO.Cliente;
import com.javarevolutions.ws.rest.DAO.LoginDAO;
import com.javarevolutions.ws.rest.vo.VOUsuario;

@Path("/JavaRevolutions")
public class ServiceLoginJR {
	
	LoginDAO loginDao = new LoginDAO();
	AltaClienteDAO altaCliente = new AltaClienteDAO();

	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Boolean validaUsuario(VOUsuario vo) throws SQLException{
		//mandar a llamar el dao
		Boolean existe = loginDao.validarUsuario(vo);
		return existe;
	}
	
	@POST
	@Path("/altaCliente")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String altaCliente(Cliente datosCliente) throws SQLException{
		//mandar a guardar los datos a la base
		String respuesta = altaCliente.altaCliente(datosCliente);
		
		return respuesta;
	}
	
	
	@GET
	@Path("/consultarClientes")
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
	public Response consultarClientes() throws SQLException{
		//mandar a CONSULTAR los datos a la base
		ArrayList<Cliente> clientes = altaCliente.consultarClientes();	
		//CONVERTIMOS EL ARRAY A JSON
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(clientes, new TypeToken<List<Cliente>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();	
	  return Response.ok().entity(String.valueOf(jsonArray)).build();
	}
	
	
	@POST
	@Path("/eliminarusuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Boolean eliminarUsuario(Cliente vo) throws SQLException{
		//mandar a llamar el dao
		String respuesta = altaCliente.eliminarCliente(vo);
		return true;
	}
}

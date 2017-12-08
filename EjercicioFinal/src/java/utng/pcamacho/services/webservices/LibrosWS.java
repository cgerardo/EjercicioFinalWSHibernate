/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.pcamacho.services.webservices;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import utng.pcamacho.model.dao.LibrosDAO;
import utng.pcamacho.model.pojos.Libros;

/**
 *
 * @author gerar
 */
@WebService(serviceName = "LibrosWS")
public class LibrosWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IngresarLibros")
    public String IngresarLibros(@WebParam(name = "codigo") int codigo, @WebParam(name = "titulo") String titulo, @WebParam(name = "autor") String autor, @WebParam(name = "editorial") String editorial, @WebParam(name = "edicion") String edicion) {
        //TODO write your implementation code here:
        Libros l = new Libros(codigo, titulo, autor, editorial, edicion);
        LibrosDAO librosDAO = new LibrosDAO();
        librosDAO.ingresarLibros(l);
        return "Libro ingresado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarLibros")
    public String BuscarLibros(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        LibrosDAO librosDAO = new LibrosDAO();
        return librosDAO.consultarLibros(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarLibros")
    public List<Libros> ConsultarLibros() {
        //TODO write your implementation code here:
        LibrosDAO librosDAO = new LibrosDAO();
        List<Libros> listaLibros= librosDAO.verLibros();
        return listaLibros;
    }
    
    
}

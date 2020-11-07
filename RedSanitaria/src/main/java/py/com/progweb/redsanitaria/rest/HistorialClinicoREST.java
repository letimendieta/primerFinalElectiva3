package py.com.progweb.redsanitaria.rest;

import py.com.progweb.redsanitaria.ejb.HistorialClinicoDAO;
import py.com.progweb.redsanitaria.model.HistorialClinico;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;


@Path(value = "/historialclinico")
public class HistorialClinicoREST {



    @Inject
    private HistorialClinicoDAO historialClinicoDAO;

    @POST
    @Consumes(value = "application/json")
    public void create(HistorialClinico historialClinico){
        historialClinicoDAO.agregar(historialClinico);
    }


    @PUT
    @Consumes("application/json")
    public void edit(@QueryParam("ci") String ci, @QueryParam("nombre") String nombre) {
        historialClinicoDAO.modificar(ci,nombre);
    }

    @DELETE
    @Path("{codhistorial}")
    public void remove(@PathParam("codhistorial") Integer codhistorial) {
        historialClinicoDAO.borrar(codhistorial);
    }

    @GET
    @Produces("application/json")
    public List<HistorialClinico> findAll() {
        return historialClinicoDAO.listar();
    }

}

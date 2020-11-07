package py.com.progweb.redsanitaria.rest;

import py.com.progweb.redsanitaria.ejb.MedicoDAO;
import py.com.progweb.redsanitaria.model.Medico;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path(value = "/medico")
public class MedicoREST {



    @Inject
    private MedicoDAO medicoDAO;

    @POST
    @Consumes(value = "application/json")
    public void create(Medico medico){
        medicoDAO.agregar(medico);
    }


    @PUT
    @Consumes("application/json")
    public void edit(@QueryParam("dni") String dni, @QueryParam("nombre") String nombre) {
        medicoDAO.modificar(dni,nombre);
    }

    @DELETE
    @Path("{codmedico}")
    public void remove(@PathParam("codmedico") Integer codmedico) {
        medicoDAO.borrar(codmedico);
    }

    @GET
    @Produces("application/json")
    public List<Medico> findAll() {
        return medicoDAO.listar();
    }

}

package py.com.progweb.redsanitaria.rest;

import py.com.progweb.redsanitaria.ejb.ConsultaCabDAO;
import py.com.progweb.redsanitaria.model.ConsultaCab;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path(value = "/consulta")
public class ConsultaCabREST {



    @Inject
    private ConsultaCabDAO consultacabDAO;

    @POST
    @Consumes(value = "application/json")
    public void create(ConsultaCab consultacab){
        consultacabDAO.agregar(consultacab);
    }


    @PUT
    @Consumes("application/json")
    public void edit(@QueryParam("codconsulta") Integer codconsulta, @QueryParam("diagnostico") String diagnostico) {
        consultacabDAO.modificar(codconsulta,diagnostico);
    }

    @DELETE
    @Path("{codconsulta}")
    public void remove(@PathParam("codconsulta") Integer codconsulta) {
        consultacabDAO.borrar(codconsulta);
    }

    @GET
    @Produces("application/json")
    public List<ConsultaCab> findAll() {
        return consultacabDAO.listar();
    }

}

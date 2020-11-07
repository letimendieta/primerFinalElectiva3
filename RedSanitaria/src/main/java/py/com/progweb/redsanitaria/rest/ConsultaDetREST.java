package py.com.progweb.redsanitaria.rest;

import py.com.progweb.redsanitaria.ejb.ConsultaCabDAO;
import py.com.progweb.redsanitaria.ejb.ConsultaDetDAO;
import py.com.progweb.redsanitaria.model.ConsultaCab;
import py.com.progweb.redsanitaria.model.ConsultaDet;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path(value = "/consultadet")
public class ConsultaDetREST {

    @Inject
    private ConsultaDetDAO consultaDetDAO;

    @POST
    @Consumes(value = "application/json")
    public void create(ConsultaDet consultaDet){
        consultaDetDAO.agregar(consultaDet);
    }


    @PUT
    @Consumes("application/json")
    public void edit(@QueryParam("codconsulta") Integer codconsultadet, @QueryParam("diagnostico") String nrohabitacion) {
        consultaDetDAO.modificar(codconsultadet,nrohabitacion);
    }

    @DELETE
    @Path("{codconsulta}")
    public void remove(@PathParam("codconsulta") Integer codconsultadet) {
        consultaDetDAO.borrar(codconsultadet);
    }

    @GET
    @Produces("application/json")
    public List<ConsultaDet> findAll() {
        return consultaDetDAO.listar();
    }

}

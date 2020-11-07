package py.com.progweb.redsanitaria.rest;

import py.com.progweb.redsanitaria.ejb.ServicioDAO;
import py.com.progweb.redsanitaria.model.Servicio;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path(value = "/servicio")
public class ServicioREST {



    @Inject
    private ServicioDAO servicioDAO;

    @POST
    @Consumes(value = "application/json")
    public void create(Servicio servicio){
        servicioDAO.agregar(servicio);
    }


    @PUT
    @Consumes("application/json")
    public void edit(@QueryParam("codservicio") Integer codservicio, @QueryParam("nombre") String nombre) {
        servicioDAO.modificar(codservicio,nombre);
    }

    @DELETE
    @Path("{codservicio}")
    public void remove(@PathParam("codservicio") Integer codservicio) {
        servicioDAO.borrar(codservicio);
    }

    @GET
    @Produces("application/json")
    public List<Servicio> findAll() {
        return servicioDAO.listar();
    }
    @GET
    @Path("/hospitales")
    @Produces("application/json")
    public List<Servicio> getListServicioHospital() {
        return servicioDAO.listarPorServicioHospital();
    }

}

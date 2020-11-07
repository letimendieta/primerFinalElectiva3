package py.com.progweb.redsanitaria.rest;



import py.com.progweb.redsanitaria.ejb.HospitalDAO;
import py.com.progweb.redsanitaria.model.Hospital;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path(value = "/hospital")
public class HospitalREST {



    @Inject
    private HospitalDAO hospitalDAO;

    @POST
    @Consumes(value = "application/json")
    public void create(Hospital hospital){
        hospitalDAO.agregar(hospital);
    }


    @PUT
    @Consumes("application/json")
    public void edit(@QueryParam("codhospital") Integer codhospital, @QueryParam("nombre") String nombre) {
        hospitalDAO.modificar(codhospital,nombre);
    }

    @DELETE
    @Path("{codhospital}")
    public void remove(@PathParam("codhospital") Integer codhospital) {
        hospitalDAO.borrar(codhospital);
    }

    @GET
    @Produces("application/json")
    public List<Hospital> findAll() {
        return hospitalDAO.listar();
    }

}

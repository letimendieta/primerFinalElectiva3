package py.com.progweb.redsanitaria.ejb;



import py.com.progweb.redsanitaria.model.Servicio;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless

public class ServicioDAO {
    @PersistenceContext
    private EntityManager em;



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void agregar(Servicio servicio){
        em.persist(servicio);


    }


    public void modificar(Integer codservicio, String nombre){
        Query q= em
                .createQuery("UPDATE Servicio s set s.nombre=:nombre where s.codservicio=:codservicio" );
        q.setParameter("codservicio" , codservicio);
        q.setParameter("nombre" , nombre);
        q.executeUpdate();
    }

    public void borrar(Integer id){
        Servicio servicio = find(id);
        if (servicio != null) {
            em.remove(servicio);
        }
    }
    public Servicio find(int id) {
        return this.em.find(Servicio.class, id);
    }
    public List<Servicio> listar(){
        Query q= em
                .createQuery("select s.codservicio,s.nombre,s.comentario,s.nrocamas  from Servicio s");
        return (List<Servicio>) q.getResultList();
    }

    public List<Servicio> listarPorServicioHospital(){
        Query q= em
                .createQuery("select distinct s.codservicio,s.nombre,s.nrocamas,s.comentario,s.hospital.nombre from Servicio s left join s.hospital.servicios ls  WHERE s.codhospital=ls.hospital.codhospital");
        return (List<Servicio>) q.getResultList();
    }

}

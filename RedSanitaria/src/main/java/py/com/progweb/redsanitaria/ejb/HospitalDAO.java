package py.com.progweb.redsanitaria.ejb;

import py.com.progweb.redsanitaria.model.Hospital;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class HospitalDAO {
    @PersistenceContext(unitName = "redsanitariaPU")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void agregar(Hospital hospital){
        this.entityManager.persist(hospital);

    }


    public void modificar(Integer codhospital, String nombre){
        Query q= entityManager
                .createQuery("UPDATE Hospital h set h.nombre=:nombre where h.codhospital=:codhospital" );
        q.setParameter("codhospital" , codhospital);
        q.setParameter("nombre" , nombre);
        q.executeUpdate();
    }

    public void borrar(Integer id){
        Hospital hospital = find(id);
        if (hospital != null) {
            entityManager.remove(hospital);
        }
    }
    public Hospital find(int id) {
        return this.entityManager.find(Hospital.class, id);
    }
    public List<Hospital> listar(){
        Query q= entityManager
                .createQuery("select h.codhospital,h.nombre,h.telefono,h.ciudad  from Hospital h  ");
        return (List<Hospital>) q.getResultList();
    }

}

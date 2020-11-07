package py.com.progweb.redsanitaria.ejb;

import py.com.progweb.redsanitaria.model.Medico;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless
public class MedicoDAO {
    @PersistenceContext(unitName = "redsanitariaPU")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void agregar(Medico medico){
        this.entityManager.persist(medico);

    }


    public void modificar(String dni, String nombre){
        Query q= entityManager
                .createQuery("UPDATE Medico m set m.nombre=:nombre where m.dni=:dni" );
        q.setParameter("dni" , dni);
        q.setParameter("nombre" , nombre);
        q.executeUpdate();
    }

    public void borrar(Integer id){
        Medico medico = find(id);
        if (medico != null) {
            entityManager.remove(medico);
        }
    }
    public Medico find(int id) {
        return this.entityManager.find(Medico.class, id);
    }
    public List<Medico> listar(){
        Query q= entityManager
                .createQuery("select m.codmedico,m.dni,m.nombre,m.apellido,m.esdirector,function('to_char',m.fechanacimiento,'yyyy-mm-dd')  from Medico m ");
        return (List<Medico>) q.getResultList();
    }

}

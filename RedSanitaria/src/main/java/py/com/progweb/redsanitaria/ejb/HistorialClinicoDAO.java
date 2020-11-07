package py.com.progweb.redsanitaria.ejb;

import py.com.progweb.redsanitaria.model.HistorialClinico;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class HistorialClinicoDAO {
    @PersistenceContext(unitName = "redsanitariaPU")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void agregar(HistorialClinico historialClinico){
       this.entityManager.persist(historialClinico);

    }


    public void modificar(String ci, String nombre){
        Query q= entityManager
                .createQuery("UPDATE HistorialClinico hc set hc.nombre=:nombre where hc.ci=:ci" );
  q.setParameter("ci" , ci);
  q.setParameter("nombre" , nombre);
  q.executeUpdate();
    }

    public void borrar(Integer id){
        HistorialClinico historialClinico = find(id);
        if (historialClinico != null) {
            entityManager.remove(historialClinico);
        }
    }
    public HistorialClinico find(int id) {
        return this.entityManager.find(HistorialClinico.class, id);
    }
    public List<HistorialClinico> listar(){
        Query q= entityManager
                .createQuery("select hc.codhistorial,hc.ci,hc.nombre,hc.apellido,function('to_char',hc.fechanacimiento,'yyyy-mm-dd')  from HistorialClinico hc  ");
        return (List<HistorialClinico>) q.getResultList();
    }

}

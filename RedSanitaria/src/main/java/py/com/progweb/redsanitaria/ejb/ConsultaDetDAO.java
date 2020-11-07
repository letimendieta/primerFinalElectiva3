package py.com.progweb.redsanitaria.ejb;



import py.com.progweb.redsanitaria.model.ConsultaDet;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Stateless
public class ConsultaDetDAO {
    @PersistenceContext(unitName = "redsanitariaPU")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void agregar(ConsultaDet consultaDet){
        this.entityManager.persist(consultaDet);

    }


    public void modificar(Integer codconsultadet, String nrohabitacion){
        Query q= entityManager
                .createQuery("UPDATE ConsultaDet cd set cd.nrohabitacion=:nrohabitacion where cd.codconsultadet=:codconsultadet" );
        q.setParameter("nrohabitacion" , nrohabitacion);
        q.setParameter("codconsultadet" , codconsultadet);
        q.executeUpdate();
    }

    public void borrar(Integer id){
        ConsultaDet consultaDet = find(id);
        if (consultaDet != null) {
            entityManager.remove(consultaDet);
        }
    }
    public ConsultaDet find(int id) {
        return this.entityManager.find(ConsultaDet.class, id);
    }
    public List<ConsultaDet> listar(){
        Query q= entityManager
                .createQuery("select cd.codconsultadet,cd.nrohabitacion,cd.ingreso,function('to_char',cd.fechaalta,'yyyy-mm-dd')  from ConsultaDet cd  ");
        return (List<ConsultaDet>) q.getResultList();
    }

}

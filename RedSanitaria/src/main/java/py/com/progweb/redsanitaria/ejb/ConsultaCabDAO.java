package py.com.progweb.redsanitaria.ejb;

import py.com.progweb.redsanitaria.model.ConsultaCab;
import py.com.progweb.redsanitaria.model.Medico;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

    @Stateless
    public class ConsultaCabDAO {
        @PersistenceContext(unitName = "redsanitariaPU")
        private EntityManager entityManager;

        @TransactionAttribute(TransactionAttributeType.REQUIRED)
        public void agregar(ConsultaCabDAO consultaCabDAO){
            this.entityManager.persist(consultaCabDAO);

        }



        public void modificar(Integer codconsultacab, String diagnostico){
            Query q= entityManager
                    .createQuery("UPDATE ConsultaCab cb set cb.diagnostico=:diagnostico where cb.codconsulta=:codconsultacab" );
            q.setParameter("diagnostico" , diagnostico);
            q.setParameter("codconsultacab" , codconsultacab);
            q.executeUpdate();
        }

        public void borrar(Integer id){
            ConsultaCab consultacab = find(id);
            if (consultacab != null) {
                entityManager.remove(consultacab);
            }
        }
        public ConsultaCab find(int id) {
            return this.entityManager.find(ConsultaCab.class, id);
        }
        public List<ConsultaCab> listar(){
            Query q= entityManager
                    .createQuery("select cb.codconsulta,cb.diagnostico,cb.tratamiento,function('to_char',cb.fecha,'yyyy-mm-dd'),function('to_char',cb.hora,'yyyy-mm-dd')   from ConsultaCab cb  ");
            return (List<ConsultaCab>) q.getResultList();
        }
    }
package py.com.progweb.redsanitaria.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @Column(name = "codservicio")
    @Basic(optional = false )
    @GeneratedValue(generator = "codservicio_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codservicio_id_seq", sequenceName = "codservicio_id_seq", allocationSize = 0)
    private Integer codservicio;


    @Column(name = "nombre")
    @Basic (optional = false)
    private String nombre;

    @Column(name = "comentario")
    @Basic (optional = false)
    private String comentario;


    @Column(name = "nrocamas")
    @Basic (optional = false)
    private Integer nrocamas;

    @Column(name = "codhospital")
    @Basic (optional = false)
    private Integer codhospital;

    @ManyToOne
    @JoinColumn(name="codhospital", nullable=false, insertable = false, updatable = false)
    private Hospital hospital;

    @ManyToMany
    private Set<Medico> medicos;

    @OneToOne(mappedBy = "servicio")
    private ConsultaCab consultaCab;


    public Servicio() {

    }


    public Integer getCodservicio() {
        return codservicio;
    }

    public void setCodservicio(Integer codservicio) {
        this.codservicio = codservicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getNrocamas() {
        return nrocamas;
    }

    public void setNrocamas(Integer nrocamas) {
        this.nrocamas = nrocamas;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }


    public Integer getCodhospital() {
        return codhospital;
    }

    public void setCodhospital(Integer codhospital) {
        this.codhospital = codhospital;
    }
}

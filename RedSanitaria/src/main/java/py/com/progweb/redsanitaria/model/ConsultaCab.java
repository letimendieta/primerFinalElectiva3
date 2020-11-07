package py.com.progweb.redsanitaria.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "consultascab")
public class ConsultaCab {

    @Id
    @Column(name = "codconsulta")
    @Basic(optional = false )
    @GeneratedValue(generator = "codconsulta_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codconsulta_id_seq", sequenceName = "codconsulta_id_seq", allocationSize = 0)
    private Integer codconsulta;

    @Column(name = "fecha")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "hora")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date hora;

    @Column(name = "diagnostico")
    @Basic (optional = false)
    private String diagnostico;

    @Column(name = "tratamiento")
    @Basic (optional = false)
    private String tratamiento;


    @Column(name = "codservicio")
    @Basic (optional = false)
    private Integer codservicio;


    @Column(name = "codhospital")
    @Basic (optional = false)
    private Integer codhospital;

/*    @ManyToOne
    @JoinColumn(name="codconsulta", nullable=false, insertable = false, updatable = false)
    private HistorialClinico historialClinico;*/


    @OneToOne
    @JoinColumn(name = "codservicio", referencedColumnName = "codservicio", nullable=false, insertable = false, updatable = false)
    private Servicio servicio;


    @OneToOne
    @JoinColumn(name = "codhospital", referencedColumnName = "codhospital", nullable=false, insertable = false, updatable = false)
    private Hospital hospital;

    public ConsultaCab() {
    }

    /*public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
        this.historialClinico = historialClinico;
    }*/


    public Integer getCodconsulta() {
        return codconsulta;
    }

    public void setCodconsulta(Integer codconsulta) {
        this.codconsulta = codconsulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }


    public Integer getCodservicio() {
        return codservicio;
    }

    public void setCodservicio(Integer codservicio) {
        this.codservicio = codservicio;
    }

    public Integer getCodhospital() {
        return codhospital;
    }

    public void setCodhospital(Integer codhospital) {
        this.codhospital = codhospital;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}

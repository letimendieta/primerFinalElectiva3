package py.com.progweb.redsanitaria.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "medicos")
public class Medico {


    @Id
    @Column(name = "codmedico")
    @Basic(optional = false )
    @GeneratedValue(generator = "codmedico_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codmedico_id_seq", sequenceName = "codmedico_id_seq", allocationSize = 0)
    private Integer codmedico;

    @Column(name = "dni")
    @Basic (optional = false)
    private String dni;

    @Column(name = "nombre")
    @Basic (optional = false)
    private String nombre;

    @Column(name = "apellido")
    @Basic (optional = false)
    private String apellido;


    @Column(name = "fechanacimiento")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;

    @Column(name = "esdirector")
    @Basic (optional = false)
    private String esdirector;

    @Column(name = "codhospital")
    @Basic (optional = false)
    private Integer codhospital;

    @OneToOne(mappedBy = "medico")
    private Hospital hospital;


    @ManyToMany
    @JoinTable(
            name = "medico_servicio",
            joinColumns = @JoinColumn(name = "codmedico", nullable = false),
            inverseJoinColumns = @JoinColumn(name="codservicio", nullable = false)
    )
    Set<Servicio> serviciosList;


    public Medico() {
    }

    public Integer getCodmedico() {
        return codmedico;
    }

    public void setCodmedico(Integer codmedico) {
        this.codmedico = codmedico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEsdirector() {
        return esdirector;
    }

    public void setEsdirector(String esdirector) {
        this.esdirector = esdirector;
    }

    public Integer getCodhospital() {
        return codhospital;
    }

    public void setCodhospital(Integer codhospital) {
        this.codhospital = codhospital;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }


}

package py.com.progweb.redsanitaria.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "historialclinico")
public class HistorialClinico {



    @Id
    @Column(name = "codhistorial")
    @Basic(optional = false )
    @GeneratedValue(generator = "codhistorial_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codhistorial_id_seq", sequenceName = "codhistorial_id_seq", allocationSize = 0)
    private Integer codhistorial;

    @Column(name = "ci")
    @Basic (optional = false)
    private String ci;

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

 /*   @OneToMany(mappedBy="historialclinico")
    private List<ConsultaCab> consultaCabList;*/

    public HistorialClinico() {
    }

 /*   public List<ConsultaCab> getConsultaCabList() {
        return consultaCabList;
    }

    public void setConsultaCabList(List<ConsultaCab> consultaCabList) {
        this.consultaCabList = consultaCabList;
    }*/

    public Integer getCodhistorial() {
        return codhistorial;
    }

    public void setCodhistorial(Integer codhistorial) {
        this.codhistorial = codhistorial;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
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
}

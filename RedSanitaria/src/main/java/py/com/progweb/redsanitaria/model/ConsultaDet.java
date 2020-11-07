package py.com.progweb.redsanitaria.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultasdet")
public class ConsultaDet {


    @Id
    @Column(name = "codconsultadet")
    @Basic(optional = false )
    @GeneratedValue(generator = "codconsultadet_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codconsultadet_id_seq", sequenceName = "codconsultadet_id_seq", allocationSize = 0)
    private Integer codconsultadet;

    @Column(name = "ingreso")
    @Basic (optional = false)
    private String ingreso;

    @Column(name = "nrohabitacion")
    @Basic (optional = false)
    private String nrohabitacion;

    @Column(name = "fechaalta")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaalta;



    public ConsultaDet() {
    }


    public Integer getCodconsultadet() {
        return codconsultadet;
    }

    public void setCodconsultadet(Integer codconsultadet) {
        this.codconsultadet = codconsultadet;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getNrohabitacion() {
        return nrohabitacion;
    }

    public void setNrohabitacion(String nrohabitacion) {
        this.nrohabitacion = nrohabitacion;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }
}

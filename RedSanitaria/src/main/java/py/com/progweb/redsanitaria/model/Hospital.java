package py.com.progweb.redsanitaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @Column(name = "codhospital")
    @Basic(optional = false)
    @GeneratedValue(generator = "codhospital_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codhospital_id_seq", sequenceName = "codhospital_id_seq", allocationSize = 0)
    private Integer codhospital;


    @Column(name = "nombre")
    @Basic(optional = false)
    private String nombre;

    @Column(name = "ciudad")
    @Basic(optional = false)
    private String ciudad;

    @Column(name = "telefono")
    @Basic(optional = false)
    private String telefono;

    @OneToMany(mappedBy="hospital")
    private Set<Servicio> servicios;

    @OneToOne(mappedBy = "hospital")
    private ConsultaCab consultaCab;

    @OneToOne
    @JoinColumn(name = "codmedico", referencedColumnName = "codmedico", nullable=false, insertable = false, updatable = false)
    private Medico medico;

    public Hospital() {
    }

    public Hospital(Integer codhospital, String nombre, String ciudad, String telefono) {
        this.codhospital = codhospital;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;

    }

    public Integer getCodhospital() {
        return codhospital;
    }

    public void setCodhospital(Integer codhospital) {
        this.codhospital = codhospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}


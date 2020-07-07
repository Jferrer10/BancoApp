package mx.com.trnetwork.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "cliente_sequence", sequenceName = "CLIENTE_SEQ")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "sequences")
	private Long id_cli;
		
	@Column(name="nombre")
	private String nombre;
	
	@Column(name ="apellidoP")
	private String apellidoP;
	
	@Column(name="apellidoM")
	private String apellidoM;
	
	@Column(name="sucursal")
	private String sucursal;
	
	@Column(name="buro")
	private boolean buro;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
	@JsonIgnore
	private List<Creditos> creditos;
	
	public Cliente() {
	}

	
	
	public Cliente(Long id_cli, String nombre, String apellidoP, String apellidoM, String sucursal, boolean buro,
			List<Creditos> creditos) {
		super();
		this.id_cli = id_cli;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.sucursal = sucursal;
		this.buro = buro;
		this.creditos = creditos;
	}



	/**
	 * @return the id_cli
	 */
	public Long getId_cli() {
		return id_cli;
	}



	/**
	 * @param id_cli the id_cli to set
	 */
	public void setId_cli(Long id_cli) {
		this.id_cli = id_cli;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public boolean isBuro() {
		return buro;
	}

	public void setBuro(boolean buro) {
		this.buro = buro;
	}

	public List<Creditos> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Creditos> creditos) {
		this.creditos = creditos;
	}



	@Override
	public String toString() {
		return "Cliente [id_cli=" + id_cli + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM="
				+ apellidoM + ", sucursal=" + sucursal + ", buro=" + buro + ", creditos=" + creditos + "]";
	}

	
	
}

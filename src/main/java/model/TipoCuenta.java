package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "TipoCuenta")
@Entity(name = "TipoCuenta")
@Getter
@Setter
public class TipoCuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;

	@Column
	private String moneda;

	@OneToMany(mappedBy = "tipoCuenta", cascade = CascadeType.PERSIST)
	private List<Cuenta> cuentas;
}

package model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Movimiento")
@Entity(name = "Movimiento")
@Getter
@Setter
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	
	@Column()
  private LocalDate fecha;

  @Column()
  private Double monto;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "cuenta_id")
  private Cuenta cuenta;
}

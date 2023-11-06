package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cuenta")
@Entity(name = "Cuenta")
@Getter
@Setter
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

  @Column(columnDefinition = "BIT(1)")
  private boolean activa;

  @Column()
  private String numeroCuenta;

  @Column()
  private Double saldo;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "tipoCuenta_id")
  private TipoCuenta tipoCuenta;

  @OneToMany(mappedBy = "cuenta", cascade = CascadeType.PERSIST)
  private List<Movimiento> movimientos;

  @Override
  public String toString() {
    return "Cuenta [id=" + id + ", activa=" + activa + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo
        + ", cliente=" + cliente + ", tipoCuenta=" + tipoCuenta + ", movimientos=" + movimientos + "]";
  }
  
}

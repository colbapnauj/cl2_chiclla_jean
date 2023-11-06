package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cliente")
@Entity(name = "Cliente")
@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

  // No se le asigna length, porque usaremos el length por default 255
  @Column()
  private String apellidoMaterno;

  @Column()
  private String apellidoPaterno;

  @Column()
	private String nombres;

  @OneToMany(mappedBy = "cliente", cascade =  CascadeType.PERSIST)
  private List<Cuenta> cuentas;

  @ManyToMany(cascade = CascadeType.PERSIST)
	private List<Rol> roles;

  @Override
  public String toString() {
    return "Cliente [id=" + id + ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno
        + ", nombres=" + nombres + ", cuentas=" + cuentas + ", roles=" + roles + "]";
  }
}

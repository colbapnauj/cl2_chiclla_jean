package tests;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Rol;
import model.TipoCuenta;

public class JPATest {

  public static void main(String[] args) throws IOException {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    EntityManager manager = factory.createEntityManager();

    EntityTransaction transaction = manager.getTransaction();

    transaction.begin();

    TipoCuenta tipoCuenta = new TipoCuenta();
    tipoCuenta.setDescripcion("Cuenta de ahorros");
    tipoCuenta.setMoneda("Dólares");

    Cuenta cuenta1 = new Cuenta();
    cuenta1.setActiva(true);
    cuenta1.setNumeroCuenta("123123123123");
    cuenta1.setSaldo(5000.00);
    cuenta1.setTipoCuenta(tipoCuenta);

    // Movimientos
    Movimiento movimiento1 = new Movimiento();
    movimiento1.setDescripcion("Retiro");
    movimiento1.setFecha(LocalDate.of(2023, 11, 04));
    movimiento1.setMonto(200.00);
    List<Movimiento> movimientos = Arrays.asList(movimiento1);

    cuenta1.setMovimientos(movimientos);

    List<Cuenta> cuentas = Arrays.asList(cuenta1);

    // Roles
    Rol rol1 = new Rol();
    rol1.setActivo(true);
    rol1.setDescripcion("cliente");
    List<Rol> roles = Arrays.asList(rol1);

    Cliente cliente = new Cliente();
    cliente.setApellidoMaterno("Fuentes");
    cliente.setApellidoPaterno("Chiclla");
    cliente.setNombres("Jean Paul");
    cliente.setCuentas(cuentas);
    cliente.setRoles(roles);

    // Insertar
    manager.persist(cliente);

    transaction.commit();

  }
}

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();

            Cliente cliente1 = new Cliente(1, "Juan Perez", "Av. Siempre Viva 123");
            clienteDAO.agregarCliente(cliente1);

            Cliente clienteObtenido = clienteDAO.obtenerCliente(1);
            if (clienteObtenido != null) {
                clienteObtenido.mostrarDetalles();
            }

            SistemaSeguimiento sistemaSeguimiento = new SistemaSeguimiento();
            Envio envio1 = new Envio(1, "Calle Falsa 456", "En tránsito", new Date(), null);
            sistemaSeguimiento.registrarEnvio(envio1);
            sistemaSeguimiento.actualizarEstadoEnvio(1, "Entregado");

            Envio envioConsultado = sistemaSeguimiento.consultarEnvio(1);
            if (envioConsultado != null) {
                System.out.println("Envio ID: " + envioConsultado.getIdEnvio() + ", Estado: " + envioConsultado.getEstado());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
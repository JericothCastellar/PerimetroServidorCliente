package jericothcastellar.servidor;

import java.net.*;
import jericothcastellar.aplicacion.CalcularPerimetroService;
public class Servidor {
    public static void main(String[] args) {

        int puerto = 5000;
        CalcularPerimetroService servicio = new CalcularPerimetroService();

        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            System.out.println("Servidor UDP iniciado en el puerto " + puerto);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket paqueteEntrada = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteEntrada);

                String datos = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Datos recibidos: " + datos);

                String respuesta;
                try {
                    String[] partes = datos.split(",");
                    double largo = Double.parseDouble(partes[0]);
                    double ancho = Double.parseDouble(partes[1]);
                    respuesta = servicio.ejecutar(largo, ancho);
                } catch (Exception e) {
                    respuesta = "Error: datos inválidos.";
                }

                byte[] respuestaBytes = respuesta.getBytes();
                DatagramPacket paqueteSalida = new DatagramPacket(
                        respuestaBytes, respuestaBytes.length,
                        paqueteEntrada.getAddress(), paqueteEntrada.getPort()
                );
                socket.send(paqueteSalida);
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor UDP: " + e.getMessage());
        }
    }
}

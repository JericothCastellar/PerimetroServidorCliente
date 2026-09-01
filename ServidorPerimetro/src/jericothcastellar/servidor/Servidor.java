package jericothcastellar.servidor;
import java.io.*;
import java.net.*;
public class Servidor {
    public static void main(String[] args) {
        int puerto = 5000; // Puerto de escucha
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (true) {
                // Esperar conexión de cliente
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                try (
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    // Recibir datos
                    String lineaLargo = entrada.readLine();
                    String lineaAncho = entrada.readLine();

                    if (lineaLargo != null && lineaAncho != null) {
                        double largo = Double.parseDouble(lineaLargo);
                        double ancho = Double.parseDouble(lineaAncho);

                        // Calcular perímetro
                        double perimetro = 2 * (largo + ancho);

                        // Enviar resultado
                        salida.println(perimetro);
                    } else {
                        System.out.println("Cliente no envio datos validos.");
                        salida.println("Error: datos invalidos.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error de formato numerico: " + e.getMessage());
                } finally {
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}

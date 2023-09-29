package AccesoADatos.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {
    private static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Puerto del servidor
            System.out.println("Servidor de chat en línea.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket);

                // Agregar el PrintWriter del cliente a la lista de clientes
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);

                // Manejar la comunicación con el cliente en un hilo separado
                Thread clientThread = new Thread(new ClientHandler(clientSocket, out));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase interna para manejar la comunicación con un cliente
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;

        public ClientHandler(Socket clientSocket, PrintWriter out) {
            this.clientSocket = clientSocket;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Mensaje recibido: " + message);

                    // Reenviar el mensaje a todos los clientes
                    for (PrintWriter client : clients) {
                        client.println(message);
                    }

                    // Guardar el mensaje en un archivo XML
                    saveMessageToXML(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Cuando un cliente se desconecta, quitarlo de la lista de clientes
                    clients.remove(out);
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void saveMessageToXML(String message) {

        }
    }
}

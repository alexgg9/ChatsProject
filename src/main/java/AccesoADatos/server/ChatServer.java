package AccesoADatos.server;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        boolean serverListening = false;

        try{
            serverSocket = new ServerSocket(8080);
            serverListening = true;
        }catch (IOException error){
            System.out.println("Error al abrir servidor");
        }

        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        if(serverListening){
            System.out.println("Servidor listo para aceptar conexiones");
            try {
                socket = serverSocket.accept();
                //el socket está establecido
                in = socket.getInputStream();
                String filename = "chat.xml";
                Path filePath = Path.of(filename);
                out = new FileOutputStream(filename);
                byte[] bytes = new byte[8*1024];


                int count;
                while ((count = in.read(bytes))>0){
                    System.out.println(count);
                    out.write(bytes,0,count);
                }
                out.close();
                in.close();
                socket.close();

                System.out.println("Cerrando servidor");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

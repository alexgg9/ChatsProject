package AccesoADatos.server;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Uso: java Client ipServer fileTobeTransfered");
        }else{
            String ipServer = args[0];
            String fileTobeTransfered = args[1];

            Socket socket = null;
            InputStream in = null;
            OutputStream out = null;

            try {
                socket = new Socket(ipServer,8080);
                File file = new File(fileTobeTransfered);
                if(file.exists() && file.isFile() && file.isFile()){
                    in = new FileInputStream(file);
                    out = socket.getOutputStream();
                    byte[] buffer = new byte[8*1024];
                    int count;
                    while((count = in.read(buffer))>0){
                        out.write(buffer,0,count);
                    }
                    out.close();
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

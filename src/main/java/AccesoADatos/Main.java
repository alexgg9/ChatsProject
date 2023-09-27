package AccesoADatos;

import java.util.Scanner;

import AccesoADatos.model.DAO.ChatRoomDAO;

public class Main {
    public static void main(String[] args) {
        ChatRoomDAO chatRoomDAO	= new ChatRoomDAO();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa tu apodo: ");
        String nickname = scanner.nextLine();
        chatRoomDAO.joinChat(nickname);
        
        while (true) {
            System.out.print("Mensaje: ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                chatRoomDAO.leaveChat(nickname);
                chatRoomDAO.saveChat("chat.xml");
                System.out.println("Hasta luego, " + nickname + "!");
                break;
            }
            chatRoomDAO.sendMessage(nickname, message);
        }
    }
}
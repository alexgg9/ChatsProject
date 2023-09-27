package AccesoADatos;

import java.util.Scanner;

import AccesoADatos.model.DAO.ChatRoomDAO;
import AccesoADatos.model.DAO.UserDAO;
import AccesoADatos.model.domain.User;

public class Main {
    public static void main(String[] args) {
        ChatRoomDAO chatRoomDAO	= new ChatRoomDAO();
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa tu apodo: ");
        String nickname = scanner.nextLine();
        User u = new User(nickname);
        UserDAO.saveUser(u);
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
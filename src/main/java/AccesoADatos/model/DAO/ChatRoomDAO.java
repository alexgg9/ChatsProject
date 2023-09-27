package AccesoADatos.model.DAO;





	 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import AccesoADatos.model.domain.ChatRoom;
import AccesoADatos.model.domain.Message;
import AccesoADatos.model.domain.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatRoomDAO {
    private ChatRoom chatRoom;

    public ChatRoomDAO() {
        chatRoom = new ChatRoom();
    }

    public void joinChat(String nickname) {
        User user = new User();
        user.setNickname(nickname);
        chatRoom.getUsers().add(user);
    }

    public void sendMessage(String sender, String message) {
        Message chatMessage = new Message();
        chatMessage.setSender(sender);
        chatMessage.setContent(message);
        chatMessage.setTimestamp(new Date().toString());
        chatRoom.getMessages().add(chatMessage);
    }

    public void leaveChat(String nickname) {
        chatRoom.getUsers().removeIf(user -> user.getNickname().equals(nickname));
    }

    public void saveChat(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(ChatRoom.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(chatRoom, new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void loadChat(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(ChatRoom.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            chatRoom = (ChatRoom) unmarshaller.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

package AccesoADatos.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
     private ArrayList<String> users = new ArrayList<>();
     private ArrayList<Message> messages = new ArrayList<>();

    public ChatRoom() {
    }
    
    

    public ChatRoom(String name) {
		super();
		this.name = name;
	}



	public ChatRoom(String name, ArrayList<String> users, ArrayList<Message> messages) {
        this.name = name;
        this.users = users;
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", messages=" + messages +
                '}';
    }
}

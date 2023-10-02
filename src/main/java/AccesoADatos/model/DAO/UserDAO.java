package AccesoADatos.model.DAO;
import javax.xml.bind.*;

import AccesoADatos.model.domain.ChatRoom;
import AccesoADatos.model.domain.User;
import AccesoADatos.model.domain.Users;

import java.io.File;
import java.util.List;

public class UserDAO {
    private static final String XML_FILE = "users.xml";
    private Users users;
  
    
    public UserDAO(){
    		users = loadUsers("users.xml");
    			
       }

    public void addUser(User newUser) {
    	if(this.users==null) {
    		this.users = new Users();
    	}
    	this.users.add(newUser);
    }
    public void saveUsers(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Si el archivo XML ya existe, carga los datos existentes
            Users existingUsers = loadUsers(filename);

            // Agrega los nuevos usuarios a la lista existente
            existingUsers.getUsers().addAll(users.getUsers());

            // Guarda los datos actualizados en el archivo XML
            marshaller.marshal(existingUsers, new File(filename));

            System.out.println("Usuarios guardados correctamente en " + filename);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Users loadUsers(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                JAXBContext context = JAXBContext.newInstance(Users.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                return (Users) unmarshaller.unmarshal(file);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Users(); // Si el archivo no existe, crea una instancia vacía
    }
}
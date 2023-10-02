package AccesoADatos.model.DAO;
import javax.xml.bind.*;

import AccesoADatos.model.domain.User;
import AccesoADatos.model.domain.Users;

import java.io.File;
import java.util.List;

public class UserDAO {
    private static final String XML_FILE = "users.xml";

    public void saveUsers(List<User> users) {
        try {
            Users usersWrapper = new Users();
            usersWrapper.setUsers(users);

            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(usersWrapper, new File(XML_FILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public List<User> loadUsers() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users usersWrapper = (Users) unmarshaller.unmarshal(new File(XML_FILE));
            return usersWrapper.getUsers();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
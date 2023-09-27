package AccesoADatos.model.DAO;
import AccesoADatos.model.domain.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
public class UserDAO {



        private static final String XML_FILE = "users.xml";

        public static void saveUser(User user) {
            try {
                JAXBContext context = JAXBContext.newInstance(User.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(user, new File(XML_FILE));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }

        public User loadUser() {
            try {
                JAXBContext context = JAXBContext.newInstance(User.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                return (User) unmarshaller.unmarshal(new File(XML_FILE));
            } catch (JAXBException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

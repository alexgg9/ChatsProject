package AccesoADatos.model.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement ( name = "User")
public class User implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private String nickname;
	
    

    public User() {
    }

    public User(String nickname, ChatRoom nameChat) {
        this.nickname = nickname;
  
    }
    @XmlElement( name = "Nickname")
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nickname, user.nickname);
    }


    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                '}';
    }

 }

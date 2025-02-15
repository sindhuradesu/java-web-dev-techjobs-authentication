package org.launchcode.javawebdevtechjobsauthentication.models;

//import com.sun.istack.NotNull;
//import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
@Entity
public class User extends AbstractEntity {

        @NotNull
        private String username;

        @NotNull
        private String pwHash;
        public User() {}
        public User(String username, String password) {
            this.username = username;
            this.pwHash = encoder.encode(password);
        }
        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        public boolean isMatchingPassword(String password) {
            return encoder.matches(password, pwHash);
        }
        public String getUsername() {
            return username; }

    }
}

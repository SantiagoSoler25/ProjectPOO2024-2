package Logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

        private String username;
        private String masterPassword;

        // Constructor para inicializar el nombre de usuario y la contraseña maestra
        public User(String username, String masterPassword) {
            this.username = username;
            this.masterPassword = masterPassword;
        }


        // Método para autenticar al usuario comparando las contraseñas
        public boolean authenticate(String password) {
            return password.equals(this.masterPassword);
        }

        // Método para cambiar la contraseña maestra
        public boolean changeMasterPassword(String oldPassword, String newPassword) {
            if (authenticate(oldPassword)) {
                this.masterPassword = newPassword;
                return true;
            }
            return false;
        }

    }
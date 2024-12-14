package Logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BackupManager {
    private String filePath;

    public BackupManager(String filePath) {
        this.filePath = filePath;
    }

    public void backup(List<PasswordEntry> passwords) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(passwords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PasswordEntry> restore() {
        List<PasswordEntry> passwords = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            passwords = (List<PasswordEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return passwords;
    }
}
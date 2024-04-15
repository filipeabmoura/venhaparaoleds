import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EntradaTXT {
    public Scanner input;

    public EntradaTXT(String caminho) {
        try {
            this.input = new Scanner(new FileInputStream(caminho));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}

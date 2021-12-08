package uet.oop.bomberman.Setup;

import javafx.scene.media.Media;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class ResourceLoader {

    public static String loadText(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    public static BufferedImage loadImage(String filePath) throws IOException {
        return ImageIO.read(Objects.requireNonNull(ResourceLoader.class.getResource(filePath)));
    }

    public static Media loadSound(String filePath) {
        try {
            return new Media(Objects.requireNonNull(ResourceLoader.class.getResource(filePath)).toURI().toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

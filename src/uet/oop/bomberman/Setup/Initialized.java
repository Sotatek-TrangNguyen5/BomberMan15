//package uet.oop.bomberman.Setup;
//import javafx.scene.Group;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.Random;
//
///**
// * Lớp này chứa tất cả các tài nguyên như là ảnh, âm thanh,... cần phải được load khi khởi động game
// */
//public class Initialized {
//
////    public static final JFrame baseFrame = new JFrame(Strings.WindowTitle);
////    public static final JPanel panel = (JPanel) baseFrame.getContentPane();
//
//    public static final Group baseLayout = new Group();
//
//
////    public static final GfxFromFile gfx = new GfxFromFile();
////    public static final FontFromFile font = new FontFromFile();
//
//    public static String CreditInfoFromFile = "";
//    static {
//        try {
//            CreditInfoFromFile = ResourceLoader.loadText(FilePath.InfoFilePath.CreditInfo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static String HowToPlayInfoFromFile = "";
//    static {
//        try {
//            HowToPlayInfoFromFile = ResourceLoader.loadText(FilePath.InfoFilePath.HowToPlayInfo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static final Random random = new Random();
//
//    static {
//        baseFrame.setIconImage(Initialized.gfx.appIcon());
//        panel.setBackground(Color.black);
//        panel.setPreferredSize(new Dimension(AllSettings.userSettings.displayWidth, AllSettings.userSettings.displayHeight));
//        panel.setLayout(null);
//
//        // initializing JavaFX for media playback (especially mp3 files)
//        final JFXPanel jfxPanel = new JFXPanel();
//        panel.add(jfxPanel);
//        Platform.runLater(() -> {
//            javafx.scene.Scene scene = new javafx.scene.Scene(new Group());
//            jfxPanel.setScene(scene);
//        });
//    }
//}

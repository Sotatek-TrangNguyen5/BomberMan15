package uet.oop.bomberman.Setup.Settings;

import javafx.scene.input.KeyCode;

/**
 * This class contains all the graphics, audio, game, control and other fixed settings.
 * Lớp này có tất cả các cài đặt cố định về đồ họa, âm thanh, điều khiển,...
 */
public class AllSettings {

    public static UserSettings userSettings = new UserSettings();


    public static final int unscaledWidth = 304;
    public static final int unscaledHeight = 224;

    public static final int unscaledWidth_half = unscaledWidth >> 1;
    public static final int unscaledHeight_half = unscaledHeight >> 1;


    public static final int motionBlurAlpha = 127;


    public static final int timeoutWarningStartingTimeBeforeTimeout = 30 * 1000;


    public static final KeyCode Key_MenuLeft = KeyCode.LEFT;
    public static final KeyCode Key_MenuRight = KeyCode.RIGHT;
    public static final KeyCode Key_MenuUp = KeyCode.UP;
    public static final KeyCode Key_MenuDown = KeyCode.DOWN;
    public static final KeyCode Key_MenuEnter = KeyCode.ENTER;
    public static final KeyCode Key_Backspace = KeyCode.BACK_SPACE;
    public static final KeyCode Key_Delete = KeyCode.DELETE;
    public static final KeyCode Key_Escape = KeyCode.ESCAPE;


    public static void saveUserData() {
//        new Thread(() -> {
//            ObjectOutputStream out = null;
//            try {
//                out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FilePath.UserFilePath.UserData)));
//                userSettings.write(out);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (out != null) {
//                    try {
//                        out.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }
}

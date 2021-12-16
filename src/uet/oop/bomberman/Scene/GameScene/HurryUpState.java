package uet.oop.bomberman.Scene.GameScene;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import uet.oop.bomberman.Scene.Subscene;
import uet.oop.bomberman.Setup.FilePath;
import uet.oop.bomberman.Setup.ResourceLoader;
import uet.oop.bomberman.Setup.Settings.AllSettings;
import uet.oop.bomberman.SoundSystem.LoopingSound;


/**
 * Created by Arnob on 15/12/2014.
 * HurryUpState of MainGame
 */
public class HurryUpState implements Subscene {

    private static final int timeoutWarningVibrationElapsed = 3000;
    private static final int vibratingValue = (int) (1 * AllSettings.userSettings.motionConst);
    private static final int timeoutWarningMiddleStringShowInterval = 1000;
    private static final int timeoutWarningBottomStringShowInterval = 2000;
    private static final int delayAfterTimeout = 2000;

//    private static final int hurryUpMiddleStringImage_left = (AllSettings.unscaledWidth - GfxFromFile.readyGoHurry_Width) >> 1;
//    private static final int hurryUpMiddleStringImage_top = (AllSettings.unscaledHeight - GfxFromFile.readyGoHurry_Height) >> 1;

//    private static final BufferedImage hurryUpBottomStringImage = RenderString.renderSmallString(Strings.Game.HurryUp, FontColor.Red);
//    private static final int hurryUpBottomStringImage_left = AllSettings.unscaledWidth_half - (hurryUpBottomStringImage.getWidth() >> 1);
//    private static final int hurryUpBottomStringImage_top = AllSettings.unscaledHeight - (int) (FontFromFile.smallFontHeight * 1.5) - 1;

    private static final int timeoutWarningMiddleStringShowInterval_half = timeoutWarningMiddleStringShowInterval >> 1;
    private static final int timeoutWarningBottomStringShowInterval_half = timeoutWarningBottomStringShowInterval >> 1;

    private boolean vibrateState = true;
    private boolean showHurryUpMiddleString = false;
    private boolean showHurryUpBottomString = false;
    private boolean timeoutHappened = false;
    private int timeElapsedAfterTimeout = 0;

    private static final Media hurryUpWarning = ResourceLoader.loadSound(FilePath.SoundFilePath.InGame.HurryUpWarning);
    public static final LoopingSound hurryUpMusic = new LoopingSound(ResourceLoader.loadSound(FilePath.SoundFilePath.InGame.HurryUpMusic), AllSettings.userSettings.backgroundMusicVolume);

//    public HurryUpState() {
//        BaseSound.playSound(hurryUpWarning, AllSettings.userSettings.soundEffectVolume);
//        MainGame.gameMusic.stop(BaseSound.fadeoutElapsed);
//        hurryUpMusic.playAfterSetVolume(AllSettings.userSettings.backgroundMusicVolume, BaseSound.fadeinElapsed);
//    }

    public HurryUpState() {

    }

//    public void update() {
//        if (!timeoutHappened) {
//            MainGame.time += AllSettings.userSettings.timeStep;
//            if (MainGame.time > MainGame.matchDuration) {
//                timeoutHappened = true;
//                MainGame.time = MainGame.matchDuration;
//            }
//            RunningGameState.runGame();
//        } else {
//            timeElapsedAfterTimeout += AllSettings.userSettings.timeStep;
//            // needs a delay, draw is game because of timeout
//            if (timeElapsedAfterTimeout > delayAfterTimeout) {
//                MainGame.drawGame = true;
//                MainGame.subscene = new TransitionState();
//            }
//        }
//
//        if (vibrateState) {
//            if (MainGame.time > MainGame.timeoutWarningElapsed + timeoutWarningVibrationElapsed) {  // while vibration ended
//                vibrateState = false;
//                MainGame.vibrateOffsetX = 0;
//                MainGame.vibrateOffsetY = 0;
//                Location.changeOffset(MainGame.vibrateOffsetX, MainGame.vibrateOffsetY);
//            } else {    // while vibration happening
//                MainGame.vibrateOffsetX = vibratingValue - Initialized.random.nextInt((vibratingValue << 1) + 1);
//                MainGame.vibrateOffsetY = vibratingValue - Initialized.random.nextInt((vibratingValue << 1) + 1);
//                Location.changeOffset(MainGame.vibrateOffsetX, MainGame.vibrateOffsetY);
//            }
//            showHurryUpMiddleString = ((MainGame.time - MainGame.timeoutWarningElapsed) % timeoutWarningMiddleStringShowInterval) < timeoutWarningMiddleStringShowInterval_half;
//        } else {
//            showHurryUpBottomString = ((MainGame.time - MainGame.timeoutWarningElapsed) % timeoutWarningBottomStringShowInterval) < timeoutWarningBottomStringShowInterval_half;
//        }
//    }

    public void update() {

    }

//    public void render(Graphics2D g) {
//        if (vibrateState) {
//            if (showHurryUpMiddleString) {
//                g.drawImage(Initialized.gfx.readyGoHurry(2), hurryUpMiddleStringImage_left, hurryUpMiddleStringImage_top, null);
//            }
//        } else if (showHurryUpBottomString) {
//            g.drawImage(hurryUpBottomStringImage, hurryUpBottomStringImage_left, hurryUpBottomStringImage_top, null);
//        }
//    }

    public void render(GraphicsContext graphicsContext) {
        if (vibrateState) {
            if (showHurryUpMiddleString) {

            }
        } else if (showHurryUpBottomString) {

        }
    }
}

package uet.oop.bomberman.Scene;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;


public abstract class GeneralScene extends Scene {

    public GeneralScene(Parent parent) {
        super(parent);
    }

    public GeneralScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public GeneralScene(Parent parent, Paint paint) {
        super(parent, paint);
    }

    public GeneralScene(Parent parent, double v, double v1, Paint paint) {
        super(parent, v, v1, paint);
    }

    public GeneralScene(Parent parent, double v, double v1, boolean b) {
        super(parent, v, v1, b);
    }

    public GeneralScene(Parent parent, double v, double v1, boolean b, SceneAntialiasing sceneAntialiasing) {
        super(parent, v, v1, b, sceneAntialiasing);
    }

    public void update() {
    }

    public void render(GraphicsContext graphicsContext) {
    }



    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }



    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }


//    public void focusGained(FocusEvent e) {
//    }
//
//    public void focusLost(FocusEvent e) {
//    }

    /**
     * This is used for resetting mouse alignment when calling the parent scene that is already constructed.
     */
    public void reset() {
    }
}

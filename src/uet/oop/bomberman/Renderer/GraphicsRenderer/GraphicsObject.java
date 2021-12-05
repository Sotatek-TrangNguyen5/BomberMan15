package uet.oop.bomberman.Renderer.GraphicsRenderer;


import java.awt.*;

/**
 * Created by Arnob on 26/09/2014.
 * This interface creates a common environment for different types of graphic objects.
 */
public interface GraphicsObject {


    double getImageLocationX();

    double getImageLocationY();


    void update();

    void render(Graphics2D g);
}

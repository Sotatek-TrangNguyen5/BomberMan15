package uet.oop.bomberman.Scene;


import javafx.scene.canvas.GraphicsContext;


public interface Subscene {

    void update();

    void render(GraphicsContext g);
}

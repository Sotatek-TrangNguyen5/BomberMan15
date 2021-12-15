package uet.oop.bomberman.Renderer.GraphicsRenderer;


import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * Interface này được dùng để tạo ra một môi trường chung cho tất cả các đối tượng đồ họa
 */
public interface GraphicsObject {


//    RenderingOrder renderingOrder = new RenderingOrder();
//
//    GridLocation getGridLocation();

    double getImageLocationX();

    double getImageLocationY();


    void update();

//    void render(Graphics2D g);

    void render(GraphicsContext g);
}

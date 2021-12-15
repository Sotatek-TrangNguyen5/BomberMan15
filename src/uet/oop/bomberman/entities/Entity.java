//package uet.oop.bomberman.entities;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.paint.Color;
//import uet.oop.bomberman.Renderer.GraphicsRenderer.Animation.PingPong_Animation;
//import uet.oop.bomberman.Renderer.GraphicsRenderer.GraphicsObject;
//import uet.oop.bomberman.Renderer.GraphicsRenderer.Sprite;
//import uet.oop.bomberman.Setup.FilePath;
//import uet.oop.bomberman.Setup.ResourceLoader;
//import uet.oop.bomberman.Setup.Settings.AllSettings;
//
//
///**
// * Lớp đại diện cho tất cả thực thể trong game (Bomber, Enemy, Wall, Brick,...)
// */
//public abstract class Entity implements GraphicsObject {
//
//	protected Position _position = new Position(); // tọa độ x, y tính từ góc trái trên trong canvas
//	protected boolean _removed = false;
//	protected Image img;
//
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 */
//	public Entity( int xUnit, int yUnit, Image img) {
//		this._position.setCoordinateX(xUnit * Sprite.SCALED_SIZE);
//		this._position.setCoordinateY(yUnit * Sprite.SCALED_SIZE);
//		this.img = img;
//	}
//
//	/**
//	 * Phương thức này được gọi liên tục trong vòng lặp game,
//	 * mục đích để xử lý sự kiện và cập nhật trạng thái Entity
//	 */
//	@Override
//	public abstract void update();
//
//	/**
//	 * Phương thức này được gọi liên tục trong vòng lặp game,
//	 * mục đích để cập nhật hình ảnh của entity theo trạng thái
//	 */
//	@Override
//	public void render(GraphicsContext gc) {
//		gc.drawImage(img, _position.getCoordinateX(), _position.getCoordinateY());
//	}
//
//	public void remove() {
//		this._removed = true;
//	}
//
//	public boolean isRemoved() {
//		return _removed;
//	}
//
//	/**
//	 * Phương thức này được gọi để xử lý khi hai entity va chạm vào nhau
//	 */
//	public abstract boolean collide(Entity e);
//
//	public double getX() {
//		return _position.getCoordinateX();
//	}
//
//	public double getY() {
//		return _position.getCoordinateY();
//	}
//
//	public Position get_position() {
//		return _position;
//	}
//
////	public int getXTile() {
////		return Coordinates.pixelToTile(_position.getCoordinateX() + (double) Sprite.DEFAULT_SIZE / 2);
////	}
////
////	public int getYTile() {
////		return Coordinates.pixelToTile(_position.getCoordinateY() - (double) Sprite.DEFAULT_SIZE / 2);
////	}
//
//
//
//
//
//
//
//}


package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Renderer.GraphicsRenderer.Sprite;

public abstract class Entity {

	//Tọa độ X tính từ góc trái trên trong Canvas
	protected int x;

	//Tọa độ Y tính từ góc trái trên trong Canvas
	protected int y;

	protected Image img;

	//Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
	public Entity( int xUnit, int yUnit, Image img) {
		this.x = xUnit * Sprite.SCALED_SIZE;
		this.y = yUnit * Sprite.SCALED_SIZE;
		this.img = img;
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(img, x, y);
	}

	public abstract void update();
}


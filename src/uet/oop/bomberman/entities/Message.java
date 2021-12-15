//package uet.oop.bomberman.entities;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.graphics.Screen;
//
//import java.awt.*;
//
///**
// * Hiển thị thông điệp
// */
//public class Message extends Entity {
//
//	protected String _message;
//	protected int _duration;
//	protected Color _color;
//	protected int _size;
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 */
//	public Message(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
//	/**
//	 * Hiển thị message khi tiêu diệt được Enemy ví dụ (+100)
//	 */
////	public Message(String message, double x, double y, int duration, Color color, int size) {
////		this._position.setCoordinateX(x);
////		this._position.setCoordinateY(y);
////		this._message = message;
////		this._duration = duration * 60; //seconds
////		this._color = color;
////		this._size = size;
////	}
//
//	public int getDuration() {
//		return _duration;
//	}
//
//	public void setDuration(int _duration) {
//		this._duration = _duration;
//	}
//
//	public String getMessage() {
//		return _message;
//	}
//
//	public Color getColor() {
//		return _color;
//	}
//
//	public int getSize() {
//		return _size;
//	}
//
//	@Override
//	public void update() {
//	}
//
////	@Override
////	public void render(Screen screen) {
////	}
//
//	@Override
//	public void render(GraphicsContext graphicsContext) {
//
//	}
//
//	@Override
//	public boolean collide(Entity e) {
//		return true;
//	}
//
//
//}

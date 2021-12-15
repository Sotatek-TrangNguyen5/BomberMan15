//package uet.oop.bomberman.entities.Location;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.graphics.Screen;
//import uet.oop.bomberman.graphics.Sprite;
//import uet.oop.bomberman.level.Coordinates;
//
///**
// * Entity cố định, không di chuyển
// */
//public abstract class Tile extends Entity {
//
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 */
//	public Tile(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public Tile(int x, int y, Sprite sprite) {
////		this._position.setCoordinateX(x);
////		this._position.setCoordinateY(y);
////		_sprite = sprite;
////	}
//
//	/**
//	 * Mặc định không cho bất cứ một đối tượng nào đi qua
//	 */
//	@Override
//	public boolean collide(Entity e) {
//		return true;
//	}
//
////	@Override
////	public void render(Screen screen) {
////		screen.renderEntity( Coordinates.tileToPixel(_position.getCoordinateX()), Coordinates.tileToPixel(_position.getCoordinateY()), this);
////	}
//
//	@Override
//	public void render(GraphicsContext graphicsContext) {
//
//	}
//
//	@Override
//	public void update() {}
//}

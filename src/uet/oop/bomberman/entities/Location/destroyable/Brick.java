//package uet.oop.bomberman.entities.Location.destroyable;
//
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.graphics.Screen;
//import uet.oop.bomberman.graphics.Sprite;
//import uet.oop.bomberman.level.Coordinates;
//
//public class Brick extends DestroyableTile {
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 *
//	 * @param xUnit
//	 * @param yUnit
//	 * @param img
//	 */
//	public Brick(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public Brick(int x, int y, Sprite sprite) {
////		super(x, y, sprite);
////	}
//
//	@Override
//	public void update() {
//		super.update();
//	}
//
////	@Override
////	public void render(Screen screen) {
////		int x = Coordinates.tileToPixel(_position.getCoordinateX());
////		int y = Coordinates.tileToPixel(_position.getCoordinateY());
////
////		if(_destroyed) {
////			_sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
////
////			screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
////		}
////		else
////			screen.renderEntity( x, y, this);
////	}
//
//	@Override
//	public void render(GraphicsContext graphicsContext) {
//
//	}
//
//}

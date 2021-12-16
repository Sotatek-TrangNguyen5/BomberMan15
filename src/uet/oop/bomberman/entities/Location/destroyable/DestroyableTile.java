//package uet.oop.bomberman.entities.Location.destroyable;
//
//import javafx.scene.image.Image;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.entities.bomb.Flame;
//import uet.oop.bomberman.entities.Location.Tile;
//import uet.oop.bomberman.graphics.Sprite;
//
///**
// * Đối tượng cố định có thể bị phá hủy
// */
//public class DestroyableTile extends Tile {
//
//	private final int MAX_ANIMATE = 7500;
//	private int _animate = 0;
//	protected boolean _destroyed = false;
//	protected int _timeToDisapear = 20;
//	protected Sprite _belowSprite = Sprite.grass;
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 *
//	 * @param xUnit
//	 * @param yUnit
//	 * @param img
//	 */
//	public DestroyableTile(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public DestroyableTile(int x, int y, Sprite sprite) {
////		super(x, y, sprite);
////	}
//
//	@Override
//	public void update() {
//		if(_destroyed) {
//			if(_animate < MAX_ANIMATE) _animate++; else _animate = 0;
//			if(_timeToDisapear > 0)
//				_timeToDisapear--;
//			else
//				remove();
//		}
//	}
//
//	public void destroy() {
//		_destroyed = true;
//	}
//
//	@Override
//	public boolean collide(Entity e) {
//		// TODO: xử lý khi va chạm với Flame
//		if (e instanceof Flame){
//			this.destroy();
//		}
//		return true;
//	}
//
//	public void addBelowSprite(Sprite sprite) {
//		_belowSprite = sprite;
//	}
//
//	protected Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2) {
//		int calc = _animate % 30;
//
//		if(calc < 10) {
//			return normal;
//		}
//
//		if(calc < 20) {
//			return x1;
//		}
//
//		return x2;
//	}
//
//}

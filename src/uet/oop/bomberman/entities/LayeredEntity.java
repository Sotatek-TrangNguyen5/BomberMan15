//package uet.oop.bomberman.entities;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.graphics.Screen;
//
//import java.util.LinkedList;
//
///**
// * Chứa và quản lý nhiều Entity tại cùng một vị trí
// * Ví dụ: tại vị trí dấu Item, có 3 Entity [Grass, Item, Brick]
// */
//public class LayeredEntity extends Entity {
//
//	protected LinkedList<Entity> _entities = new LinkedList<>();
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 *
//	 * @param xUnit
//	 * @param yUnit
//	 * @param img
//	 */
//	public LayeredEntity(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public LayeredEntity(int x, int y, Entity ... entities) {
////		this._position.setCoordinateX(x);
////		this._position.setCoordinateY(y);
////
////		for (int i = 0; i < entities.length; i++) {
////			_entities.add(entities[i]);
////
////			if(i > 1) {
////				if(entities[i] instanceof DestroyableTile)
////					((DestroyableTile)entities[i]).addBelowSprite(entities[i-1].getSprite());
////			}
////		}
////	}
//
//	@Override
//	public double getImageLocationX() {
//		return 0;
//	}
//
//	@Override
//	public double getImageLocationY() {
//		return 0;
//	}
//
//	@Override
//	public void update() {
//		clearRemoved();
//		getTopEntity().update();
//	}
//
//	@Override
//	public void render(GraphicsContext graphicsContext) {
//		getTopEntity().render(graphicsContext);
//	}
//
//	public Entity getTopEntity() {
//
//		return _entities.getLast();
//	}
//
//	private void clearRemoved() {
//		Entity top  = getTopEntity();
//
//		if(top.isRemoved())  {
//			_entities.removeLast();
//		}
//	}
//
//	public void addTop(Entity e){
//		_entities.add(e);
//	}
//
//	public void addBeforeTop(Entity e) {
//		_entities.add(_entities.size() - 1, e);
//	}
//
//	@Override
//	public boolean collide(Entity e) {
//		return this.getTopEntity().collide(e);
//	}
//
//}

//package uet.oop.bomberman.entities.Location.item;
//
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Game;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.entities.character.Bomber.Bomber;
//import uet.oop.bomberman.graphics.Sprite;
//
//public class BombItem extends Item {
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 *
//	 * @param xUnit
//	 * @param yUnit
//	 * @param img
//	 */
//	public BombItem(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public BombItem(int x, int y, Sprite sprite) {
////		super(x, y, sprite);
////	}
//
//	@Override
//	public boolean collide(Entity e) {
//		// TODO: xử lý Bomber ăn Item
//		if (e instanceof Bomber){
//			Game.addBombRate(2);
//			this.remove();
//		}
//		return false;
//	}
//
//
//
//}

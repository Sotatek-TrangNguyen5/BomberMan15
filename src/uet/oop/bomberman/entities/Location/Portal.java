//package uet.oop.bomberman.entities.Location;
//
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Board;
//import uet.oop.bomberman.Game;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.entities.character.Bomber.Bomber;
//import uet.oop.bomberman.graphics.Sprite;
//
//public class Portal extends Tile {
//	Board _board;
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 */
//	public Portal(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
////	public Portal(int x, int y, Sprite sprite, Board board) {
////		super(x, y, sprite);
////		_board = board;
////	}
//
//	@Override
//	public boolean collide(Entity e) {
//		// TODO: xử lý khi Bomber đi vào
//		if (e instanceof Bomber && Game.getNumberOfEnemy()==0 ){
//			_board.nextLevel();
//		}
//		return false;
//	}
//
//}

//package uet.oop.bomberman.entities;
//
//import javafx.scene.image.Image;
//
///**
// * Entity có hiệu ứng hoạt hình
// */
//public abstract class AnimatedEntity extends Entity {
//
//	protected int _animate = 0;
//	protected final int MAX_ANIMATE = 7500;
//
//	/**
//	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//	 */
//	public AnimatedEntity(int xUnit, int yUnit, Image img) {
//		super(xUnit, yUnit, img);
//	}
//
//	protected void animate() {
//		if(_animate < MAX_ANIMATE) _animate++; else _animate = 0;
//	}
//
//
//}

package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.IRender;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.level.Coordinates;

/**
 * Lớp đại diện cho tất cả thực thể trong game (Bomber, Enemy, Wall, Brick,...)
 */
public abstract class Entity implements IRender {

	protected Position _position = new Position();
	protected boolean _removed = false;
	protected Sprite _sprite;

	/**
	 * Phương thức này được gọi liên tục trong vòng lặp game,
	 * mục đích để xử lý sự kiện và cập nhật trạng thái Entity
	 */
	@Override
	public abstract void update();

	/**
	 * Phương thức này được gọi liên tục trong vòng lặp game,
	 * mục đích để cập nhật hình ảnh của entity theo trạng thái
	 */
	@Override
	public abstract void render(Screen screen);
	
	public void remove() {
		_removed = true;
	}
	
	public boolean isRemoved() {
		return _removed;
	}
	
	public Sprite getSprite() {
		return _sprite;
	}

	/**
	 * Phương thức này được gọi để xử lý khi hai entity va chạm vào nhau
	 */
	public abstract boolean collide(Entity e);
	
	public double getX() {
		return _position.getCoordinateX();
	}
	
	public double getY() {
		return _position.getCoordinateY();
	}

	public Position get_position() {
		return _position;
	}
	
	public int getXTile() {
		return Coordinates.pixelToTile(_position.getCoordinateX() + (double) _sprite.getSize() / 2);
	}
	
	public int getYTile() {
		return Coordinates.pixelToTile(_position.getCoordinateY() - (double) _sprite.getSize() / 2);
	}
}

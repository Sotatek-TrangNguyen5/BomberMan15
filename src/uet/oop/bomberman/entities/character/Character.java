package uet.oop.bomberman.entities.character;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.graphics.Screen;

/**
 * Bao gồm Bomber và Enemy
 */
public abstract class Character extends AnimatedEntity {
	
	protected Board _board;
	protected int _direction = -1;
	protected boolean _alive = true;
	protected boolean _moving = false;
	public int _timeAfter = 40;
	private int _speed = 4;
	
	public Character(int x, int y, Board board) {
		this._position.setCoordinateX(x);
		this._position.setCoordinateY(y);
		this._board = board;
	}
	
	@Override
	public abstract void update();
	
	@Override
	public abstract void render(Screen screen);

	/**
	 * Tính toán hướng đi
	 */
	protected abstract void calculateMove();
	
	protected abstract void move(double xa, double ya);

	/**
	 * Được gọi khi đối tượng bị tiêu diệt
	 */
	public abstract void kill();

	/**
	 * Xử lý hiệu ứng bị tiêu diệt
	 */
	protected abstract void afterKill();

	/**
	 * Kiểm tra xem đối tượng có di chuyển tới vị trí đã tính toán hay không
	 */
	protected abstract boolean canMove(double nextX, double nextY);

	protected double getXMessage() {
		return (_position.getCoordinateX() * Game.SCALE) + ((double) _sprite.getSize() / 2 * Game.SCALE);
	}
	
	protected double getYMessage() {
		return (_position.getCoordinateY() * Game.SCALE) - ((double) _sprite.getSize() / 2 * Game.SCALE);
	}

	public void setSpeed(int speed) {
		this._speed = speed;
	}
	
}

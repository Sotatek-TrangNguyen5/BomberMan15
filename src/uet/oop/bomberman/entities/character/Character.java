package uet.oop.bomberman.entities.character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import uet.oop.bomberman.Renderer.GraphicsRenderer.Animation.PingPong_Animation;
import uet.oop.bomberman.Setup.FilePath;
import uet.oop.bomberman.Setup.ResourceLoader;
import uet.oop.bomberman.Setup.Settings.AllSettings;
import uet.oop.bomberman.entities.Entity;

/**
 * Bao gồm Bomber và Enemy
 */
public abstract class Character extends Entity {

	protected int _direction = -1;
	protected boolean _alive = true;
	protected boolean _moving = false;
	public int _timeAfter = 40;
	private int _speed = 4;

//	private GridLocation gridLocation;
//	private Direction direction = Direction.Down;

	private static final int maxBombCounter = 4;
	private int bombCounter = 0;

	private Image image;
	private double imageLocationX;
	private double imageLocationY;
	private PingPong_Animation playerAnimation;

//	private static final int imageLocationY_offset = GfxFromFile.gridWidth - GfxFromFile.playerHeight;

	protected static final double moveStep = 2 * AllSettings.userSettings.motionConst;
	private static final double animateStep = 0.4 * AllSettings.userSettings.motionConst;

	//	protected static final Direction[] directionList = Direction.valuesCached();
	protected static final int[][] directionStep = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

	private static final int idleAnimateElapsed = 3000;
	private static final int idleDownDirectionElapsed = 3000;
	private static final int idleEyeBlinkedElapsed = 100;
	private static final int idleEyeBlinkGapElapsed = 200;
	private static final int idleEyeBlinkTime = 3;

	private static final double killedAnimateStepCoefficient = 0.2;
	private static final int deathTimeElapsed = 500;
	private static final int deathVanishTimeElapsed = 70;
	private static final int deathVanishGapTimeElapsed = 100;
	private static final int deathVanishingTime = 5;

	private static final double motionStep = 40 * AllSettings.userSettings.motionConst;
	private int lastAnimatedTime = 0;
	private boolean inIdleMode = false;
	private int idleDownDirectionStarted = 0;
	private static final int idleEyeBlinkInterval = idleEyeBlinkedElapsed + idleEyeBlinkGapElapsed;

	private static final int deathVanishInterval = deathVanishTimeElapsed + deathVanishGapTimeElapsed;
	private boolean killed = false;
	private boolean death = false;
	private int deathStarted = 0;
	private boolean deathVanishing = false;


	protected byte inputData = 0x00;
    /*
    inputData will be used both for data transmission and player's input calculation.
	This variable has no use in NetworkPlayer.
	inputData can be:       0        0        0        1        0        0        1        0
	that means:             N/A      N/A      N/A      Fire     Up       Right    Left     Down
	*/


	private static final int vibratingValueWhenKilled = (int) (2 * AllSettings.userSettings.motionConst);
	private static final long dyingSoundReverberationDelay = 200;
	private static final double dyingSoundReverberationVolumeFactor = 0.5;

	private static final MediaPlayer walkingSound = new MediaPlayer(ResourceLoader.loadSound(FilePath.SoundFilePath.InGame.WalkingSound));
	private static final Media dyingSound = ResourceLoader.loadSound(FilePath.SoundFilePath.InGame.DyingSound);
	static {
		walkingSound.setOnEndOfMedia(walkingSound::stop);
	}

	/**
	 * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
	 */
	public Character(int xUnit, int yUnit, Image img) {
		super(xUnit, yUnit, img);
	}

//	public Character(int x, int y, Board board) {
//		this._position.setCoordinateX(x);
//		this._position.setCoordinateY(y);
//		this._board = board;
//	}
	
	@Override
	public abstract void update();
	
//	@Override
//	public abstract void render(Screen screen);

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

//	protected double getXMessage() {
//		return (_position.getCoordinateX() * Game.SCALE) + ((double) _sprite.getSize() / 2 * Game.SCALE);
//	}
//
//	protected double getYMessage() {
//		return (_position.getCoordinateY() * Game.SCALE) - ((double) _sprite.getSize() / 2 * Game.SCALE);
//	}

	public void setSpeed(int speed) {
		this._speed = speed;
	}



//	private void PlayerDestructor(Iterator iterator) {
//		iterator.remove();
//		MainGame.thisPC_controlledPlayerList.remove(this);
//		MainGame.inputControllersList.remove(this);
//		MainGame.ai_Players.remove(this);
//		MainGame.playerStatusList.get(color.ordinal()).setStatus(Status.Killed);
//	}


//	public GridLocation getGridLocation() {
//		return gridLocation;
//	}

	public double getImageLocationX() {
		return imageLocationX;
	}

	public double getImageLocationY() {
		return imageLocationY;
	}


//	public void update(Iterator iterator) {
//		// death
//		if (killed) {
//			animateMove();
//			vibrateWhenKilled();
//			if (death) {
//				deathStarted += motionStep;
//				if (deathVanishing) {
//					if (deathStarted / deathVanishInterval > deathVanishingTime) {
//						resetVibrationAfterDeath();
//						PlayerDestructor(iterator);
//					} else {
//						int deathElapsed = deathStarted % deathVanishInterval;
//						// vanished
//						if (deathElapsed < deathVanishTimeElapsed) {
//							image = Initialized.gfx.nullImage();
//						}
//						// gap after a vanish
//						else {
//							image = Initialized.gfx.playerDeath(color, 3);
//						}
//					}
//				} else if (deathStarted > deathTimeElapsed) {
//					deathVanishing = true;
//					image = Initialized.gfx.nullImage();
//					deathStarted = 0;
//				}
//			} else {
//				if (playerAnimation.getAnimateValue() == 3) death = true;
//				image = Initialized.gfx.playerDeath(color, playerAnimation.getAnimateValue());
//			}
//			return;
//		}
//		// checking state (moving or idle)
//		if (lastAnimatedTime < idleAnimateElapsed) {
//			lastAnimatedTime += motionStep;
//			image = Initialized.gfx.player(color, direction, playerAnimation.getAnimateValue());
//			return;
//		}
//		// idle mode (eye blinking)
//		idleDownDirectionStarted += motionStep;
//		if (inIdleMode) {
//			int idleModeElapsed = idleDownDirectionStarted;
//			// checking idle mode state (standing or eye blinking)
//			if (idleModeElapsed > idleDownDirectionElapsed) {
//				idleModeElapsed -= idleDownDirectionElapsed;
//				// standing state finishing
//				if ((double) idleModeElapsed / idleEyeBlinkInterval > idleEyeBlinkTime) {
//					image = Initialized.gfx.player(color, Direction.Down, 1);
//					idleDownDirectionStarted = 0;
//				}
//				// eye blinking state
//				else {
//					int eyeBlinkElapsed = idleModeElapsed % idleEyeBlinkInterval;
//					// eye closed
//					if (eyeBlinkElapsed < idleEyeBlinkedElapsed) {
//						image = Initialized.gfx.playerIdle(color);
//					}
//					// eye opened
//					else {
//						image = Initialized.gfx.player(color, Direction.Down, 1);
//					}
//				}
//			}
//			return;
//		}
//		// idle mode started
//		image = Initialized.gfx.player(color, Direction.Down, 1);
//		idleDownDirectionStarted = 0;
//		inIdleMode = true;
//	}





//	public Direction getDirection() {
//		return direction;
//	}
	
}

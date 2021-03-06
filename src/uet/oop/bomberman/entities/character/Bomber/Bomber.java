//package uet.oop.bomberman.entities.character.Bomber;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Game;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.entities.bomb.Bomb;
//import uet.oop.bomberman.entities.bomb.Flame;
//import uet.oop.bomberman.entities.character.Character;
//import uet.oop.bomberman.entities.character.enemy.Enemy;
//import uet.oop.bomberman.graphics.Screen;
//import uet.oop.bomberman.input.Keyboard;
//import uet.oop.bomberman.level.Coordinates;
//
//import java.util.Iterator;
//import java.util.List;
//
//public class Bomber extends Character {
//
//    private List<Bomb> _bombs;
//    protected Keyboard _input;
//
//    /**
//     * nếu giá trị này < 0 thì cho phép đặt đối tượng Bomb tiếp theo,
//     * cứ mỗi lần đặt 1 Bomb mới, giá trị này sẽ được reset về 0 và giảm dần trong mỗi lần update()
//     */
//    protected int _timeBetweenPutBombs = 0;
//
//    /**
//     * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//     */
//    public Bomber(int xUnit, int yUnit, Image img) {
//        super(xUnit, yUnit, img);
//    }
//
////    public Bomber(int x, int y, Board board) {
////        super(x, y, board);
////        this._bombs = _board.getBombs();
////        this._input = _board.getInput();
////        this._sprite = Sprite.player_right;
////    }
//
//    @Override
//    public void update() {
////        clearBombs();
//        if (!_alive) {
//            afterKill();
//            return;
//        }
//
//        if (_timeBetweenPutBombs < -7500) _timeBetweenPutBombs = 0;
//        else _timeBetweenPutBombs--;
//
////        animate();
//
//        calculateMove();
//
//        detectPlaceBomb();
//    }
//
//    @Override
//    public void render(Screen screen) {
//        calculateXOffset();
//
//        if (_alive)
//            chooseSprite();
//        else
//            _sprite = Sprite.player_dead1;
//
//        screen.renderEntity((int) _position.getCoordinateX(), (int) _position.getCoordinateY() - _sprite.getSize(), this);
//    }
//
//    @Override
//    public void render(GraphicsContext graphicsContext) {
//
//    }
//
//
//    public void calculateXOffset() {
//        int xScroll = Screen.calculateXOffset(_board, this);
//        Screen.setOffset(xScroll, 0);
//    }
//
//    /**
//     * Kiểm tra xem có đặt được bom hay không? nếu có thì đặt bom tại vị trí hiện tại của Bomber
//     */
//    private void detectPlaceBomb() {
//        // TODO: kiểm tra xem phím điều khiển đặt bom có được gõ và giá trị _timeBetweenPutBombs, Game.getBombRate() có thỏa mãn hay không
//        // TODO:  Game.getBombRate() sẽ trả về số lượng bom có thể đặt liên tiếp tại thời điểm hiện tại
//        // TODO: _timeBetweenPutBombs dùng để ngăn chặn Bomber đặt 2 Bomb cùng tại 1 vị trí trong 1 khoảng thời gian quá ngắn
//        // TODO: nếu 3 điều kiện trên thỏa mãn thì thực hiện đặt bom bằng placeBomb()
//        // TODO: sau khi đặt, nhớ giảm số lượng Bomb Rate và reset _timeBetweenPutBombs về 0
//        int bombRate = Game.getBombRate();
//        if (_input.space && bombRate > 0 && this._timeBetweenPutBombs < 0) {
//            Game.addBombRate(-1);
//            this._timeBetweenPutBombs = Game.TIME_BETWEEN_PLACE_BOMB;
//            this.placeBomb(Coordinates.pixelToTile(this._position.getCoordinateX() + (double) Game.TILES_SIZE / 2), Coordinates.pixelToTile(this._position.getCoordinateY() - (double) Game.TILES_SIZE / 2));
//        }
//
//    }
//
//    protected void placeBomb(int x, int y) {
//        // TODO: thực hiện tạo đối tượng bom, đặt vào vị trí (x, y)
//        Bomb bome = new Bomb(x, y, _board);
//        this._board.addBomb(bome);
//
//
//    }
//
//    private void clearBombs() {
//        Iterator<Bomb> bs = _bombs.iterator();
//
//        Bomb b;
//        while (bs.hasNext()) {
//            b = bs.next();
//            if (b.isRemoved()) {
//                bs.remove();
//                Game.addBombRate(1);
//            }
//        }
//
//    }
//
//    @Override
//    public void kill() {
//        if (!_alive) return;
////        SoundEffect.GHOST.stop();
//        _alive = false;
//    }
//
//    @Override
//    protected void afterKill() {
//        if (_timeAfter > 0) --_timeAfter;
//        else {
//            _board.endGame();
//        }
//    }
//
//    @Override
//    protected void calculateMove() {
//
//        double x = this._position.getCoordinateX();
//        double y = this._position.getCoordinateY();
//
//        if (_input.up) {
//            y -= Game.getBomberSpeed();
//            this._direction = 0;
//
//        }
//
//        if (_input.right) {
//            x += Game.getBomberSpeed();
//            this._direction = 1;
//        }
//
//        if (_input.down) {
//            y += Game.getBomberSpeed();
//            this._direction = 2;
//
//
//        }
//
//        if (_input.left) {
//            x -= Game.getBomberSpeed();
//            this._direction = 3;
//        }
//
//        this._moving = _input.right || _input.up || _input.down || _input.left;
//
//
//        this.move(x, y);
//
//
//    }
//
//    @Override
//    public boolean canMove(double x, double y) {
//        // TODO: kiểm tra có đối tượng tại vị trí chuẩn bị di chuyển đến và có thể di chuyển tới đó hay không
//
//        // I created 2 point to determine which block ahead bomber man, in case of bomber man in the middle of 2 block
//        // The block ahead bomber man depend on the direction
//
//
//        double dependedDirectionX1 = x;
//        double dependedDirectionY1 = y;
//
//        double dependedDirectionX2 = x;
//        double dependedDirectionY2 = y;
//
//        switch (this._direction) {
//
//            case 0: {
//                dependedDirectionX1 += 1;
//                dependedDirectionY1 -= Game.getCharacterWidth();
//                dependedDirectionX2 += Game.getCharacterWidth() - 1;
//                dependedDirectionY2 -= Game.getCharacterHeight();
//                break;
//            }
//
//            case 1: {
//                dependedDirectionX1 += Game.getCharacterWidth();
//                dependedDirectionY1 -= Game.getCharacterHeight() - 1;
//                dependedDirectionX2 += Game.getCharacterWidth();
//                dependedDirectionY2 -= 1;
//                break;
//            }
//
//            case 2: {
//                dependedDirectionX1 += 1;
//                dependedDirectionY1 -= 1;
//                dependedDirectionX2 += Game.getCharacterWidth() - 1;
//                dependedDirectionY2 -= 1;
//                break;
//            }
//
//            case 3: {
//                dependedDirectionY1 -= 1;
//                dependedDirectionY2 -= Game.getCharacterHeight() - 1;
//                break;
//            }
//
//            default: {
//                break;
//            }
//        }
//
//
//        Entity entity1 = _board.getEntity(Coordinates.pixelToTile(dependedDirectionX1), Coordinates.pixelToTile(dependedDirectionY1), this);
//        Entity entity2 = _board.getEntity(Coordinates.pixelToTile(dependedDirectionX2), Coordinates.pixelToTile(dependedDirectionY2), this);
//        Entity currentEntity = _board.getBombAt(Coordinates.pixelToTile(_position.getCoordinateX()), Coordinates.pixelToTile(_position.getCoordinateY() - 1));
//
//        if (currentEntity == null) {
//            return !(entity1.collide(this) || entity2.collide(this));
//        }
//        return !(entity1.collide(this) || entity2.collide(this) || currentEntity.collide(this));
//    }
//
//    @Override
//    public void move(double xa, double ya) {
//
//        if (this.canMove(xa, ya) && _alive) {
//            this._position.setCoordinateX(xa);
//            this._position.setCoordinateY(ya);
//        }
//        else {
//            for (int i = 0; i < Game.getBomberSpeed(); i++) {
//                switch (this._direction) {
//                    case 0: {
//                        ya++;
//                        break;
//                    }
//                    case 1: {
//                        xa--;
//                        break;
//                    }
//
//                    case 2: {
//                        ya--;
//                        break;
//                    }
//                    case 3: {
//                        xa++;
//                        break;
//                    }
//                }
//                if (this.canMove(xa, ya)) {
//                    this._position.setCoordinateX(xa);
//                    this._position.setCoordinateY(ya);
//                    break;
//                }
//            }
//
//        }
//
//    }
//
//    @Override
//    public boolean collide(Entity e) {
//        // TODO: xử lý va chạm với Flame
//        // TODO: xử lý va chạm với Enemy
//
//        if (e instanceof Flame) {
//            this.kill();
//            return true;
//        }
//
//        if (e instanceof Enemy) {
//            this.kill();
//            return true;
//        }
//
//        return false;
//    }
//
//    private void chooseSprite() {
//        switch (_direction) {
//            case 0:
//                _sprite = Sprite.player_up;
//                if (_moving) {
//                    _sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
//                }
//                break;
//            case 2:
//                _sprite = Sprite.player_down;
//                if (_moving) {
//                    _sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, _animate, 20);
//                }
//                break;
//            case 3:
//                _sprite = Sprite.player_left;
//                if (_moving) {
//                    _sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, _animate, 20);
//                }
//                break;
//            default:
//                _sprite = Sprite.player_right;
//                if (_moving) {
//                    _sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
//                }
//                break;
//        }
//    }
//}

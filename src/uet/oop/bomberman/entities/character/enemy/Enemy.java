//package uet.oop.bomberman.entities.character.enemy;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Game;
//import uet.oop.bomberman.Renderer.GraphicsRenderer.Sprite;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.entities.bomb.Flame;
//import uet.oop.bomberman.entities.character.Bomber.Bomber;
//import uet.oop.bomberman.entities.character.Character;
//import uet.oop.bomberman.entities.character.enemy.ai.AI;
//import uet.oop.bomberman.graphics.Sprite;
//import uet.oop.bomberman.level.Coordinates;
//
//public abstract class Enemy extends Character {
//
//    protected int _points;
//
//    protected double _speed;
//    protected AI _ai;
//
//    protected final double MAX_STEPS = 0;
//    protected final double rest = 0;
//    protected double _steps;
//
//    protected int _finalAnimation = 30;
//    protected Sprite _deadSprite;
//
//    /**
//     * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//     */
//    public Enemy(int xUnit, int yUnit, Image img) {
//        super(xUnit, yUnit, img);
//    }
//
////    public Enemy(int x, int y, Board board, Sprite dead, double speed, int points) {
////        super(x, y, board);
////
////        this._points = points;
////        this._speed = speed;
////
////        this.MAX_STEPS = Game.TILES_SIZE / this._speed;
////        this.rest = (this.MAX_STEPS - (int) this.MAX_STEPS) / this.MAX_STEPS;
////        this._steps = this.MAX_STEPS;
////
////        _timeAfter = 20;
////        this._deadSprite = dead;
////        Game.addEnemyCount(1);
////    }
//
//    @Override
//    public void update() {
////        animate();
//        if (!_alive) {
//            afterKill();
//        }
//        else {
//            calculateMove();
//        }
//
//    }
//
////    @Override
////    public void render(Screen screen) {
////
////        if (_alive)
////            chooseSprite();
////        else {
////            if (_timeAfter > 0) {
////                _sprite = this._deadSprite;
////                _animate = 0;
////            } else {
////                _sprite = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 60);
////            }
////
////        }
////
////        screen.renderEntity((int) _position.getCoordinateX(), (int) _position.getCoordinateY() - _sprite.getSize(), this);
////    }
//
//    @Override
//    public void render(GraphicsContext graphicsContext) {
//
//    }
//
//    @Override
//    public void calculateMove() {
//        // TODO: Tính toán hướng đi và di chuyển Enemy theo _ai và cập nhật giá trị cho _direction
//        // TODO: sử dụng canMove() để kiểm tra xem có thể di chuyển tới điểm đã tính toán hay không
//        // TODO: sử dụng move() để di chuyển
//        // TODO: nhớ cập nhật lại giá trị cờ _moving khi thay đổi trạng thái di chuyển
//
//        double x = this._position.getCoordinateX();
//        double y = this._position.getCoordinateY();
//        if (this._steps <= 0){
//            this._steps = this.MAX_STEPS;
//            this._direction = _ai.calculateDirection();
//        }
//        this._steps--;
//
//        switch (this._direction) {
//            case 0: {
//                y -= this._speed;
//                break;
//            }
//            case 1: {
//                x += this._speed;
//                break;
//            }
//            case 2: {
//                y += this._speed;
//                break;
//            }
//            case 3: {
//                x -= this._speed;
//                break;
//            }
//            default: {
//                break;
//            }
//        }
//        this.move(x, y);
//    }
//
//    @Override
//    public void move(double xa, double ya) {
//        if (_alive && this.canMove(xa, ya)) {
//            this._position.setCoordinateY(ya);
//            this._position.setCoordinateX(xa);
//        }
//    }
//
//    @Override
//    public boolean canMove(double nextX, double nextY) {
//        // TODO: kiểm tra có đối tượng tại vị trí chuẩn bị di chuyển đến và có thể di chuyển tới đó hay không
//        double dependedDirectionX1 = nextX;
//        double dependedDirectionY1 = nextY;
//
//        double dependedDirectionX2 = nextX;
//        double dependedDirectionY2 = nextY;
//
//        switch (this._direction) {
//
//            case 0: {
//                dependedDirectionX1 += 1;
//                dependedDirectionY1 -= Game.TILES_SIZE;
//                dependedDirectionX2 += Game.TILES_SIZE - 1;
//                dependedDirectionY2 -= Game.TILES_SIZE;
//                break;
//            }
//
//            case 1: {
//                dependedDirectionX1 += Game.TILES_SIZE;
//                dependedDirectionY1 -= Game.TILES_SIZE - 1;
//                dependedDirectionX2 += Game.TILES_SIZE;
//                dependedDirectionY2 -= 1;
//                break;
//            }
//
//            case 2: {
//                dependedDirectionX1 += 1;
//                dependedDirectionY1 -= 1;
//                dependedDirectionX2 += Game.TILES_SIZE - 1;
//                dependedDirectionY2 -= 1;
//                break;
//            }
//
//            case 3: {
//                dependedDirectionY1 -= 1;
//                dependedDirectionY2 -= Game.TILES_SIZE - 1;
//                break;
//            }
//
//            default: {
//                break;
//            }
//        }
//
//
////        Entity entity1 = _board.getEntity(Coordinates.pixelToTile(dependedDirectionX1), Coordinates.pixelToTile(dependedDirectionY1), this);
////        Entity entity2 = _board.getEntity(Coordinates.pixelToTile(dependedDirectionX2), Coordinates.pixelToTile(dependedDirectionY2), this);
//
//        return !(entity1.collide(this) || entity2.collide(this));
//    }
//
//    @Override
//    public boolean collide(Entity e) {
//        // TODO: xử lý va chạm với Flame
//        // TODO: xử lý va chạm với Bomber
//
//        if (e instanceof Flame) {
//            this.kill();
//            return true;
//        }
//
//        if (e instanceof Bomber) {
//            ((Bomber) e).kill();
//            return true;
//        }
//
//        return false;
//        // Long but easy to understand
//    }
//
//    @Override
//    public void kill() {
//        if (!_alive) return;
//        _alive = false;
//
//        _board.addPoints(this._points);
//
////        Message msg = new Message("+" + this._points, getXMessage(), getYMessage(), 2, Color.white, 14);
////        _board.addMessage(msg);
//        Game.addEnemyCount(-1);
//    }
//
//
//    @Override
//    protected void afterKill() {
//        if (_timeAfter > 0) --_timeAfter;
//        else {
//            if (this._finalAnimation > 0) --this._finalAnimation;
//            else
//                remove();
//        }
//    }
//
//    protected abstract void chooseSprite();
//}

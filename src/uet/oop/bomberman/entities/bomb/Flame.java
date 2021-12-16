//package uet.oop.bomberman.entities.bomb;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import uet.oop.bomberman.Board;
//import uet.oop.bomberman.entities.Entity;
//import uet.oop.bomberman.entities.Position;
//import uet.oop.bomberman.graphics.Screen;
//
//public class Flame extends Entity {
//
//    protected Board _board;
//    protected int _direction;
//    private int _radius;
//    protected Position _positionOrigin = new Position();
//    protected FlameSegment[] _flameSegments;
//
//    /**
//     * Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
//     */
//    public Flame(int xUnit, int yUnit, Image img) {
//        super(xUnit, yUnit, img);
//    }
//
//    /**
//     * @param x         hoành độ bắt đầu của Flame
//     * @param y         tung độ bắt đầu của Flame
//     * @param direction là hướng của Flame
//     * @param radius    độ dài cực đại của Flame
//     */
////    public Flame(int x, int y, int direction, int radius, Board board) {
////        this._positionOrigin.setCoordinateX(x);
////        this._positionOrigin.setCoordinateY(y);
////        this._position.setCoordinateX(x);
////        this._position.setCoordinateY(y);
////        _direction = direction;
////        _radius = radius;
////        _board = board;
////        createFlameSegments();
////    }
//
//    /**
//     * Tạo các FlameSegment, mỗi segment ứng một đơn vị độ dài
//     */
////    private void createFlameSegments() {
////        /**
////         * tính toán độ dài Flame, tương ứng với số lượng segment
////         */
////        int flameSegmentsLength = calculatePermitedDistance();
////        _flameSegments = new FlameSegment[flameSegmentsLength];
////
////        /**
////         * biến last dùng để đánh dấu cho segment cuối cùng
////         */
////        boolean last;
////
////        // TODO: tạo các segment dưới đây
////
////        int calculatedX = (int) _position.getCoordinateX();
////        int calculatedY = (int) _position.getCoordinateY();
////        for (int i = 0; i < flameSegmentsLength; i++) {
////            switch (_direction) {
////                case 0: {
////                    calculatedY--;
////                    break;
////                }
////                case 1: {
////                    calculatedX++;
////                    break;
////                }
////                case 2: {
////                    calculatedY++;
////                    break;
////                }
////                case 3: {
////                    calculatedX--;
////                    break;
////                }
////                default: {
////                    break;
////                }
////            }
////            _flameSegments[i] = new FlameSegment(calculatedX, calculatedY, _direction, false);
////        }
////
////        // In case of NullPointerException
////
////        if (flameSegmentsLength > 0) {
////            _flameSegments[flameSegmentsLength - 1].setLast(true);
////        }
////    }
//
//    /**
//     * Tính toán độ dài của Flame, nếu gặp vật cản là Brick/Wall, độ dài sẽ bị cắt ngắn
//     */
//    private int calculatePermitedDistance() {
//        // TODO: thực hiện tính toán độ dài của Flame
//        int flameLength = 0;
//        int calculatedX = (int) _position.getCoordinateX();
//        int calculatedY = (int) _position.getCoordinateY();
//        for (; flameLength <= _radius; flameLength++) {
//            switch (_direction) {
//                case 0: {
//                    calculatedY--;
//                    break;
//                }
//                case 1: {
//                    calculatedX++;
//                    break;
//                }
//                case 2: {
//                    calculatedY++;
//                    break;
//                }
//                case 3: {
//                    calculatedX--;
//                    break;
//                }
//                default: {
//                    break;
//                }
//            }
//
//            // Kill character actually here
//            Entity entityAtFlame = _board.getEntity(calculatedX, calculatedY, null);
//            if (entityAtFlame.collide(this)) {
//                break;
//            }
//
//
//        }
//        return flameLength;
//    }
//
//    public FlameSegment flameSegmentAt(int x, int y) {
//        for (FlameSegment flameSegment : _flameSegments) {
//            if (flameSegment.getX() == x && flameSegment.getY() == y)
//                return flameSegment;
//        }
//        return null;
//    }
//
//    @Override
//    public void update() {
//    }
//
////    @Override
////    public void render(Screen screen) {
////        for (FlameSegment flameSegment : _flameSegments) {
////            flameSegment.render(screen);
////        }
////    }
//
//    @Override
//    public void render(GraphicsContext graphicsContext) {
//
//    }
//
//    @Override
//    public boolean collide(Entity e) {
//        // TODO: xử lý va chạm với Bomber, Enemy. Chú ý đối tượng này có vị trí chính là vị trí của Bomb đã nổ
//
//        return true;
//    }
//}

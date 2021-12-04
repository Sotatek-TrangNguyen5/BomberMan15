package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber.Bomber;
import uet.oop.bomberman.entities.character.Character;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.level.Coordinates;
import uet.oop.bomberman.sound.effect.SoundEffect;

import java.util.List;

public class Bomb extends AnimatedEntity {

    protected double _timeToExplode = 120; //2 seconds
    private int _timeAfter = 20;

    protected Board _board;
    protected Flame[] _flames = new Flame[4];
    protected boolean _exploded = false;
    protected boolean _allowedToPassThru = true;

    public Bomb(int x, int y, Board board) {
        this._position.setCoordinateX(x);
        this._position.setCoordinateY(y);
        this._board = board;
        _sprite = Sprite.bomb;
    }

    @Override
    public void update() {
        if (this._timeToExplode > 0)
            this._timeToExplode--;
        else {
            if (!this._exploded)
                explode();
            else
                updateFlames();

            if (this._timeAfter > 0)
                this._timeAfter--;
            else
                remove();
        }

        animate();
    }

    @Override
    public void render(Screen screen) {
        if (this._exploded) {
            _sprite = Sprite.bomb_exploded2;
            renderFlames(screen);
        } else
            _sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);

        int xt = (int) _position.getCoordinateX() << 4;
        int yt = (int) _position.getCoordinateY() << 4;

        screen.renderEntity(xt, yt, this);
    }

    public void renderFlames(Screen screen) {
        for (Flame flame : this._flames) {
            flame.render(screen);
        }
    }

    public void updateFlames() {
        for (Flame flame : this._flames) {
            flame.update();
        }
    }

    /**
     * Xử lý Bomb nổ
     */
    protected void explode() {
        this._exploded = true;

        SoundEffect.EXPLODE.play();
        // TODO: xử lý khi Character đứng tại vị trí Bomb

        List<Character> characterList = this._board._characters;

        for (Character c : characterList) {
            if (c.getXTile() == _position.getCoordinateX() && c.getYTile() == _position.getCoordinateY()) {
                c.kill();
            }
        }
        // TODO: tạo các Flame


        for (int i = 0; i < 4; i++) {
            Flame upFlame = new Flame((int) _position.getCoordinateX(), (int) _position.getCoordinateY(), i, Game.getBombRadius(), this._board);
            this._flames[i] = upFlame;
        }


    }

    public FlameSegment flameAt(int x, int y) {
        if (!this._exploded) return null;

        for (Flame flame : this._flames) {
            if (flame == null) return null;
            FlameSegment e = flame.flameSegmentAt(x, y);
            if (e != null) return e;
        }

        return null;
    }

    @Override
    public boolean collide(Entity e) {
        // TODO: xử lý khi Bomber đi ra sau khi vừa đặt bom (_allowedToPassThru)
        // TODO: xử lý va chạm với Flame của Bomb khác

        if (e instanceof Bomber) {
            double diffX = e.getX() - Coordinates.tileToPixel(_position.getCoordinateX());
            double diffY = e.getY() - Coordinates.tileToPixel(_position.getCoordinateY());
            if (!(diffX >= -Game.getCharacterWidth() && diffX < Game.TILES_SIZE && diffY >= 1 && diffY <= Game.TILES_SIZE)) {
                this._allowedToPassThru = false;
            }

            return !this._allowedToPassThru;
        }


        if (e instanceof Flame) {
            this._timeToExplode = 0;
            return true;
        }
        return true;
    }
}

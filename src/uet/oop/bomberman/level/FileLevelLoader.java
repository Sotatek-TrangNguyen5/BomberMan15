package uet.oop.bomberman.level;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.*;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileLevelLoader extends LevelLoader {

    /**
     * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
     * từ ma trận bản đồ trong tệp cấu hình
     */
    private static char[][] _map;

    public FileLevelLoader(Board board, int level) throws LoadLevelException {
        super(board, level);
    }

    @Override
    public void loadLevel(int level) throws LoadLevelException {

        String levelFilePathName = "/levels/Level" + level + ".txt";
        InputStream in = FileLevelLoader.class.getResourceAsStream(levelFilePathName);
        if (in == null) {
            System.out.println(levelFilePathName);
            throw  new LoadLevelException();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String firstLine;
        String[] levelInfo;
        try {
            firstLine = reader.readLine();
            levelInfo = firstLine.split(" ");
            if (levelInfo.length == 3) {
                this._level = Integer.parseInt(levelInfo[0]);
                this._height = Integer.parseInt(levelInfo[1]);
                this._width = Integer.parseInt(levelInfo[2]);
            } else {
                throw new LoadLevelException("Level is corrupted");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        _map = new char[this._height][this._width];

        try {
            for (int i = 0; i < this._height; i++) {
                String str = reader.readLine();
                System.out.println(str);
                for (int j = 0; j < this._width; j++) {
                    _map[i][j] = str.charAt(j);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new LoadLevelException("Level is corrupted");
        }


        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void createEntities() {


        for (int y = 0; y < this._height; y++) {
            for (int x = 0; x < this._width; x++) {
                int position = y * _width + x;
                switch (_map[y][x]) {

                    case ' ': { // Grass tile
                        _board.addEntity(position, new Grass(x, y, Sprite.grass));
                        break;
                    }

                    case '#': { // Wall tile
                        _board.addEntity(position, new Wall(x, y, Sprite.wall));
                        break;
                    }

                    case '*': { // Brick tile
                        _board.addEntity(position,
                                new LayeredEntity(x, y,
                                        new Grass(x, y, Sprite.grass),
                                        new Brick(x, y, Sprite.brick))
                        );
                        break;
                    }

                    case '1': { // Balloon boy
                        _board.addCharacter(new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                        _board.addEntity(position, new Grass(x, y, Sprite.grass));
                        break;
                    }

                    case '2': { // Oneal
                        _board.addCharacter(new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                        _board.addEntity(position, new Grass(x, y, Sprite.grass));
                        break;
                    }

                    case '3': { // Dahl
                        _board.addCharacter(new Dahl(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                        _board.addEntity(position, new Grass(x, y, Sprite.grass));
                        break;
                    }

                    case 'p': { // Player
                        _board.addCharacter(new Bomber(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
                        Screen.setOffset(0, 0);
                        _board.addEntity(position, new Grass(x, y, Sprite.grass));
                        break;
                    }

                    case 'b': {
                        _board.addEntity(position,
                                new LayeredEntity(
                                        x, y,
                                        new Grass(x, y, Sprite.grass),
                                        new BombItem(x, y, Sprite.powerup_bombs),
                                        new Brick(x, y, Sprite.brick)
                                ));
                        break;
                    }

                    case 'f': { // Flames item
                        _board.addEntity(position,
                                new LayeredEntity(
                                        x, y,
                                        new Grass(x, y, Sprite.grass),
                                        new FlameItem(x, y, Sprite.powerup_flames),
                                        new Brick(x, y, Sprite.brick)
                                ));
                        break;
                    }

                    case 's': { // Speed item
                        _board.addEntity(position,
                                new LayeredEntity(
                                        x, y,
                                        new Grass(x, y, Sprite.grass),
                                        new SpeedItem(x, y, Sprite.powerup_speed),
                                        new Brick(x, y, Sprite.brick)
                                ));
                        break;
                    }

                    case 'x': { // Portal tile
                        _board.addEntity(position, new LayeredEntity(
                                x, y,
                                new Portal(x, y, Sprite.portal, _board),
                                new Brick(x, y, Sprite.brick)
                        ));
                        break;
                    }

                    default: { // Load grass default
                        _board.addEntity(position, new Brick(x, y, Sprite.brick));
                        break;
                    }
                }

            }
        }
    }

}

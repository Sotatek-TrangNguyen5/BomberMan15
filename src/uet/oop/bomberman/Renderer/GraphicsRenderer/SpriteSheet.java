package uet.oop.bomberman.Renderer.GraphicsRenderer;

import uet.oop.bomberman.Setup.FilePath;
import uet.oop.bomberman.Setup.ResourceLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
 * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
 */
public class SpriteSheet {

	private final String _path;
	public final int SIZE_WIDTH;
	public final int SIZE_HEIGHT;
	public final int[] _pixels;
	private BufferedImage image;

	public static SpriteSheet first_tiles = new SpriteSheet(FilePath.GraphicsFilePath.SpriteSheet2, 256, 256);
	public static SpriteSheet second_tiles = new SpriteSheet(FilePath.GraphicsFilePath.SpriteSheet2, 1394, 128);
	
	public SpriteSheet(String path, int width, int height) {
		this._path = path;
		this.SIZE_WIDTH = width;
		this.SIZE_HEIGHT = height;
		_pixels = new int[SIZE_WIDTH * SIZE_HEIGHT];
		load();
	}
	
	private void load() {
		try {
			image = ResourceLoader.loadImage(_path);
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, _pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public int getSIZE_HEIGHT() {
		return SIZE_HEIGHT;
	}

	public int getSIZE_WIDTH() {
		return SIZE_WIDTH;
	}

	public BufferedImage getImage() {
		return image;
	}
}

//package uet.oop.bomberman.graphics;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//
///**
// * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
// * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
// */
//public class SpriteSheet {
//
//	private final String _path;
//	private final int SIZE;
//	private int[] _pixels;
//
//	private static SpriteSheet tiles = new SpriteSheet("/textures/classic.png", 256);
//
//	public SpriteSheet(String path, int size) {
//		this._path = path;
//		this.SIZE = size;
//		this._pixels = new int[SIZE * SIZE];
//		load();
//	}
//
//	private void load() {
//		try {
//			URL a = SpriteSheet.class.getResource(_path);
//			assert a != null;
//			BufferedImage image = ImageIO.read(a);
//			int w = image.getWidth();
//			int h = image.getHeight();
//			image.getRGB(0, 0, w, h, _pixels, 0, w);
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.exit(0);
//		}
//	}
//
//	public int[] get_pixels() {
//		return this._pixels;
//	}
//
//	public int getSIZE() {
//		return this.SIZE;
//	}
//
//	public static SpriteSheet getTiles() {
//		return tiles;
//	}
//}

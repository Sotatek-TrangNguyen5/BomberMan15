package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.Renderer.GraphicsRenderer.Sprite;
import uet.oop.bomberman.Scene.GameScene.MainGame;
import uet.oop.bomberman.Scene.GeneralScene;
import uet.oop.bomberman.Setup.FilePath;
import uet.oop.bomberman.Setup.ResourceLoader;
import uet.oop.bomberman.Setup.Strings;

import java.io.IOException;
import java.util.Random;

public class BombermanGame extends Application {

	public static final int WIDTH = 20;
	public static final int HEIGHT = 15;

	public static GeneralScene scene;
	public static Canvas canvas;
	private static GraphicsContext graphicsContext;

	public static String CreditInfoFromFile;
	static {
		try {
			CreditInfoFromFile = ResourceLoader.loadText(FilePath.InfoFilePath.CreditInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String HowToPlayInfoFromFile;
	static {
		try {
			HowToPlayInfoFromFile = ResourceLoader.loadText(FilePath.InfoFilePath.HowToPlayInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final Group baseLayout = new Group();

	public static final Random random = new Random();

//	    static {
//        baseFrame.setIconImage(Initialized.gfx.appIcon());
//        panel.setBackground(Color.black);
//        panel.setPreferredSize(new Dimension(AllSettings.userSettings.displayWidth, AllSettings.userSettings.displayHeight));
//        panel.setLayout(null);
//
//        // initializing JavaFX for media playback (especially mp3 files)
//        final JFXPanel jfxPanel = new JFXPanel();
//        panel.add(jfxPanel);
//        Platform.runLater(() -> {
//            javafx.scene.Scene scene = new javafx.scene.Scene(new Group());
//            jfxPanel.setScene(scene);
//        });
//    }


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage baseStage) throws Exception {
		baseStage.setTitle(Strings.WindowTitle);
		initialize();
		baseLayout.getChildren().add(BombermanGame.canvas);
		baseStage.setScene(new Scene(baseLayout));
		baseStage.show();
	}

	private static void initialize() {

		/* khởi tạo Canvas */
		canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
		graphicsContext = canvas.getGraphicsContext2D();
//        canvas.setIgnoreRepaint(true);
//        Initialized.panel.add(canvas);
		BombermanGame.baseLayout.getChildren().add(canvas);

//        canvas.addKeyListener(new KeyControl());
//        canvas.addMouseListener(new MouseControl());
//        canvas.addMouseMotionListener(new MouseControl());
//        canvas.addMouseWheelListener(new MouseControl());
//        canvas.addFocusListener(new FocusControl());


//        Initialized.baseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        Initialized.baseFrame.setResizable(false);
//        Initialized.baseFrame.pack();
//        Initialized.baseFrame.setLocationRelativeTo(null);
//        Initialized.baseFrame.setVisible(true);

//        canvas.createBufferStrategy(2);
//        bufferStrategy = canvas.getBufferStrategy();

//        canvas.setFocusTraversalKeysEnabled(false);     // to listen Tab key
//        canvas.requestFocusInWindow();
//        canvas.requestFocus();


		/* Khởi tạo Scene */
		scene = new MainGame(new Group());
	}

	public static boolean running = true;

//	public static void run(GeneralScene firstScene) {
//		scene = firstScene;
//		initializeCanvas();
////        //boolean lowFPS_warningNeverShown = true;
//		while (running) {
//			long beginLoopTime = System.currentTimeMillis();
////            update();   // this should not contain any scene change because it causes "first render, then update" in the new scene
////            render();   // any scene change should be here too because it maintains "first update, then render" in the new scene
//			long waitTime = beginLoopTime + 10 - System.currentTimeMillis();
//			if (waitTime > 0) {
//				try {
//					//System.out.println(waitTime * 100 / AllSettings.userSettings.desiredLoopTime);
//					Thread.sleep(waitTime);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		System.exit(0);
//	}


	private static void update() {
		scene.update();
	}

//    private static void render() {
//        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
//        RenderGraphics.setRenderQuality(g);
//        scene.render(g);
//        g.dispose();
//        bufferStrategy.show();
//    }

	private static void render() {
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		scene.render(graphicsContext);
//        g.dispose();
//        bufferStrategy.show();

	}


//    public static void setDisplayScale(double displayScale) {
//        AllSettings.userSettings.displayScale = displayScale;
//        AllSettings.userSettings.undoDisplayScale = 1.0 / displayScale;
//        AllSettings.userSettings.displayWidth = (int) (displayScale * AllSettings.unscaledWidth);
//        AllSettings.userSettings.displayHeight = (int) (displayScale * AllSettings.unscaledHeight);
//
//        Initialized.panel.setPreferredSize(new Dimension(AllSettings.userSettings.displayWidth, AllSettings.userSettings.displayHeight));
//        canvas.setBounds(0, 0, AllSettings.userSettings.displayWidth, AllSettings.userSettings.displayHeight);
//        Initialized.baseFrame.pack();
//        Initialized.baseFrame.setLocationRelativeTo(null);
//    }
}

package uet.oop.bomberman.Setup;

public class FilePath {

    public static class GraphicsFilePath {
        public static final String SpriteSheet1 = "/Gfx/Gfx.png";
        public static final String SpriteSheet2 = "/Gfx/classic.png";
        public static final String Font = "/Gfx/Font.png";
    }

    public static class SoundFilePath {

        public static final String SoundFolder = "G:\\IdeaProjects\\BomberMan\\res\\Sfx\\";
        public static final String MenuMusic = SoundFolder + "MenuMusic.mp3";
        public static class InGame {
            public static final String GameMusic = SoundFolder + "GameMusic.mp3";

            public static final String ReadyGoSound = SoundFolder + "ReadyGo.mp3";

            public static final String WalkingSound = SoundFolder + "Walking.mp3";

            public static final String CreateBombSound = SoundFolder + "CreateBomb.mp3";
            public static final String ExplosionSound = SoundFolder + "Explosion.mp3";

            public static final String DyingSound = SoundFolder + "Dying.mp3";

            public static final String HurryUpWarning = SoundFolder + "HurryUpWarning.mp3";
            public static final String HurryUpMusic = SoundFolder + "HurryUpMusic.mp3";

            public static final String ResultFoundSound = SoundFolder + "ResultFound.mp3";
            public static final String WinnerMusic = SoundFolder + "Winner.mp3";
            public static final String DrawGameMusic = SoundFolder + "DrawGame.mp3";

            public static final String ChampionMusic = SoundFolder + "Champion.mp3";
        }
    }

    public static class InfoFilePath {
        public static final String InfoFolder = "G:\\IdeaProjects\\BomberMan\\res\\Info\\";

        public static final String CreditInfo = InfoFolder + "Credit.txt";
        public static final String HowToPlayInfo = InfoFolder + "HowToPlay.txt";
    }

}

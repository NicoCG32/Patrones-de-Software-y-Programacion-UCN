package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Video {
        void play();
    }

    public static class HighResolutionVideo implements Video {
        private final String file;

        public HighResolutionVideo(String file) {
            this.file = file;
            System.out.println("Cargando video pesado: " + file);
        }

        public void play() {
            System.out.println("Reproduciendo " + file);
        }
    }

    public static class VirtualVideoProxy implements Video {
        private final String file;
        private HighResolutionVideo realVideo;

        public VirtualVideoProxy(String file) {
            this.file = file;
        }

        public void play() {
            if (realVideo == null) {
                realVideo = new HighResolutionVideo(file);
            }
            realVideo.play();
        }
    }
}

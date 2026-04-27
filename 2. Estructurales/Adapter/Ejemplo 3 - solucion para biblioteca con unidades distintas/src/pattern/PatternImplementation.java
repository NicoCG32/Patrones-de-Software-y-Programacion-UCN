package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface DistanceCalculator {
        double distanceInKilometers(double origin, double destination);
    }

    public static class KilometerAdapter implements DistanceCalculator {
        private final MilesLibrary library;

        public KilometerAdapter(MilesLibrary library) { this.library = library; }

        public double distanceInKilometers(double origin, double destination) {
            return library.distanceInMiles(origin, destination) * 1.60934;
        }
    }

    public static class MilesLibrary {
        public double distanceInMiles(double origin, double destination) { return Math.abs(destination - origin); }
    }
}

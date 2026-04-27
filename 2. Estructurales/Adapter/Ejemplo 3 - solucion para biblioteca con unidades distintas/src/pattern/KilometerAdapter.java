package pattern;

public class KilometerAdapter implements DistanceCalculator {
    private final MilesLibrary library;

    public KilometerAdapter(MilesLibrary library) { this.library = library; }

    public double distanceInKilometers(double origin, double destination) {
        return library.distanceInMiles(origin, destination) * 1.60934;
    }
}

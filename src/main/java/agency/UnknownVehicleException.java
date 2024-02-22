package agency;

/**
 * Exception levée lorsqu'un véhicule est inconnu
 */
public class UnknownVehicleException extends RuntimeException {

    /**
     * Véhicule inconnu
     */
    private final Vehicle vehicle;

    /**
     * Constructeur
     * @param vehicle : véhicule inconnu
     */
    public UnknownVehicleException(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Retourne le message d'erreur
     * @return String : message d'erreur
     */
    @Override
    public String getMessage() {
        return "Unknown vehicle: " + vehicle.toString();
    }
}

package agency;

import util.TimeProvider;

/**
 * Classe Car
 * Représente une voiture
 */
public class Car extends AbstractVehicle{

    /**
     * Nombre de sièges
     */
    private final int numberOfSeats;

    /**
     * Constructeur
     * @param brand : marque
     * @param model : modèle
     * @param productionYear : année de production
     * @param numberOfSeats : nombre de sièges
     */
    public Car(String brand, String model, int productionYear, int numberOfSeats) {
        super(brand, model, productionYear);

        if (numberOfSeats < 1) {
            throw new IllegalArgumentException("Number of seats is invalid, seats: " + numberOfSeats);
        }
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Retourne le prix de location journalier
     * Calcul : Si plus de 5ans : 20€/siège, sinon 40€/siège
     * @return Double : le prix de location journalier
     */
    @Override
    public double dailyRentPrice() {
        if (isNew()) {
            return 40 * numberOfSeats;
        }
        return 20 * numberOfSeats;
    }

    /**
     * Retourne vrai si l'objet est égal à l'objet passé en paramètre
     * @return Boolean : vrai si l'objet est égal à l'objet passé en paramètre
     */
    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        Car car = (Car) obj;
        return car.getBrand().equals(this.getBrand())
                && car.getModel().equals(this.getModel())
                && car.getProductionYear() == this.getProductionYear()
                && car.numberOfSeats == this.numberOfSeats;
    }

    /**
     * Retourne une représentation textuelle de l'objet
     * Format : Type de véhicule - Marque - Modèle - Année de production - Nombre de sièges : Prix de location journalier
     * @return String : représentation textuelle de l'objet
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car");
        sb.append(" - ");
        sb.append(super.toString());
        sb.append(" - ");
        sb.append(numberOfSeats);
        sb.append(" seats : ");
        sb.append(dailyRentPrice());
        sb.append("€");
        return sb.toString();
    }

    /**
     * Retourne vrai si la voiture à 5 ans ou moins
     * @return Boolean : vrai si la voiture à 5 ans ou moins
     */
    public boolean isNew() {
        return TimeProvider.currentYearValue() - this.getProductionYear() <= 5;
    }
}

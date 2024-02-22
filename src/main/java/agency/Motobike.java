package agency;

/**
 * Classe représentant un véhicule de type motobike
 */
public class Motobike extends AbstractVehicle{

    /**
     * Cylindré du véhicule
     */
    private final int cylinderCapacity;

    /**
     * Constructeur de la classe Motobike
     * @param brand : marque du véhicule
     * @param model : modèle du véhicule
     * @param productionYear : année de production du véhicule
     * @param cylinderCapacity : cylindré du véhicule
     */
    public Motobike(String brand, String model, int productionYear, int cylinderCapacity) {
        super(brand, model, productionYear);
        if (cylinderCapacity < 50) {
            throw new IllegalArgumentException("Cylinder capacity is invalid, capacity: " + cylinderCapacity);
        }
        this.cylinderCapacity = cylinderCapacity;
    }

    /**
     * Retourne une représentation textuelle de l'objet
     * Format : Type de véhicule - Marque - Modèle - Année de production - Cylindré : Prix de location journalier
     * @return String : représentation textuelle de l'objet
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Motobike");
        sb.append(" - ");
        sb.append(super.toString());
        sb.append(" - ");
        sb.append(cylinderCapacity);
        sb.append("cc : ");
        sb.append(dailyRentPrice());
        sb.append("€");
        return sb.toString();
    }

    /**
     * Retourne le prix de location journalier du véhicule
     * Calcul : 0.25 * cylinderCapacity
     * @return Double : le prix de location journalier du véhicule
     */
    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        Motobike motobike = (Motobike) obj;
        return motobike.getBrand().equals(this.getBrand())
                && motobike.getModel().equals(this.getModel())
                && motobike.getProductionYear() == this.getProductionYear()
                && motobike.cylinderCapacity == this.cylinderCapacity;
    }

    /**
     * Retourne le prix de location journalier du véhicule
     * Calcul : 0.25 * cylinderCapacity
     * @return Double : le prix de location journalier du véhicule
     */
    @Override
    public double dailyRentPrice() {
        return 0.25 * cylinderCapacity;
    }
}

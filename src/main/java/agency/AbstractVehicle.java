package agency;

import util.TimeProvider;

/**
 * Classe abstraite AbstractVehicle
 * Représente un véhicule
 */
public abstract class AbstractVehicle implements Vehicle{

    /**
     * Marque
     */
    private final String brand;

    /**
     * Modèle
     */
    private final String model;

    /**
     * Année de production
     */
    private final int productionYear;

    /**
     * Constructeur
     * @param brand : marque
     * @param model : modèle
     * @param productionYear : année de production
     */
    public AbstractVehicle(String brand, String model, int productionYear) {
        this.brand = brand;
        this.model = model;
        if (productionYear < 1900 || productionYear > TimeProvider.currentYearValue()) {
            throw new IllegalArgumentException("Production year is invalid, year: " + productionYear);
        }
        this.productionYear = productionYear;
    }

    /**
     * Retourne la marque
     * @return String : la marque
     */
    @Override
    public String getBrand() {
        return brand;
    }

    /**
     * Retourne le modèle
     * @return String : le modèle
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Retourne l'année de production
     * @return Integer : l'année de production
     */
    @Override
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Retourne vrai si le véhicule est le même que l'objet passé en paramètre
     * @param obj : objet à comparer
     * @return Boolean : vrai si le véhicule est le même que l'objet passé en paramètre
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        return obj.getClass() == this.getClass();
    }

    /**
     * Retourne la représentation textuelle du véhicule
     * @return String : la représentation textuelle du véhicule
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(brand);
        sb.append(" - ");
        sb.append(model);
        sb.append(" - ");
        sb.append(productionYear);
        return sb.toString();
    }
}

package agency;

/**
 * Interface Vehicle
 * Représente un véhicule
 */
public interface Vehicle {

    /**
     * Retourne le type de véhicule
     * @return String : type de véhicule
     */
    String getBrand();

    /**
     * Retourne le modèle
     * @return String : modèle
     */
    String getModel();

    /**
     * Retourne l'année de production
     * @return Integer : année de production
     */
    int getProductionYear();

    /**
     * Retourne le prix de location journalier
     * @return Double : prix de location journalier
     */
    double dailyRentPrice();

    /**
     * Retourne le type de véhicule
     * @return String : type de véhicule
     */
    boolean equals(Object obj);

    /**
     * Retourne une représentation textuelle de l'objet
     * Format : Type de véhicule - Marque - Modèle - Année de production : Prix de location journalier
     * @return String : représentation textuelle de l'objet
     */
    String toString();
}

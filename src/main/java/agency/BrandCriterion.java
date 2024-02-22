package agency;

import java.util.function.Predicate;

/**
 * Classe BrandCriterion
 * Représente un critère de recherche de véhicule par marque
 */
public class BrandCriterion implements Predicate<Vehicle> {

    /**
     * Marque du véhicule
     */
    private String brand;

    /**
     * Constructeur
     * @param brand Marque du véhicule
     */
    public BrandCriterion(String brand) {
        this.brand = brand;
    }

    /**
     * Teste si le véhicule correspond au critère
     * @param vehicle Véhicule à tester
     * @return Boolean : vrai si le véhicule correspond au critère, false sinon
     */
    @Override
    public boolean test(Vehicle vehicle) {
        return vehicle.getBrand().equals(brand);
    }
}

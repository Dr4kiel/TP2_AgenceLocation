package utils;

import java.time.Year;

/**
 * Classe TimeProvider
 * Utilitaire pour obtenir l'année actuelle
 */
public class TimeProvider {
    /**
     * Méthode qui retourne l'année actuelle
     * @return Integer : l'année actuelle
     */
    public static int currentYearValue() {
        return Year.now().getValue();
    }
}

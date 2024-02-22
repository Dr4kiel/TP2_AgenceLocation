package agency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MotobikeTest {

    /*
        Le test suivant vérifie que le constructeur lève l'exception IllegalArgumentException pour les cas suivants :
        - Si l'année donnée est inférieur strictement à 1900
        - Si l'année donnée est supérieur strictement à l'année actuelle
            -> Les deux cas devront donner l'année de production invalide
        - Si la cylindrée est inférieur strictement à 50
            -> Ce cas devra donner la cylindrée invalide

        Tous les cas devront expliquer le problème rencontré dans le constructeur de l'exception

     */
    @Test
    void testMotobikeConstructor() {
        // Test 1
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Motobike("brand", "model", 1899, 100));
        assertThat(e.getMessage()).isEqualTo("Production year is invalid, year: 1899");

        // Test 2
        e = assertThrows(IllegalArgumentException.class, () -> new Motobike("brand", "model", 2025, 100));
        assertThat(e.getMessage()).isEqualTo("Production year is invalid, year: 2025");

        // Test 3
        e = assertThrows(IllegalArgumentException.class, () -> new Motobike("brand", "model", 2024, 49));
        assertThat(e.getMessage()).isEqualTo("Cylinder capacity is invalid, capacity: 49");
    }

    /*
        Le test suivant vérifie que la méthode toString retourne bien la chaîne de caractères attendue
     */
    @Test
    void testToString() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.toString()).isEqualTo("Motobike - brand - model - 2024 - 100cc : 25.0€");
    }

    /*
        Le test suivant vérifie que la méthode getBrand retourne bien la marque du véhicule
     */
    @Test
    void testGetBrand() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.getBrand()).isEqualTo("brand");
    }

    /*
        Le test suivant vérifie que la méthode getModel retourne bien le modèle du véhicule
     */
    @Test
    void testGetModel() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.getModel()).isEqualTo("model");
    }

    /*
        Le test suivant vérifie que la méthode getProductionYear retourne bien l'année de production du véhicule
     */
    @Test
    void testGetProductionYear() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.getProductionYear()).isEqualTo(2024);
    }

    /*
        Le test suivant vérifie que la méthode dailyRentPrice retourne bien le prix de location journalier du véhicule
     */
    @Test
    void testDailyRentPrice() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.dailyRentPrice()).isEqualTo(100*0.25);
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien vrai si les deux objets sont égaux
     */
    @Test
    void testEquals() {
        Motobike motobike1 = new Motobike("brand", "model", 2024, 100);
        Motobike motobike2 = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike1.equals(motobike2)).isTrue();
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien faux si les deux objets ne sont pas égaux
     */
    @Test
    void testNotEquals() {
        Motobike motobike1 = new Motobike("brand", "model", 2024, 100);
        Motobike motobike2 = new Motobike("brand", "model", 2024, 101);
        assertThat(motobike1.equals(motobike2)).isFalse();
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien faux si l'objet donné est null
     */
    @Test
    void testEqualsNull() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.equals(null)).isFalse();
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien vrai si les deux objets sont les mêmes
     */
    @Test
    void testEqualsSame() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.equals(motobike)).isTrue();
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien faux si les deux objets n'ont pas la même classe
     */
    @Test
    void testEqualsDifferentClass() {
        Motobike motobike = new Motobike("brand", "model", 2024, 100);
        assertThat(motobike.equals(new Car("brand", "model", 2024, 100))).isFalse();
    }

}
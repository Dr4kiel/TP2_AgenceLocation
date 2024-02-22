package agency;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
@Tag("agency")
class CarTest {

    /*
        Le test suivant vérifie que le constructeur lève l'exception IllegalArgumentException pour les cas suivants :
        - Si l'année donnée est inférieur strictement à 1900
        - Si l'année donnée est supérieur strictement à l'année actuelle
            -> Les deux cas devront donner l'année de production invalide
        - Si le nombre de sièges est inférieur strictement à 1
            -> Ce cas devra donner le nombre de sièges invalide

        Tous les cas devront expliquer le problème rencontré dans le constructeur de l'exception

     */
    @Test
    void testCarConstructor() {
        // Test 1
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car("brand", "model", 1899, 5))
                .withMessage("Production year is invalid, year: 1899");

        // Test 2
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car("brand", "model", 2025, 5))
                .withMessage("Production year is invalid, year: 2025");

        // Test 3
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Car("brand", "model", 2024, 0))
                .withMessage("Number of seats is invalid, seats: 0");
    }

    /*
        Le test suivant vérifie que la méthode toString retourne bien la chaîne de caractères attendue
     */
    @Test
    void testToString() {
        Car car = new Car("brand", "model", 2024, 5);
        assertThat(car.toString()).isEqualTo("Car - brand - model - 2024 - 5 seats : 200.0€");
    }

    /*
        Le test suivant vérifie que la méthode getBrand retourne bien la marque de la voiture
     */
    @Test
    void testGetBrand() {
        Car car = new Car("brand", "model", 2024, 5);
        assertThat(car.getBrand()).isEqualTo("brand");
    }

    /*
        Le test suivant vérifie que la méthode getModel retourne bien le modèle de la voiture
     */
    @Test
    void testGetModel() {
        Car car = new Car("brand", "model", 2024, 5);
        assertThat(car.getModel()).isEqualTo("model");
    }

    /*
        Le test suivant vérifie que la méthode getProductionYear retourne bien l'année de production de la voiture
     */
    @Test
    void testGetProductionYear() {
        Car car = new Car("brand", "model", 2024, 5);
        assertThat(car.getProductionYear()).isEqualTo(2024);
    }

    /*
        Le test suivant vérifie que la méthode dailyRentPrice retourne bien le prix de location journalier
        - Si la voiture est neuve, le prix de location journalier est de 40€ par siège
        - Si la voiture n'est pas neuve, le prix de location journalier est de 20€ par siège
     */
    @Test
    void testDailyRentPrice() {
        Car car = new Car("brand", "model", 2021, 5);
        assertThat(car.dailyRentPrice()).isEqualTo(40 * 5);
        car = new Car("brand", "model", 2018, 5);
        assertThat(car.dailyRentPrice()).isEqualTo(20 * 5);
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien true si les deux objets sont égaux
     */
    @Test
    void testEquals() {
        Car car1 = new Car("brand", "model", 2024, 5);
        Car car2 = new Car("brand", "model", 2024, 5);
        assertThat(car1.equals(car2)).isTrue();
    }

    /*
        Le test suivant vérifie que la méthode equals retourne bien false si les deux objets ne sont pas égaux
     */
    @Test
    void testNotEquals() {
        Car car1 = new Car("brand", "model", 2024, 5);
        Car car2 = new Car("brand", "model", 2024, 4);
        assertThat(car1.equals(car2)).isFalse();
    }

}
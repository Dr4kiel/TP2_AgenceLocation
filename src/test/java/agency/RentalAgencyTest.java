package agency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@Tag("agency")
class RentalAgencyTest {

    private RentalAgency rentalAgency;

    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency();
    }

    /*
        Test qui vérifie que la méthode add ajoute bien un véhicule à la liste
     */
    @Test
    void testAdd() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        rentalAgency.add(vehicle);
        assertThat(rentalAgency.getVehicles()).contains(vehicle);
    }

    /*
        Test qui vérifie que la méthode add ne peut pas ajouter deux fois le même véhicule
     */
    @Test
    void testAddTwice() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        rentalAgency.add(vehicle);
        assertThat(rentalAgency.add(vehicle)).isFalse();
    }

    /*
        Test qui vérifie que la méthode remove retire bien un véhicule de la liste
     */
    @Test
    void testRemove() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        List<Vehicle> vehicles = List.of(
                vehicle,
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        rentalAgency.remove(vehicle);
        assertThat(rentalAgency.getVehicles()).doesNotContain(vehicle);
    }

    /*
        Test qui vérifie que la méthode remove lève bien une exception si le véhicule n'est pas dans la liste
     */
    @Test
    void testRemoveException() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        List<Vehicle> vehicles = List.of(
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        assertThatExceptionOfType(UnknownVehicleException.class).isThrownBy(() -> rentalAgency.remove(vehicle));
    }

    /*
        Test qui vérifie que la méthode contains retourne bien true si le véhicule est dans la liste
     */
    @Test
    void testContainsTrue() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        List<Vehicle> vehicles = List.of(
                vehicle,
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        assertThat(rentalAgency.contains(vehicle)).isTrue();
    }

    /*
        Test qui vérifie que la méthode contains retourne bien false si le véhicule n'est pas dans la liste
     */
    @Test
    void testContainsFalse() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        List<Vehicle> vehicles = List.of(
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        assertThat(rentalAgency.contains(vehicle)).isFalse();
    }

    /*
        Test qui vérifie que la méthode getVehicles retourne bien la liste des véhicules
     */
    @Test
void testGetVehicles() {
        List<Vehicle> vehicles = List.of(
                new Car("Renault", "Clio", 2010, 5),
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        assertThat(rentalAgency.getVehicles()).containsAll(vehicles);
    }

    /*
        Test qui vérifie que la méthode select retourne bien la liste des véhicules correspondant au critère
     */
    @Test
    void testSelect() {
        List<Vehicle> vehicles = List.of(
                new Car("Renault", "Clio", 2010, 5),
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        List<Vehicle> selected = rentalAgency.select(new BrandCriterion("Renault"));
        assertThat(selected).contains(vehicles.get(0));
    }

    /*
        Test qui vérifie que la méthode printSelectedVehicle affiche bien les véhicules correspondant au critère
     */
    @Test
    void testPrintSelectedVehicle() {
        List<Vehicle> vehicles = List.of(
                new Car("Renault", "Clio", 2010, 5),
                new Car("Peugeot", "208", 2015, 5),
                new Car("Citroen", "C3", 2018, 5)
        );
        rentalAgency = new RentalAgency(new ArrayList<>(vehicles));

        rentalAgency.printSelectedVehicle(new BrandCriterion("Renault"));
    }

    /*
        Test qui vérifie que la méthode rentVehicle lève bien une exception si le véhicule n'est pas dans la liste
     */
    @Test
    void testRentVehicleException() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        assertThatExceptionOfType(UnknownVehicleException.class).isThrownBy(() -> rentalAgency.rentVehicle(client, vehicle))
                .withMessage("Unknown vehicle: Car - Renault - Clio - 2010 - 5 seats : 100.0€");
    }

    /*
        Test qui vérifie que la méthode rentVehicle lève bien une exception si le client a déjà loué un véhicule
     */
    @Test
    void testRentVehicleException2() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> rentalAgency.rentVehicle(client, vehicle));
    }

    /*
        Test qui vérifie que la méthode rentVehicle lève bien une exception si le véhicule est déjà loué
     */
    @Test
    void testRentVehicleException3() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> rentalAgency.rentVehicle(new Client(), vehicle));
    }

    /*
        Test qui vérifie que la méthode rentVehicle retourne bien le prix de location du véhicule
     */
    @Test
    void testRentVehicle() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        assertThat(rentalAgency.rentVehicle(client, vehicle)).isEqualTo(vehicle.dailyRentPrice());
    }

    /*
        Test qui vérifie que la méthode aVehiculeRentedBy retourne bien true si le client a loué un véhicule
     */
    @Test
    void testAVehiculeRentedByTrue() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        assertThat(rentalAgency.aVehiculeRentedBy(client)).isTrue();
    }

    /*
        Test qui vérifie que la méthode aVehiculeRentedBy retourne bien false si le client n'a pas loué de véhicule
     */
    @Test
    void testAVehiculeRentedByFalse() {
        Client client = new Client();
        assertThat(rentalAgency.aVehiculeRentedBy(client)).isFalse();
    }

    /*
        Test qui vérifie que la méthode aVehiculeRentedBy retourne bien false si le client a rendu le véhicule
     */
    @Test
    void testAVehiculeRentedByFalse2() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        rentalAgency.returnVehicle(client);
        assertThat(rentalAgency.aVehiculeRentedBy(client)).isFalse();
    }

    /*
        Test qui vérifie que la méthode vehiculeIsRented retourne bien true si le véhicule est loué
     */
    @Test
    void testVehiculeIsRentedTrue() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        assertThat(rentalAgency.vehiculeIsRented(vehicle)).isTrue();
    }

    /*
        Test qui vérifie que la méthode vehiculeIsRented retourne bien false si le véhicule n'est pas loué
     */
    @Test
    void testVehiculeIsRentedFalse() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        assertThat(rentalAgency.vehiculeIsRented(vehicle)).isFalse();
    }

    /*
        Test qui vérifie que la méthode returnVehicle retire bien le véhicule de la liste des véhicules loués
     */
    @Test
    void testReturnVehicle() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        rentalAgency.returnVehicle(client);
        assertThat(rentalAgency.aVehiculeRentedBy(client)).isFalse();
    }

    /*
        Test qui vérifie que la méthode allRentedVehicles retourne bien la liste des véhicules loués
     */
    @Test
    void testAllRentedVehicles() {
        Car vehicle = new Car("Renault", "Clio", 2010, 5);
        Client client = new Client();
        rentalAgency.add(vehicle);
        rentalAgency.rentVehicle(client, vehicle);
        assertThat(rentalAgency.allRentedVehicles()).contains(vehicle);
    }
}
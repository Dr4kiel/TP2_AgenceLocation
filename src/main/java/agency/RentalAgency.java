package agency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Classe RentalAgency
 * Représente une agence de location de véhicules.
 */
public class RentalAgency {

    /**
     * Liste des véhicules
     */
    private List<Vehicle> vehicles;

    /**
     * Map des véhicules loués
     */
    private Map<Client, Vehicle> rentedVehicles;

    /**
     * Constructeur
     */
    public RentalAgency() {
        this(new ArrayList<Vehicle>());
    }

    /**
     * Constructeur
     * @param vehicles : liste des véhicules
     */
    public RentalAgency(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        rentedVehicles = new java.util.HashMap<Client, Vehicle>();
    }

    /**
     * Ajoute un véhicule
     * @param vehicle : véhicule
     * @return Boolean : vrai si le véhicule a été ajouté
     */
    public boolean add(Vehicle vehicle) {
        if(contains(vehicle))
            return false;
        else
            return vehicles.add(vehicle);
    }

    /**
     * Supprime un véhicule
     * @param vehicle : véhicule
     * @throws UnknownVehicleException : exception si le véhicule est inconnu
     */
    public void remove(Vehicle vehicle) throws UnknownVehicleException{
        if (!contains(vehicle))
            throw new UnknownVehicleException(vehicle);
        else
            vehicles.remove(vehicle);
    }

    /**
     * Retourne vrai si le véhicule est dans la liste
     * @param vehicle : véhicule
     * @return Boolean : vrai si le véhicule est dans la liste
     */
    public boolean contains(Vehicle vehicle) {
        return vehicles.contains(vehicle);
    }

    /**
     * Retourne la liste des véhicules
     * @return List<Vehicle> : liste des véhicules
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Retourne la liste des véhicules répondant au critère
     * @return List<Vehicle> : liste des véhicules répondant au critère
     */
    public List<Vehicle> select(Predicate<Vehicle> criterion) {
        List<Vehicle> selected = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles) {
            if (criterion.test(vehicle))
                selected.add(vehicle);
        }
        return selected;
    }

    /**
     * Affiche les véhicules sélectionnés
     * @param criterion : critère de sélection
     */
    public void printSelectedVehicle(Predicate<Vehicle> criterion) {
        List<Vehicle> selected = select(criterion);
        for (Vehicle vehicle : selected) {
            System.out.println(vehicle);
        }
    }

    /**
     * Loue un véhicule
     * @param client : client
     * @param vehicule : véhicule
     * @return Double : prix de location journalier
     * @throws UnknownVehicleException : exception si le véhicule est inconnu
     * @throws IllegalStateException : exception si le client a déjà loué un véhicule ou le véhicule est déjà loué
     */
    public double rentVehicle(Client client, Vehicle vehicule) throws UnknownVehicleException, IllegalStateException {
        if (!contains(vehicule))
            throw new UnknownVehicleException(vehicule);
        if (rentedVehicles.containsKey(client) || rentedVehicles.containsValue(vehicule))
            throw new IllegalStateException("Le client a déjà loué un véhicule ou le véhicule est déjà loué.");
        rentedVehicles.put(client, vehicule);
        return vehicule.dailyRentPrice();
    }

    /**
     * Retourne vrai si le client a loué un véhicule
     * @param client : client
     * @return Boolean : vrai si le client a loué un véhicule
     */
    public boolean aVehiculeRentedBy(Client client) {
        return rentedVehicles.containsKey(client);
    }

    /**
     * Retourne vrai si le véhicule est loué
     * @param vehicule : véhicule
     * @return Boolean : vrai si le véhicule est loué
     */
    public boolean vehiculeIsRented(Vehicle vehicule) {
        return rentedVehicles.containsValue(vehicule);
    }

    /**
     * Termine la location d'un véhicule
     * Rien ne se passe si le client n'a pas loué de véhicule
     * @param client : client
     */
    public void returnVehicle(Client client) {
        rentedVehicles.remove(client);
    }

    /**
     * Retourne la liste des véhicules loués
     * @return Collection<Vehicle> : liste des véhicules loués
     */
    public Collection<Vehicle> allRentedVehicles() {
        return rentedVehicles.values();
    }
}

package agency;

/**
 * Classe Client
 * Représente un client de l'agence
 */
public class Client {

    /**
     * Nom du client
     */
    private String nom;

    /**
     * Prénom du client
     */
    private String prenom;

    /**
     * Adresse du client
     */
    private String address;

    /**
     * Constructeur
     * @param nom Nom du client
     * @param prenom Prénom du client
     * @param address Adresse du client
     */
    public Client(String nom, String prenom, String address) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
    }

    /**
     * Constructeur par défaut
     */
    public Client() {
        this("Doe", "John", "1 rue de la Paix");
    }

    /**
     * Retourne le nom du client
     * @return String : Nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom du client
     * @return String : Prénom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne l'adresse du client
     * @return String : Adresse du client
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retourne une représentation textuelle du client
     * @return String : Représentation textuelle du client
     */
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

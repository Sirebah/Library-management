
package librarymanagement;

import java.sql.Connection;
import java.sql.*;



public class Database {
    
  public static Connection connectDB() {
        // Définir l'URL de la base de données, l'utilisateur et le mot de passe
        String url = "jdbc:postgresql://localhost:5432/library_database"; 
        String utilisateur = "postgres"; 
        String motDePasse = "sire"; 
        Connection connect = null;

        try {
            
            Class.forName("org.postgresql.Driver");

            // Etablir la connexion
            connect = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé : " + e.getMessage());
            e.printStackTrace();
        }

        // Retourner la connexion ou null en cas d'échec
        return connect;
    }
    
}

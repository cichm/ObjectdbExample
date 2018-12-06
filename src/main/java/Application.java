import model.Person;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.util.Iterator;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        // Check the arguments:
        String name = "john";
        String surname  = "malecki";
        int age = 18;

        try {
            // Obtain a database connection:
            Properties properties = new Properties();
            properties.setProperty(
                    "javax.jdo.PersistenceManagerFactoryClass",
                    "com.objectdb.jdo.PMF");
            properties.setProperty(
                    "javax.jdo.option.ConnectionURL", "persons.odb");
            PersistenceManagerFactory pmf =
                    JDOHelper.getPersistenceManagerFactory(properties);
            PersistenceManager pm = pmf.getPersistenceManager();

            try {
                // Begin the transaction:
                pm.currentTransaction().begin();

                // Create and store a new Person instance:
                Person person = new Person(name, surname, age);
                pm.makePersistent(person);

                // Print all the Persons in the database:
                Extent extent = pm.getExtent(Person.class, false);
                for (Object anExtent : extent) System.out.println(anExtent);
                extent.closeAll();

                // Commit the transaction:
                pm.currentTransaction().commit();
            }
            finally {
                // Close the database and active transaction:
                if (pm.currentTransaction().isActive())
                    pm.currentTransaction().rollback();
                if (!pm.isClosed())
                    pm.close();
            }
        }

        // Handle both JDOException and NumberFormatException:
        catch (RuntimeException x) {
            System.err.println("Error: " + x.getMessage());
        }
    }
}

import model.user.*;
import model.userDetails.*;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        try {
            // Obtain a database connection:
            Properties properties = new Properties();
            properties.setProperty(
                    "javax.jdo.PersistenceManagerFactoryClass",
                    "com.objectdb.jdo.PMF");
            properties.setProperty(
                    "javax.jdo.option.ConnectionURL", "user.odb");
            PersistenceManagerFactory pmf =
                    JDOHelper.getPersistenceManagerFactory(properties);
            PersistenceManager pm = pmf.getPersistenceManager();

            try {
                // Begin the transaction:
                pm.currentTransaction().begin();

                // Create and store a new User instance:
                UserDetails userDetails = new UserDetails.Builder()
                        .phone(Phone.phone("777777777"))
                        .nickName(NickName.nickName("tomson"))
                        .city(City.city("Warszawa"))
                        .birthDay(BirthDay.birthDay(1))
                        .birthMonth(BirthMonth.birthMonth(1))
                        .birthYear(BirthYear.birthYear(1995))
                        .zipCode(ZipCode.zipCode("00-001"))
                        .avatar(Avatar.avatar("http://www.google.pl/img/tesa3w"))
                        .build();

                User user = new User(Email.email("test@gmail.com"), Name.name("Tomasz"), Surname.surname("Łach"), Age.age(64),
                        IsActive.isActive(true), Sex.sex(true), userDetails);
                pm.makePersistent(user);

                // Print all the Persons in the database:
                Extent extent = pm.getExtent(User.class, false);
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

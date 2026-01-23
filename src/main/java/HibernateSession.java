import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateSession {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			
			configuration.configure(); 
			configuration.addAnnotatedClass(domain.Person.class);
			configuration.addAnnotatedClass(domain.Student.class);
			configuration.addAnnotatedClass(domain.Teacher.class);

			configuration.addAnnotatedClass(domain.Vehicle.class);
			configuration.addAnnotatedClass(domain.Car.class);
			configuration.addAnnotatedClass(domain.Plane.class);
			configuration.addAnnotatedClass(domain.Motorcycle.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
			
			return configuration.buildSessionFactory(serviceRegistry);		
		} catch (Throwable ex) {
			System.err.println("Error creando SessionFactory: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

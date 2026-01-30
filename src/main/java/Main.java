import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Car;
import domain.Motorcycle;
import domain.Plane;
import domain.Person;
import domain.Student;
import domain.Teacher;
import domain.Vehicle;

public class Main {
    private static Session session = HibernateSession.getSessionFactory().openSession();

    private static List<Person> people = new ArrayList<>();
    private static List<Vehicle> vehicles = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1) Fase 1: Crear dades de prova");
            System.out.println("2) Fase 2: Treure vehicles de persones");
            System.out.println("3) Fase 3: Actualitzar un vehicle");
            System.out.println("0) Sortir");
            System.out.print("Escull una opció: ");

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    fase1();
                    break;
                case 2:
                    fase2();
                    break;
                case 3:
                    fase3();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció incorrecta.");
            }

        } while (opcio != 0);

        sc.close();
        HibernateSession.getSessionFactory().close();
    }

    private static void fase1() {
        Transaction t = session.beginTransaction();
        try{
        //PERSON

            //Student
            Student anna = new Student("STU001");
            anna.setName("Anna");
            anna.setSurname("Lopez");
            anna.setPhoneNumber(111111111);
            session.persist(anna);

            Student jordi = new Student("STU002");
            jordi.setName("Jordi");
            jordi.setSurname("Martinez");
            jordi.setPhoneNumber(222222222);
            session.persist(jordi);

            Student clara = new Student("STU003");
            clara.setName("Clara");
            clara.setSurname("Sanchez");
            clara.setPhoneNumber(333333333);
            session.persist(clara);

            //Teacher
            Teacher joan = new Teacher("TEA001");
            joan.setName("Joan");
            joan.setSurname("Perez");
            joan.setPhoneNumber(444444444);
            session.persist(joan);

            Teacher maria = new Teacher("TEA002");
            maria.setName("Maria");
            maria.setSurname("Gomez");
            maria.setPhoneNumber(555555555);
            session.persist(maria);

            Teacher pere = new Teacher("STU003");
            pere.setName("Pere");
            pere.setSurname("Ruiz");
            pere.setPhoneNumber(666666666);
            session.persist(pere);

        //VEHICLE

            //Car
            Car toyota = new Car();
            toyota.setBrand("Toyota");
            toyota.setYear(2020);
            toyota.setPrice(18000f);
            toyota.setOwner(anna);
            toyota.setDoor(5);
            toyota.setSeats(5);
            session.persist(toyota);

            Car ford = new Car();
            ford.setBrand("Ford");
            ford.setYear(2019);
            ford.setPrice(15000f);
            ford.setOwner(maria);
            ford.setDoor(3);
            ford.setSeats(4);
            session.persist(ford);

            //Plane
            Plane cessna = new Plane();
            cessna.setBrand("Cessna");
            cessna.setYear(2015);
            cessna.setPrice(120000f);
            cessna.setOwner(joan);
            cessna.setAutopilot(true);
            cessna.setTailNumber(11111);
            session.persist(cessna);

            Plane boeing = new Plane();
            boeing.setBrand("Boeing");
            boeing.setYear(2010);
            boeing.setPrice(900000f);
            boeing.setOwner(clara);
            boeing.setAutopilot(false);
            boeing.setTailNumber(22222);
            session.persist(boeing);

            //Motorcycle
            Motorcycle yamaha = new Motorcycle();
            yamaha.setBrand("Yamaha");
            yamaha.setYear(2021);
            yamaha.setPrice(9000f);
            yamaha.setOwner(jordi);
            yamaha.setHasSidecar(false);
            session.persist(yamaha);

            Motorcycle harley = new Motorcycle();
            harley.setBrand("Harley-Davidson");
            harley.setYear(2018);
            harley.setPrice(20000f);
            harley.setOwner(pere);
            harley.setHasSidecar(true);
            session.persist(harley);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fase2() {

        if (session.getTransaction().isActive()){
            session.getTransaction().commit();
        }
        Transaction t = session.beginTransaction();
        try{
            Person person = session.get(Person.class, 1);
            Vehicle vehicle = session.get(Vehicle.class, 1);
            if (person != null && vehicle != null){
                person.removeVehicle(vehicle);
                vehicle.setOwner(null);
            }

            t.commit();
        } catch (Exception e) {
            if (t != null){
                t.rollback();
            }
            e.printStackTrace();
        }
    }

    private static void fase3() {
        if (session.getTransaction().isActive()){
            session.getTransaction().commit();
        }
        Transaction t = session.beginTransaction();
        try{
            Vehicle vehicle = session.get(Vehicle.class, 1);
            vehicle.setBrand("Seat");
            vehicle.setYear(2022);
            vehicle.setPrice(19999f);
            t.commit();

        } catch (Exception e) {
            if (t != null){
                t.rollback();
            }
            e.printStackTrace();

        }
    }
}

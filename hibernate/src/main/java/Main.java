import models.Address;
import models.Author;
import models.Book;
import org.hibernate.Session;
import utils.HibernateUtil;


public class Main {
    public static void main(String[] args) {

        Author author = new Author();
        author.setName("Лев Толстой");

        Address address = new Address();
        address.setCity("Тульская губерния");
        address.setStreet("Ясная Поляна");

        Book book = new Book();
        book.setTitle("Война и мир");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Session session2 = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(author);
        session.save(address);
        session.save(book);

        author = session.get(Author.class, 1L);
        address = session.get(Address.class, 1L);
        book = session.get(Book.class, 1L);
        System.out.println("Author with id = " + author.getId() + ": " + author.getName());
        System.out.println("Address with id = " + address.getId() + ": " + address.getCity());
        System.out.println("Book with id = " + book.getId() + ": " + book.getTitle());
        session.getTransaction().commit();
        session.close();


    }
}

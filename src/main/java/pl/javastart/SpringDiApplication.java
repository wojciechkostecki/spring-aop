package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.javastart.model.Book;
import pl.javastart.service.GenericRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringDiApplication.class);

        GenericRepository<String, Book> repo = ctx.getBean(GenericRepository.class);
        repo.add(new Book("1234567890123", "W pustyni i w puszczy", "Henryk Sienkiewicz"));
        repo.add(new Book("2345678901234", "Kasacja", "Remigiusz Mróz"));
        repo.add(new Book("3456789012345", "Dekalog Nawałki", "Marcin Feddek"));
        Book book = repo.get("1234567890123");
        System.out.println(book);

        ctx.close();
    }
}

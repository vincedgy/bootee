package net.vincedgy.garden.bootee

import com.vaadin.data.provider.DataProvider
import com.vaadin.data.provider.ListDataProvider
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Grid
import com.vaadin.ui.Notification
import com.vaadin.ui.UI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
public class BooteeApplication {

    @Bean
    open fun init(repository: ReservationRepository) = CommandLineRunner {

        sequenceOf("Jack", "Chloe", "Kim", "David", "Michelle")
                .forEach {
                    repository.save(Reservation(it))
                }
        repository.findAll().forEach(System.out::println)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BooteeApplication::class.java, *args)
}


@SpringUI(path="/ui")
class ReservationUI: UI() {

    @Autowired
    lateinit var repository: ReservationRepository;

    override fun init(request: VaadinRequest?) {

        var grid = Grid<Reservation>().apply {
            dataProvider = DataProvider.fromStream(repository.findAll().stream())
            addColumn { it.id }.setCaption("Id")
            addColumn { it.reservationName }.setCaption("Name")
            addSelectionListener {
                Notification.show(it.allSelectedItems.first().reservationName)
            }
        }
        setContent(grid);
    }

}



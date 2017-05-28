package net.vincedgy.garden.bootee

import lombok.Data
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Stream
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@SpringBootApplication
class BooteeApplication {

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

@Entity
class Reservation(
    var reservationName: String = "",
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
) {
    override fun toString(): String {
        return "Reservation(reservationName='$reservationName', id=$id)"
    }
}

@RepositoryRestResource
interface ReservationRepository : JpaRepository<Reservation, Long> {

    @RestResource(path="by-name")
    fun findByReservationName(reservationName: String): List<Reservation>

    @RestResource(path="by-id")
    fun findById(id: Long): List<Reservation>
}



@RestController
class CustomerController (val repository:ReservationRepository) {

    @GetMapping("/resa")
    fun findAll() = repository.findAll()

    @GetMapping("/resa/{name}")
    fun findByLastName(@PathVariable name:String)
            = repository.findByReservationName(name)

    @GetMapping("/resa/{id}")
    fun findById(@PathVariable id:Long)
            = repository.findById(id)
}

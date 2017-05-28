package net.vincedgy.garden.bootee

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController (val repository: ReservationRepository) {

    @GetMapping("/resa")
    fun findAll() = repository.findAll()

    @GetMapping("/resa/{name}")
    fun findByLastName(@PathVariable name:String)
            = repository.findByReservationName(name)

    @GetMapping("/resa/{id}")
    fun findById(@PathVariable id:Long)
            = repository.findById(id)
}
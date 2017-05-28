package net.vincedgy.garden.bootee

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource

@RepositoryRestResource
interface ReservationRepository : JpaRepository<Reservation, Long> {

    @RestResource(path="by-name")
    fun findByReservationName(reservationName: String): List<Reservation>

    @RestResource(path="by-id")
    fun findById(id: Long): List<Reservation>
}
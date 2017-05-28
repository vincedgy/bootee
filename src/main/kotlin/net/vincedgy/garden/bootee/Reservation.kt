package net.vincedgy.garden.bootee

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

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
package net.vincedgy.garden.bootee

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class MvcController(val repository: ReservationRepository) {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value= "/reserv")
    fun tet(model: Model): String {
        model.addAttribute("reservations", repository.findAll())
        return "reservations"
    }

}
package net.a3h.kotlinhello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController {
    @Autowired
    lateinit var repository : GreetedPersonRepository

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) : Greeting {
        val tmp = repository.findByName(name)

        var greeted : GreetedPerson
        if (tmp.isEmpty()) {
            greeted = GreetedPerson(name)
            repository.save(greeted)
            if (greeted.id == null) {
                throw Exception("id not found for name")
            }
        } else {
            greeted = tmp.first()
        }

        val result = Greeting(greeted.id!!, "Hello, " + greeted.name)
        return result
    }
}

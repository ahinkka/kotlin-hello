package net.a3h.kotlinhello

import org.springframework.data.repository.CrudRepository


interface GreetedPersonRepository : CrudRepository<GreetedPerson, Long> {
    fun findByName(name: String): List<GreetedPerson>
}
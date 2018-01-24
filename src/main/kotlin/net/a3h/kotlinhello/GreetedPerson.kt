package net.a3h.kotlinhello

import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class GreetedPerson {
    var name : String? = null

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    // JPA/Hibernate requires an empty constructor? ¯\_(ツ)_/¯
    private constructor() {
    }

    constructor(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return String.format("GreetedPerson[id=%d, name='%s']", id, name)
    }
}

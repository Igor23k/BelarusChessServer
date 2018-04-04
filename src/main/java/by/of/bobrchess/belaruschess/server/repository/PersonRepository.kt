package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Int>
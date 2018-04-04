package by.of.bobrchess.belaruschess.server.repository

import by.of.bobrchess.belaruschess.server.entity.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Int>

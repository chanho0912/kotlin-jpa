package com.kotlinjpa.kotlinjpa

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

object EMF {

    private val emf: EntityManagerFactory =
        Persistence.createEntityManagerFactory("chanho")

    fun createEntityManager(): EntityManager {
        return emf.createEntityManager()
    }

    fun close() {
        emf.close()
    }
}
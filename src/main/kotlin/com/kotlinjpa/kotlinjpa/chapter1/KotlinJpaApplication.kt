package com.kotlinjpa.kotlinjpa.chapter1

import com.kotlinjpa.kotlinjpa.chapter1.domain.User
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.EntityTransaction
import jakarta.persistence.Persistence
import java.time.LocalDateTime


//@SpringBootApplication
//class KotlinJpaApplication

fun main(args: Array<String>) {
//    runApplication<KotlinJpaApplication>(*args)
    val entityManagerFactory: EntityManagerFactory =
        Persistence.createEntityManagerFactory("chanho")

    val entityManager: EntityManager = entityManagerFactory.createEntityManager()
    val transaction: EntityTransaction = entityManager.transaction

    try {
        transaction.begin()
        val user = User(
            email = "user@user.com",
            name = "user",
            createDate = LocalDateTime.now()
        )

        entityManager.persist(user)
//        val userFromDB = entityManager.find(User::class.java, "user@user.com")
//        userFromDB.name = "da"
        transaction.commit()
    } catch (ex: Exception) {
        ex.printStackTrace()
        transaction.rollback()
    } finally {
        entityManager.close()
    }

    entityManagerFactory.close()
}

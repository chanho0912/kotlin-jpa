package com.kotlinjpa.kotlinjpa.chapter3.service

import com.kotlinjpa.kotlinjpa.EMF
import com.kotlinjpa.kotlinjpa.chapter3.domain.User
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityTransaction
import java.lang.Exception

class ChangeNameService {

    fun changeName(email: String, newName: String) {
        val em: EntityManager = EMF.createEntityManager()
        val tx: EntityTransaction = em.transaction

        try {
            tx.begin()
            val user: User = em.find(User::class.java, email)
                ?: throw NoUserException()

            // 트랜잭션 범위 내에서 변경된 값을 자동 반영
            user.name = newName
            tx.commit()
        } catch (ex: Exception) {
            tx.rollback()
            throw ex
        } finally {
            em.close()
        }
    }
}
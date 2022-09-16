package com.kotlinjpa.kotlinjpa.chapter3.service

import com.kotlinjpa.kotlinjpa.EMF
import com.kotlinjpa.kotlinjpa.chapter3.domain.User
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityTransaction

class NewUserService {

    fun saveNewUser(user: User) {
        val em: EntityManager = EMF.createEntityManager()
        val tx: EntityTransaction = em.transaction
        try {
            tx.begin()
            em.persist(user)
            tx.commit()
        } catch (ex: Exception) {
            // 만약 동일한 키의 유저가 이미 존재한다면 exception이 발생한다.
            tx.rollback()
            throw ex
        } finally {
            em.close()
        }
    }
}
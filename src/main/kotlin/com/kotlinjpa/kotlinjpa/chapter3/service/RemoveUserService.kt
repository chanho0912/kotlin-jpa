package com.kotlinjpa.kotlinjpa.chapter3.service

import com.kotlinjpa.kotlinjpa.EMF
import com.kotlinjpa.kotlinjpa.chapter3.domain.User
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityTransaction
import java.lang.Exception

class RemoveUserService {

    fun removeUser(email: String) {
        val em: EntityManager = EMF.createEntityManager()
        val tx: EntityTransaction = em.transaction

        try {
            tx.begin()
            val user: User = em.find(User::class.java, email)
                ?: throw NoUserException()

            // find로 찾은 객체에 한에서 삭제 가능. (트랜잭션 안에서 동작해야함)
            // persistence context에 보관 중 이어야 함.
            em.remove(user)

            // 이 시점에 다른 프로세스가 데이터를 삭제하면 예외가 발생한다.
            tx.commit()
        } catch (ex: Exception) {
            tx.rollback()
            throw ex
        } finally {
            em.close()
        }
    }
}
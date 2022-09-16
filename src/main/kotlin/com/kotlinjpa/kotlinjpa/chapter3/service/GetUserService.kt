package com.kotlinjpa.kotlinjpa.chapter3.service

import com.kotlinjpa.kotlinjpa.EMF
import com.kotlinjpa.kotlinjpa.chapter3.domain.User
import jakarta.persistence.EntityManager

class GetUserService {

    fun getUser(email: String): User {
        val em: EntityManager = EMF.createEntityManager()
        try {
            // find method 는 객체의 엔티티 타입, ID 타입이 모두 맞아야 조회.
            return em.find(User::class.java, email)
                ?: throw NoUserException()
        } finally {
            em.close()
        }
    }
}
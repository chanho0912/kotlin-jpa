@file:JvmName("Chapter5")

package com.kotlinjpa.kotlinjpa.chapter5

import com.kotlinjpa.kotlinjpa.EMF
import com.kotlinjpa.kotlinjpa.chapter5.reserve.domain.Review
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityTransaction
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Exception

inline fun <reified T> loggerFor(): Logger = LoggerFactory.getLogger(T::class.java)

fun main() {
    Main().run()
}

class Main {
    fun run() {
        val em: EntityManager = EMF.createEntityManager()
        val tx: EntityTransaction = em.transaction
        val logger: Logger = loggerFor<Main>()


        try {
            tx.begin()
            val review: Review = Review(
                mark = 5,
                hotelId = "H-01",
                writerName = "작성자",
                comment = "댓글"
            )

            logger.info("persist 실행 전")

            // GenerationType.IDENTITY의 경우
            // persist 호출 시에 바로 insert 쿼리 실행
            em.persist(review)

            logger.info("persist 실행 후")
            logger.info("review id: ${review.id}")

            logger.info("before commit")
            tx.commit()
            logger.info("after commit")
        } catch (e: Exception) {
            tx.rollback()
        } finally {
            EMF.close()
        }
    }

}

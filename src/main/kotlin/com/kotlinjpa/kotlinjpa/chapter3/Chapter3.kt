package com.kotlinjpa.kotlinjpa.chapter3

import com.kotlinjpa.kotlinjpa.EMF
import com.kotlinjpa.kotlinjpa.chapter3.domain.User
import com.kotlinjpa.kotlinjpa.chapter3.service.*
import jakarta.persistence.EntityExistsException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

fun main() {

    while (true) {
        val input: String = readln()

        when {
            input.startsWith("new ") -> App.handleNew(input)
            input.startsWith("get ") -> App.handleGet(input)
            input.startsWith("change name ") -> App.handleChangeName(input)
            input.startsWith("remove ") -> App.handleRemove(input)
            input == "exit" -> break
            else -> break
        }
    }

    EMF.close()
}

class App {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(App::class.java)

        private val newUserService = NewUserService()
        private val getUserService = GetUserService()
        private val changeNameService = ChangeNameService()
        private val removeUserService = RemoveUserService()

        fun handleRemove(input: String) {
            val email: String = input.substring(7)

            try {
                removeUserService.removeUser(email)
                logger.info("사용자 삭제함: $email")
            } catch (e: NoUserException) {
                logger.info("사용자가 존재하지 않음: $email")
            }
        }

        fun handleChangeName(input: String) {
            val v: List<String> = input.substring(12).split(" ")
            val email: String = v[0]
            val newName: String = v[1]

            try {
                changeNameService.changeName(email, newName)
                logger.info("사용자 이름 변경: $email, $newName")
            } catch (e: NoUserException) {
                logger.info("사용자가 존재하지 않음: $email")
            }
        }

        fun handleGet(input: String) {
            val email: String = input.substring(4)

            try {
                val user: User = getUserService.getUser(email)
                logger.info("사용자 정보: $user")
            } catch (e: NoUserException) {
                logger.info("사용자 가 존재하지 않음: $email")
            }
        }

        fun handleNew(input: String) {
            val v: List<String> = input.substring(4).split(" ")
            val user = User(
                email = v[0],
                name = v[1],
                createDate = LocalDateTime.now()
            )

            try {
                newUserService.saveNewUser(user)
                logger.info("새 사용자 저장: $user")
            } catch (e: EntityExistsException) {
                logger.info("사용자가 이미 존재함: $user")
            }
        }
    }
}


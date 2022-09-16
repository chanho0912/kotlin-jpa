package com.kotlinjpa.kotlinjpa.chapter3.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime


@Entity
@Table(name = "user")
class User(
    @Id
    val email: String? = null,

    var name: String? = null,

    @Column(name = "create_date")
    val createDate: LocalDateTime? = null
) {

    override fun toString(): String {
        return "User(email=$email, name=$name, createDate=$createDate)"
    }
}
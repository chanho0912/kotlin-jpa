package com.kotlinjpa.kotlinjpa.chapter4.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "hotel_info")
class Hotel(
    @Id
    @Column(name = "hotel_id")
    val id: String? = null,
    @Column(name = "nm")
    val name: String = "default",
    val year: Int = 2022,

    @Enumerated(EnumType.STRING)
    val grade: Grade = Grade.F,

    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "modified")
    val lastModified: LocalDateTime = LocalDateTime.now(),
)

enum class Grade {
    A, B, C, D, F
}
package com.kotlinjpa.kotlinjpa.chapter5.reserve.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "review")
class Review(
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = -1L,

    @Column(name = "hotel_id")
    val hotelId: String = "default hotel",

    val mark: Int = 0,

    @Column(name = "writer_name")
    val writerName: String = "writer_name",

    val comment: String = "comment",

    val created: LocalDateTime = LocalDateTime.now()
)
package com.example.compose_study.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String?,
    val email: String?,
    val password: String?
) {
    // @Ignore を付ける場合は、テーブルに含めるプロパティで初期化するコンストラクタを作成する必要がある
//    constructor(
//        id: Int,
//        name: String?,
//        email: String?,
//        password: String?
//    ) : this(
//        id,
//        "hogehoge",
//        "hoge@example.com",
//        "0000"
//    )
}
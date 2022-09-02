package com.example.belajarintent

import java.io.Serializable

data class User1(
    val namaLengkap: String,
    val namaPanggilan: String,
    val umur: Int,
    val alamat: String
) : Serializable

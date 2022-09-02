package com.example.belajarintent

import android.os.Parcel
import android.os.Parcelable

data class User2(
    val namaLengkap: String?,
    val namaPanggilan: String?,
    val umur: Int,
    val alamat: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namaLengkap)
        parcel.writeString(namaPanggilan)
        parcel.writeInt(umur)
        parcel.writeString(alamat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User2> {
        override fun createFromParcel(parcel: Parcel): User2 {
            return User2(parcel)
        }

        override fun newArray(size: Int): Array<User2?> {
            return arrayOfNulls(size)
        }
    }
}
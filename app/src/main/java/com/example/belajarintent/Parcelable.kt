package com.example.belajarintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarintent.databinding.ActivityParcelableBinding

class Parcelable : AppCompatActivity() {
    private lateinit var binding: ActivityParcelableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        parcelable()
    }

    private fun parcelable(){
        val user = intent.getParcelableExtra<User2>(MainActivity.USER_PARCELABLE)

        if (user != null) {
            binding.tvIsiParcelable.text =
                getString(R.string.isi_intent,
                    user.namaLengkap,
                    user.namaPanggilan,
                    user.umur.toString(),
                    user.alamat)
        } else {
            binding.tvIsiParcelable.text =
                getString(R.string.isi_intent,
                    null,
                    null,
                    "0",
                    null)
        }
    }
}
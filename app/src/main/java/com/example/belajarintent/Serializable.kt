package com.example.belajarintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarintent.databinding.ActivitySerializableBinding

class Serializable : AppCompatActivity() {
    private lateinit var binding: ActivitySerializableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        serializable()
    }

    private fun serializable(){
        val user = intent.getSerializableExtra(MainActivity.USER_SERIALIZABLE) as? User1

        if (user != null) {
            binding.tvIsiSerializable.text =
                getString(R.string.isi_intent,
                    user.namaLengkap,
                    user.namaPanggilan,
                    user.umur.toString(),
                    user.alamat)
        } else {
            binding.tvIsiSerializable.text =
                getString(R.string.isi_intent,
                    null,
                    null,
                    "0",
                    null)
        }
    }
}
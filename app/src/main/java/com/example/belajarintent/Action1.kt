package com.example.belajarintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarintent.databinding.ActivityAction1Binding

class Action1 : AppCompatActivity() {
    private lateinit var binding: ActivityAction1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAction1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        intent()
    }

    private fun intent() {
        val namaLengkap = intent.getStringExtra(MainActivity.INTENT_FULL_NAME)
        val namaPanggilan = intent.getStringExtra(MainActivity.INTENT_NICKNAME)
        val umur = intent.getIntExtra(MainActivity.INTENT_AGE, 0)
        val alamat = intent.getStringExtra(MainActivity.INTENT_ADDRESS)

        binding.tvIsiIntent.text =
            getString(R.string.isi_intent,
                namaLengkap,
                namaPanggilan,
                umur.toString(),
                alamat)
    }

}

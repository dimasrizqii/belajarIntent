package com.example.belajarintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarintent.databinding.ActivityBundleBinding

class Bundle : AppCompatActivity() {
    private lateinit var binding: ActivityBundleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBundleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle()
    }

    private fun bundle(){
        val Bundle = intent.extras
        val namaLengkap = Bundle?.getString(MainActivity.BUNDLE_FULL_NAME)
        val namaPanggilan = Bundle?.getString(MainActivity.BUNDLE_NICKNAME)
        val umur = Bundle?.getInt(MainActivity.BUNDLE_AGE, 0)
        val alamat = Bundle?.getString(MainActivity.BUNDLE_ADDRESS)

        binding.tvIsiBundle.text =
            getString(R.string.isi_intent,
                namaLengkap,
                namaPanggilan,
                umur.toString(),
                alamat)
    }
}
package com.example.belajarintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSatuPerSatu.setOnClickListener{ action1() }
        binding.btnBundle.setOnClickListener{ actionBundle() }
        binding.btnSerializable.setOnClickListener{ actionSerializable() }
        binding.btnParcelable.setOnClickListener{ actionParcelable() }
    }

    private fun action1() {
        val namaLengkap = binding.etNamaLengkap.text
        val namaPanggilan = binding.etNamaPanggilan.text
        val umur = binding.etUmur.text
        val alamat = binding.etAlamat.text

        val intent = Intent(this,Action1::class.java)
        intent.putExtra(INTENT_FULL_NAME, namaLengkap.toString())
        intent.putExtra(INTENT_NICKNAME, namaPanggilan.toString())
        intent.putExtra(INTENT_AGE, umur.toString().toInt())
        intent.putExtra(INTENT_ADDRESS, alamat.toString())

        startActivity(intent)
    }

    private fun actionBundle(){
        val namaLengkap = binding.etNamaLengkap.text
        val namaPanggilan = binding.etNamaPanggilan.text
        val umur = binding.etUmur.text
        val alamat = binding.etAlamat.text

        val intent = Intent(this,Bundle::class.java)
        val bundle = Bundle()
        bundle.putString(BUNDLE_FULL_NAME, namaLengkap.toString())
        bundle.putString(BUNDLE_NICKNAME, namaPanggilan.toString())
        bundle.putString(BUNDLE_AGE, umur.toString())
        bundle.putString(BUNDLE_ADDRESS, alamat.toString())

        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun actionSerializable(){
        val namaLengkap = binding.etNamaLengkap.text
        val namaPanggilan = binding.etNamaPanggilan.text
        val umur = binding.etUmur.text
        val alamat = binding.etAlamat.text

        val user = User1(
            namaLengkap.toString(),
            namaPanggilan.toString(),
            umur.toString().toInt(),
            alamat.toString()
        )

        val serializableIntent = Intent(this, Serializable::class.java)
        serializableIntent.putExtra(USER_SERIALIZABLE, user)
        startActivity(serializableIntent)
    }

    private fun actionParcelable(){
        val namaLengkap = binding.etNamaLengkap.text
        val namaPanggilan = binding.etNamaPanggilan.text
        val umur = binding.etUmur.text
        val alamat = binding.etAlamat.text

        val user = User2(
            namaLengkap.toString(),
            namaPanggilan.toString(),
            umur.toString().toInt(),
            alamat.toString()
        )

        val parcelableIntent = Intent(this, Parcelable::class.java)
        parcelableIntent.putExtra(USER_PARCELABLE, user)
        startActivity(parcelableIntent)
    }

    companion object {
        const val USER_SERIALIZABLE = "user_serializable"
        const val USER_PARCELABLE = "user_parcelable"

        const val INTENT_FULL_NAME = "intent_full_name"
        const val INTENT_NICKNAME = "intent_nickname"
        const val INTENT_AGE = "intent_age"
        const val INTENT_ADDRESS = "intent_address"

        const val BUNDLE_FULL_NAME = "bundle_full_name"
        const val BUNDLE_NICKNAME = "bundle_nickname"
        const val BUNDLE_AGE = "bundle_age"
        const val BUNDLE_ADDRESS = "bundle_address"
    }
}
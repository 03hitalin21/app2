package com.example.simpletextcounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simpletextcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCount.setOnClickListener {
            updateCounts()
        }

        binding.buttonClear.setOnClickListener {
            binding.inputText.text?.clear()
            setCounts(0, 0)
        }

        setCounts(0, 0)
    }

    private fun updateCounts() {
        val text = binding.inputText.text?.toString().orEmpty()
        val characterCount = text.length
        val wordCount = text.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.size
        setCounts(characterCount, wordCount)
    }

    private fun setCounts(characterCount: Int, wordCount: Int) {
        binding.textCharacterCountValue.text = characterCount.toString()
        binding.textWordCountValue.text = wordCount.toString()
    }
}

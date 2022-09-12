package com.banquemisr.coffeeapp_banquemisr.presentation.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()


    }

    private fun setListeners() {
        addRemoveButton()

    }

    private fun addRemoveButton() {
        var i = 0
        var isSmall: Boolean = true
        var isMedium: Boolean = false
        var isLarge: Boolean = false
        var itemPrice = 10
        var totalPrice = 0
        binding.addButton.setOnClickListener {
            i++
            totalPrice = itemPrice * i
            binding.amountText.text = i.toString()
            binding.totalPriceText.text = totalPrice.toString()
        }

        binding.removeButton.setOnClickListener {
            if (i > 0) {
                i--
                totalPrice = itemPrice * i
                binding.amountText.text = i.toString()
                binding.totalPriceText.text = totalPrice.toString()

            }
        }
        binding.imgSmallSize.setOnClickListener {
//            binding.imgSmallSize
            isSmall = true
            if (isMedium) {
                totalPrice /= 2
                isMedium = false
            } else if (isLarge) {
                totalPrice /= 3
                isLarge = false
            }
            binding.totalPriceText.text = totalPrice.toString()

        }
        binding.imgMediumSize.setOnClickListener {
            isMedium = true
            if (isSmall) {
                totalPrice *= 2
                isSmall = false
            } else if (isLarge) {
                totalPrice -= itemPrice
                isLarge = false
            }
            binding.totalPriceText.text = totalPrice.toString()


        }
        binding.imgLargeSize.setOnClickListener {
            isLarge = true
            if (isSmall) {
                totalPrice *= 3
                isSmall = false
            } else if (isMedium) {
                totalPrice += itemPrice
                isMedium = false
            }
            binding.totalPriceText.text = totalPrice.toString()
        }

    }
}
package com.banquemisr.coffeeapp_banquemisr.presentation.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private var count: Int = 1
    private var sizeCurrentCoefficient: Float = 1.0f
    private var sizeSmallCoefficient: Float = 1.0f
    private var sizeMediumCoefficient: Float = 2.0f
    private var sizeLargeCoefficient: Float = 3.0f
    private var isSmall: Boolean = true
    private var isMedium: Boolean = false
    private var isLarge: Boolean = false
    private var itemPrice: Float = 10.0f
    private var totalPrice: Float = 10.0f


    lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemPrice = intent.getFloatExtra(Constants.KEY_MENU_PRICE, 0.0f)
        totalPrice = itemPrice //initially the total price is the item's price
        binding.itemName.text = intent.getStringExtra(Constants.KEY_MENU_NAME)
        binding.itemImage.setImageResource(intent.getIntExtra(Constants.KEY_MENU_ICON, 0))
        binding.amountText.text = count.toString()
        binding.totalPriceText.text = itemPrice.toString()


        setListeners()


    }

    private fun setListeners() {
        //add one button
        binding.addButton.setOnClickListener {
            addCup()
        }

        //remove one button
        binding.removeButton.setOnClickListener {

            removeCup()
        }

        //small cup
        binding.imgSmallSize.setOnClickListener {
            binding.imgSmallSize.alpha = 1.0f
            binding.imgMediumSize.alpha = 0.3f
            binding.imgLargeSize.alpha = 0.3f

            smallCup()
        }

        //medium cup
        binding.imgMediumSize.setOnClickListener {
            binding.imgMediumSize.alpha = 1.0f
            binding.imgSmallSize.alpha = 0.3f
            binding.imgLargeSize.alpha = 0.3f


            mediumCup()
        }

        //large cup
        binding.imgLargeSize.setOnClickListener {
            binding.imgLargeSize.alpha = 1.0f
            binding.imgSmallSize.alpha = 0.3f
            binding.imgMediumSize.alpha = 0.3f


            largeCup()
        }

    }

    private fun addCup() {
        count++
        totalPrice += itemPrice * sizeCurrentCoefficient
        binding.amountText.text = count.toString()
        binding.totalPriceText.text = totalPrice.toString()
    }

    private fun removeCup() {
        if (count > 1) {
            count--
            totalPrice -= itemPrice * sizeCurrentCoefficient
            binding.amountText.text = count.toString()
            binding.totalPriceText.text = totalPrice.toString()

        }
    }

    private fun smallCup() {
        //            binding.imgSmallSize
        isSmall = true
        sizeCurrentCoefficient = sizeSmallCoefficient

        if (isMedium) {
            totalPrice /= sizeMediumCoefficient
            isMedium = false
        } else if (isLarge) {
            totalPrice /= sizeLargeCoefficient
            isLarge = false
        }
        binding.totalPriceText.text = totalPrice.toString()
    }

    private fun mediumCup() {
        isMedium = true
        sizeCurrentCoefficient = sizeMediumCoefficient

        if (isSmall) {
            totalPrice *= sizeMediumCoefficient
            isSmall = false
        } else if (isLarge) {
            totalPrice *= sizeMediumCoefficient / sizeLargeCoefficient
            isLarge = false
        }
        binding.totalPriceText.text = totalPrice.toString()
    }

    private fun largeCup() {
        isLarge = true
        sizeCurrentCoefficient = sizeLargeCoefficient

        if (isSmall) {
            totalPrice *= sizeLargeCoefficient
            isSmall = false
        } else if (isMedium) {
            totalPrice *= sizeLargeCoefficient / sizeMediumCoefficient
            isMedium = false
        }
        binding.totalPriceText.text = totalPrice.toString()
    }

}
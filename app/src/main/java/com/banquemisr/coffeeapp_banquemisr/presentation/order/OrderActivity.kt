package com.banquemisr.coffeeapp_banquemisr.presentation.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private var count: Int = 1
    private var sizeCurrentCoefficient: Double = 1.0
    private var sizeSmallCoefficient: Double = 1.0
    private var sizeMediumCoefficient: Double = 2.0
    private var sizeLargeCoefficient: Double = 3.0
    private var isSmall: Boolean = true
    private var isMedium: Boolean = false
    private var isLarge: Boolean = false
    private var itemPrice: Double = 10.0
    private var totalPrice: Double = 10.0

    lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setListeners()
        binding.amountText.text = count.toString()
        binding.totalPriceText.text = itemPrice.toString()

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


//    private fun setListeners() {
//        addRemoveButton()
//
//    }
//
//    private fun addRemoveButton() {
//
//        binding.addButton.setOnClickListener {
//            count++
//            totalPrice = itemPrice * count
//            binding.amountText.text = count.toString()
//            binding.totalPriceText.text = totalPrice.toString()
//        }
//
//        binding.removeButton.setOnClickListener {
//            if (count > 0) {
//                count--
//                totalPrice = itemPrice * count
//                binding.amountText.text = count.toString()
//                binding.totalPriceText.text = totalPrice.toString()
//
//            }
//        }
//        binding.imgSmallSize.setOnClickListener {
////            binding.imgSmallSize
//            isSmall = true
//            if (isMedium) {
//                totalPrice /= 2
//                isMedium = false
//            } else if (isLarge) {
//                totalPrice /= 3
//                isLarge = false
//            }
//            binding.totalPriceText.text = totalPrice.toString()
//
//        }
//        binding.imgMediumSize.setOnClickListener {
//            isMedium = true
//            if (isSmall) {
//                totalPrice *= 2
//                isSmall = false
//            } else if (isLarge) {
//                totalPrice -= itemPrice
//                isLarge = false
//            }
//            binding.totalPriceText.text = totalPrice.toString()
//
//
//        }
//        binding.imgLargeSize.setOnClickListener {
//            isLarge = true
//            if (isSmall) {
//                totalPrice *= 3
//                isSmall = false
//            } else if (isMedium) {
//                totalPrice += itemPrice
//                isMedium = false
//            }
//            binding.totalPriceText.text = totalPrice.toString()
//        }
//
//    }
}
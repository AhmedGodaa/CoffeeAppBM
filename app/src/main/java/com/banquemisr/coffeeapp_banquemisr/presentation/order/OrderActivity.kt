package com.banquemisr.coffeeapp_banquemisr.presentation.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityOrderBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder
import com.banquemisr.coffeeapp_banquemisr.presentation.cart.CartViewModel
import com.banquemisr.coffeeapp_banquemisr.presentation.cart.CartViewModelProvider
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDB
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import kotlinx.coroutines.launch

class OrderActivity : AppCompatActivity() {

    private var count: Int = 1
    private var sizeCurrentCoefficient: Int = 1
    private var sizeSmallCoefficient: Int = 1
    private var sizeMediumCoefficient: Int = 2
    private var sizeLargeCoefficient: Int = 3
    private var isSmall: Boolean = true
    private var isMedium: Boolean = false
    private var isLarge: Boolean = false
    private var selectedSugar = -1
    private var itemPrice: Int = 10
    private var totalPrice: Int = 10
    private lateinit var viewModel: CartViewModel
    private var coffeeName: String = ""

    lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewModel
        val repo = CartRepo(CartDB.getDatabase(this))
        val cartViewModelProvider = CartViewModelProvider(repo)
        viewModel = ViewModelProvider(this, cartViewModelProvider)[CartViewModel::class.java]
//        end

        getOrderData()
        binding.itemImage.setImageResource(intent.getIntExtra(Constants.KEY_MENU_ICON, 0))
        binding.amountText.text = count.toString()
        binding.totalPriceText.text = itemPrice.toString()


        setListeners()


    }

    private fun getOrderData() {
        itemPrice = intent.getIntExtra(Constants.KEY_MENU_PRICE, 0)
        totalPrice = itemPrice //initially the total price is the item's price
        coffeeName = intent.getStringExtra(Constants.KEY_MENU_NAME).toString()
        binding.itemName.text = coffeeName


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
//        //no Sugar
//        binding.noSugar.setOnClickListener {
//            binding.noSugar.alpha = 1.0f
//            binding.oneSugar.alpha = 0.3f
//            binding.twoSugar.alpha = 0.3f
//            binding.threeSugar.alpha = 0.3f
//
//            selectedSugar = 0
//        }
//        //select one sugar
//        binding.oneSugar.setOnClickListener {
//            binding.noSugar.alpha = 0.3f
//            binding.oneSugar.alpha = 1.0f
//            binding.twoSugar.alpha = 0.3f
//            binding.threeSugar.alpha = 0.3f
//
//            selectedSugar = 0
//        }

//        // Select two sugar
//        binding.twoSugar.setOnClickListener {
//            binding.noSugar.alpha = 0.3f
//            binding.oneSugar.alpha = 0.3f
//            binding.twoSugar.alpha = 1.0f
//            binding.threeSugar.alpha = 0.3f
//
//            selectedSugar = 0
//        }

        binding.addToCartButton.setOnClickListener {
            var size = ""
            if (isLarge) {
                size = "large"

            } else if (isMedium) {
                size = "medium"
            } else if (isSmall) {
                size = "small"
            }
            val coffeeOrder = CoffeeOrder(
                name = intent.getStringExtra(Constants.KEY_MENU_NAME),
                count = count,
                size = size,
                sugar = "zero",
                totalPrice = totalPrice,
                icon = intent.getIntExtra(Constants.KEY_MENU_ICON, 0)
            )
            lifecycleScope.launch {
                viewModel.insertOrder(coffeeOrder)

            }
            finish()
        }


//        // Select three sugar
//        binding.threeSugar.setOnClickListener {
//            binding.noSugar.alpha = 0.3f
//            binding.oneSugar.alpha = 0.3f
//            binding.twoSugar.alpha = 0.3f
//            binding.threeSugar.alpha = 1.0f
//            selectedSugar = 0
//        }
//

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
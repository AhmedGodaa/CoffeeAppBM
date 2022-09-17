package com.banquemisr.coffeeapp_banquemisr.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.coffeeapp_banquemisr.data.repo.ProductRepository
import com.example.example.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private var _productsMutableLiveData = MutableLiveData<List<Product>>()
    val productLiveData: LiveData<List<Product>> = _productsMutableLiveData
    fun getProducts() = viewModelScope.launch(Dispatchers.Main) {
        val response = productRepository.getProducts()
        if (response.isSuccessful) {
            Log.d("Ahmed", "response success : ")

            _productsMutableLiveData.value = response.body()


        } else {
            Log.d("Ahmed", "response failed : ")
        }
    }

}
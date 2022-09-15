package com.example.example

import com.google.gson.annotations.SerializedName


data class ProductJsonObject (

    @SerializedName("cartProductId" ) var cartProductId : Int?     = null,
    @SerializedName("quantity"      ) var quantity      : Int?     = null,
    @SerializedName("product"       ) var product       : Product? = Product()

)


data class Product (

    @SerializedName("productId"            ) var productId            : Int?     = null,
    @SerializedName("productName"          ) var productName          : String?  = null,
    @SerializedName("productPrice"         ) var productPrice         : Int?     = null,
    @SerializedName("ProductImage"         ) var ProductImage         : String?  = null,
    @SerializedName("productSugarSpoon"    ) var productSugarSpoon    : Int?     = null,
    @SerializedName("isAddedToCart"        ) var isAddedToCart        : Boolean? = null,
    @SerializedName("boughtItemsCount"     ) var boughtItemsCount     : Int?     = null,
    @SerializedName("productStockQuantity" ) var productStockQuantity : Int?     = null,
    @SerializedName("ProductCategory"      ) var ProductCategory      : String?  = null,
    @SerializedName("addedToCart"          ) var addedToCart2          : Boolean? = null,
    @SerializedName("productImage"         ) var productImage2         : String?  = null,
    @SerializedName("productCategory"      ) var productCategory2      : String?  = null

)
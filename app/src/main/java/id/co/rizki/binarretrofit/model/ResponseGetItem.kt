package id.co.rizki.binarretrofit.model


import com.google.gson.annotations.SerializedName

data class ResponseGetItem(
    @SerializedName("categories")
    val categories: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)
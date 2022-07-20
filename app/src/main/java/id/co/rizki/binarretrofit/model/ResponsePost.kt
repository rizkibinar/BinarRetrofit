package id.co.rizki.binarretrofit.model


import com.google.gson.annotations.SerializedName

data class ResponsePost(
    @SerializedName("categories")
    val categories: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("title")
    val title: String
)
package id.co.rizki.binarretrofit.model


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: String
)
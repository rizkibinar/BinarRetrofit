package id.co.rizki.binarretrofit.network

import id.co.rizki.binarretrofit.model.ResponseGetItem
import id.co.rizki.binarretrofit.model.ResponsePost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * Created by Rizky Putra on 20/07/22.
 */
interface ApiService {

    @GET("/api/posts")
    fun getAllContentList() : Call<List<ResponseGetItem>>

    @POST("/api/posts")
    fun postContent(@Body responsePost: ResponsePost) : Call<ResponsePost>

}
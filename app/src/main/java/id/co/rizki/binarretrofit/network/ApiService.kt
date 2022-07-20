package id.co.rizki.binarretrofit.network

import id.co.rizki.binarretrofit.ResponseGetItem
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Rizky Putra on 20/07/22.
 */
interface ApiService {

    @GET("/api/posts")
    fun getAllContentList() : Call<List<ResponseGetItem>>

}
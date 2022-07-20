package id.co.rizki.binarretrofit

import id.co.rizki.binarretrofit.model.RegisterResponse
import id.co.rizki.binarretrofit.model.ResponsePost
import id.co.rizki.binarretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Rizky Putra on 20/07/22.
 */
class NewPostPresenter(private val listener: Listener) {

    fun addNewContent(responsePost: ResponsePost) {

        ApiClient.instance.postContent(responsePost)
            .enqueue(object : Callback<ResponsePost> {
                override fun onResponse(
                    call: Call<ResponsePost>,
                    response: Response<ResponsePost>
                ) {
                    if(response.isSuccessful)
                        listener.onAddContentSuccess("sukses menambah post")
                    else
                        listener.onAddContentFailed("gagal menambah post")
                }

                override fun onFailure(call: Call<ResponsePost>, t: Throwable) {
                    listener.onAddContentFailed("gagal menambah post")
                }

            })


        // contoh penggunaan 2 endpoint API
//        ApiClient.instanceApiNews.postContent(responsePost)
//            .enqueue(object : Callback<ResponsePost> {
//                override fun onResponse(
//                    call: Call<ResponsePost>,
//                    response: Response<ResponsePost>
//                ) {
//                    if(response.isSuccessful)
//                        listener.onAddContentSuccess("sukses menambah post")
//                    else
//                        listener.onAddContentFailed("gagal menambah post")
//                }
//
//                override fun onFailure(call: Call<ResponsePost>, t: Throwable) {
//                    listener.onAddContentFailed("gagal menambah post")
//                }
//
//            })

        // CONTOH HANDLE ERROR CASE CHALLENGE
//        ApiClient.instance.testAPI().enqueue(object : Callback<RegisterResponse> {
//            override fun onResponse(
//                call: Call<RegisterResponse>,
//                response: Response<RegisterResponse>
//            ) {
//                if(response.isSuccessful) {
//                    // execute code success
//                } else {
//                    val body = response.body()
//
//                    body?.error?.let {
//                        listener.onAddContentFailed(it)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
//                listener.onAddContentFailed("gagal request")
//            }
//
//        })

    }

    interface Listener {
        fun onAddContentSuccess(message: String)
        fun onAddContentFailed(message: String)
    }
}
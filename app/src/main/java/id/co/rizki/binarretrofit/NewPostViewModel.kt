package id.co.rizki.binarretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.rizki.binarretrofit.model.RegisterResponse
import id.co.rizki.binarretrofit.model.ResponseGetItem
import id.co.rizki.binarretrofit.model.ResponsePost
import id.co.rizki.binarretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Rizky Putra on 20/07/22.
 */
class NewPostViewModel() : ViewModel(){

    val responseData : MutableLiveData<Event<String>> = MutableLiveData()
    val responseDataError : MutableLiveData<Event<String>> = MutableLiveData()

    fun addNewContent(responsePost: ResponsePost) {

        ApiClient.instance.postContent(responsePost)
            .enqueue(object : Callback<ResponsePost> {
                override fun onResponse(
                    call: Call<ResponsePost>,
                    response: Response<ResponsePost>
                ) {
                    if(response.isSuccessful)
                        responseData.postValue(Event("sukses menambah post"))
                    else
                        responseDataError.postValue(Event("gagal menambah post"))
                }

                override fun onFailure(call: Call<ResponsePost>, t: Throwable) {
                    responseDataError.postValue(Event("gagal menambah post"))
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

}
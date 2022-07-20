package id.co.rizki.binarretrofit

import id.co.rizki.binarretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Rizky Putra on 20/07/22.
 */
class MainPresenter(val listener: Listener) {

    fun getContentList() {
        ApiClient.instance.getAllContentList().enqueue(object : Callback<List<ResponseGetItem>> {

            override fun onResponse(
                call: Call<List<ResponseGetItem>>,
                response: Response<List<ResponseGetItem>>
            ) {
                if(response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        listener.onGetContentListSuccess(body.toMutableList())
                    }
                } else listener.onGetContentListFailed("Gagal mengambil data")
            }

            override fun onFailure(call: Call<List<ResponseGetItem>>, t: Throwable) {
                listener.onGetContentListFailed("Gagal mengambil data")
            }

        })


    }



    interface Listener {
        fun onGetContentListSuccess(contentList: MutableList<ResponseGetItem>)
        fun onGetContentListFailed(message: String)
    }
}
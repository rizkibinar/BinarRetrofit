package id.co.rizki.binarretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.rizki.binarretrofit.model.ResponseGetItem
import id.co.rizki.binarretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Rizky Putra on 21/07/22.
 */
class MainViewModel : ViewModel() {

    val contentItem : MutableLiveData<List<ResponseGetItem>> = MutableLiveData()

    val errorMessage : MutableLiveData<Event<String>> = MutableLiveData()

    fun getContentList() {
        ApiClient.instance.getAllContentList().enqueue(object : Callback<List<ResponseGetItem>> {

            override fun onResponse(
                call: Call<List<ResponseGetItem>>,
                response: Response<List<ResponseGetItem>>
            ) {
                if(response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        contentItem.postValue(it.toMutableList())
                    }
                } else errorMessage.postValue(Event("Gagal mengambil data"))
            }

            override fun onFailure(call: Call<List<ResponseGetItem>>, t: Throwable) {
                errorMessage.postValue(Event("Gagal mengambil data"))
            }

        })


    }

}
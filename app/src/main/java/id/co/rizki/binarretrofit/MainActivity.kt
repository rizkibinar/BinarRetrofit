package id.co.rizki.binarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.rizki.binarretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainPresenter.Listener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupComponent()
    }

    override fun onStart() {
        super.onStart()

        presenter.getContentList()
        binding.pbLoading.visibility = View.VISIBLE

    }

    private fun setupComponent() {
        presenter = MainPresenter(this)
        adapter = MainAdapter()

        binding.rvContent.setHasFixedSize(true)
        binding.rvContent.layoutManager = LinearLayoutManager(this)
        binding.rvContent.adapter = adapter

    }

    override fun onGetContentListSuccess(contentList: MutableList<ResponseGetItem>) {
        binding.pbLoading.visibility = View.GONE
        adapter.addContentList(contentList)
    }

    override fun onGetContentListFailed(message: String) {
        binding.pbLoading.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
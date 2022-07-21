package id.co.rizki.binarretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.rizki.binarretrofit.databinding.ActivityMainBinding
import id.co.rizki.binarretrofit.model.ResponseGetItem

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupComponent()
        observeValue()
    }

    private fun observeValue() {
        viewModel.contentItem.observe(this) {
            binding.pbLoading.visibility = View.GONE
            adapter.addContentList(it.toMutableList())

        }

        viewModel.errorMessage.observe(this) { event ->
            binding.pbLoading.visibility = View.GONE
            
            event.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.getContentList()
        binding.pbLoading.visibility = View.VISIBLE

    }

    private fun setupComponent() {
        viewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(MainViewModel::class.java)
        adapter = MainAdapter()

        binding.rvContent.setHasFixedSize(true)
        binding.rvContent.layoutManager = LinearLayoutManager(this)
        binding.rvContent.adapter = adapter

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this,NewPostActivity::class.java))
        }

    }
}
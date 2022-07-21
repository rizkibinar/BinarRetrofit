package id.co.rizki.binarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.co.rizki.binarretrofit.databinding.ActivityNewPostBinding
import id.co.rizki.binarretrofit.model.ResponsePost

class NewPostActivity : AppCompatActivity(){

    lateinit var binding : ActivityNewPostBinding
    lateinit var viewModel: NewPostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPostBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setComponent()
        observeValue()

    }

    private fun observeValue() {
        viewModel.responseData.observe(this) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        viewModel.responseDataError.observe(this) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setComponent() {
        viewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(NewPostViewModel::class.java)

        with(binding) {
            btnKirim.setOnClickListener {

                val title = etTitle.text.toString()
                val category = etCategory.text.toString()
                val content = etContent.text.toString()

                val responsePost = ResponsePost(category, content, title)

                viewModel.addNewContent(responsePost)

            }
        }

    }
}
package id.co.rizki.binarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.rizki.binarretrofit.databinding.ActivityMainBinding
import id.co.rizki.binarretrofit.databinding.ActivityNewPostBinding
import id.co.rizki.binarretrofit.model.ResponsePost

class NewPostActivity : AppCompatActivity(), NewPostPresenter.Listener {

    lateinit var binding : ActivityNewPostBinding
    lateinit var presenter: NewPostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPostBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setComponent()

    }

    private fun setComponent() {
        presenter = NewPostPresenter(this)

        with(binding) {
            btnKirim.setOnClickListener {

                val title = etTitle.text.toString()
                val category = etCategory.text.toString()
                val content = etContent.text.toString()

                val responsePost = ResponsePost(category, content, title)

                presenter.addNewContent(responsePost)

            }
        }

    }

    override fun onAddContentSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onAddContentFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
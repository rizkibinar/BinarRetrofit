package id.co.rizki.binarretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.rizki.binarretrofit.databinding.ItemContentBinding


/**
 * Created by Rizky Putra on 20/07/22.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val contentList =  mutableListOf<ResponseGetItem>()

    fun addContentList(newList: MutableList<ResponseGetItem>) {
        contentList.clear()
        contentList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contentList[position])
    }

    override fun getItemCount(): Int = contentList.size

    inner class ViewHolder(private val holder: ItemContentBinding) : RecyclerView.ViewHolder(holder.root) {

        fun bind(item: ResponseGetItem) {

            holder.tvTitle.text = item.title
            holder.tvCategories.text = item.categories
            holder.tvContent.text = item.content
        }

    }

}
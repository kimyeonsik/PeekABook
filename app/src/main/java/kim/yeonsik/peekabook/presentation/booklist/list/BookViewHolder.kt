package kim.yeonsik.peekabook.presentation.booklist.list

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kim.yeonsik.peekabook.presentation.booklist.model.BookSummary
import kim.yeonsik.peekabook.util.fromUrl
import kotlinx.android.synthetic.main.fragment_booklist_item.view.*

class BookViewHolder(val view: View, override val context: Context = view.context): RecyclerView.ViewHolder(view), BookListItemContract.View {

    private val titleView: TextView = view.textview_book_title
    private val thumbnailView: ImageView = view.imageview_book_thumbnail
    private val presenter = BookPresenter(this)

    override fun bind(item: BookSummary) {
        presenter.loadItem(item)
    }

    override fun showThumbnailImage(url: String) {
        thumbnailView.fromUrl(url)
    }

    override fun showTitle(title: String) {
        this.titleView.text = title
    }
}
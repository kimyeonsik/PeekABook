package kim.yeonsik.peekabook.presentation.booklist.list

import android.content.Context
import kim.yeonsik.peekabook.presentation.booklist.model.BookSummary

interface BookListItemContract {
    interface View {
        val context: Context
        fun bind(item: BookSummary)
        fun showThumbnailImage(url: String)
        fun showTitle(title: String)
    }

    interface Presenter {
        val view: View
        fun loadItem(item: BookSummary)
    }
}
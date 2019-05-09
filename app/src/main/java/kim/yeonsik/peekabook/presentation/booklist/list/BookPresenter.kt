package kim.yeonsik.peekabook.presentation.booklist.list

import kim.yeonsik.peekabook.presentation.booklist.model.BookSummary

class BookPresenter(override val view: BookListItemContract.View) : BookListItemContract.Presenter {
    override fun loadItem(item: BookSummary) {
        view.showTitle(item.title)
        view.showThumbnailImage(item.thumbnail)
    }
}
package kim.yeonsik.peekabook.presentation.booklist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kim.yeonsik.peekabook.domain.UseCase
import kim.yeonsik.peekabook.domain.booklist.usecase.GetBooksByTitle
import kim.yeonsik.peekabook.domain.model.Book
import kim.yeonsik.peekabook.presentation.booklist.model.mapToBookSummary
import kim.yeonsik.peekabook.util.BookListLiveData
import kim.yeonsik.peekabook.util.MainThreadExecutor

class BookListViewModel(private val useCase: GetBooksByTitle) : ViewModel() {
    val books = BookListLiveData()
    val isLoading = MutableLiveData<Boolean>()
    val isEmptyList = MutableLiveData<Boolean>()

    private var nextPage = -1
    private fun isLastPage(): Boolean {
        return nextPage == -1
    }

    private lateinit var keyword: String

    private val callback = object : UseCase.Callback<List<Book>> {
        override fun onSuccess(result: List<Book>, nextPage: Int) {
            this@BookListViewModel.nextPage = nextPage

            MainThreadExecutor().execute {
                books.addAll(result.mapToBookSummary())
            }

            isEmptyList.postValue(false)
            isLoading.postValue(false)
        }

        override fun onFailed() {
            isEmptyList.postValue(true)
            isLoading.postValue(false)
        }
    }

    fun loadBooks(keyword: String, withClean: Boolean) {
        if(keyword.isEmpty()) return

        isLoading.postValue(true)
        if(withClean) books.clear()
        useCase.get(keyword, 1, callback)
        this@BookListViewModel.keyword = keyword
    }

    fun loadMoreBooksIfNeeded(ifNeeded: Boolean) {
        if(ifNeeded && !isLastPage()) {
            isLoading.postValue(true)
            useCase.get(keyword, nextPage, callback)
        }
    }

    fun initListIsEmpty() {
        if (books.value!!.isEmpty()) {
            isEmptyList.postValue(true)
        } else {
            isEmptyList.postValue(false)
        }
    }
}
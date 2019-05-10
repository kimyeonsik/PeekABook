package kim.yeonsik.peekabook.presentation.bookdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kim.yeonsik.peekabook.domain.UseCase
import kim.yeonsik.peekabook.domain.bookdetail.usecase.GetBookByIsbn
import kim.yeonsik.peekabook.domain.model.Book
import kim.yeonsik.peekabook.presentation.bookdetail.model.BookDetails
import kim.yeonsik.peekabook.presentation.bookdetail.model.toBookDetails

class BookDetailViewModel(private val useCase: GetBookByIsbn) : ViewModel() {
    val book = MutableLiveData<BookDetails>()
    val isLoading = MutableLiveData<Boolean>()

    fun loadBook(isbn: String) {
        isLoading.postValue(true)
        useCase.get(isbn, object : UseCase.Callback<Book>{
            override fun onSuccess(result: Book, nextPage: Int) {
                isLoading.postValue(false)
                book.postValue(result.toBookDetails())
            }

            override fun onFailed() {
                isLoading.postValue(false)
            }

        })
    }
}

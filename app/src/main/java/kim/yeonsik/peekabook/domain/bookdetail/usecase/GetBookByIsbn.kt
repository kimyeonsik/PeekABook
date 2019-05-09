package kim.yeonsik.peekabook.domain.bookdetail.usecase

import kim.yeonsik.peekabook.domain.UseCase
import kim.yeonsik.peekabook.domain.model.Book
import kim.yeonsik.peekabook.domain.repository.BookRepository
import java.util.concurrent.Executors

class GetBookByIsbn(private val bookRepository: BookRepository) : UseCase<Book> {
    private val runner = Executors.newSingleThreadExecutor()
    fun get(isbn: String, callback: UseCase.Callback<Book>) {
        runner.execute {
            val result = bookRepository.get(isbn)
            if (result.isEmpty) {
                callback.onFailed()
            } else {
                callback.onSuccess(result, -1)
            }
        }
    }
}
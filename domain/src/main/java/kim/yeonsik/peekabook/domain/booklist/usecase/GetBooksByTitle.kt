package kim.yeonsik.peekabook.domain.booklist.usecase

import kim.yeonsik.peekabook.domain.UseCase
import kim.yeonsik.peekabook.domain.model.Book
import kim.yeonsik.peekabook.domain.repository.BookRepository
import java.util.concurrent.Executors

class GetBooksByTitle(private val bookRepository: BookRepository) :
    UseCase<List<Book>> {
    private val runner = Executors.newSingleThreadExecutor()
    fun get(keyword: String, page: Int, callback: UseCase.Callback<List<Book>>) {
        runner.execute {
            val result = bookRepository.get(keyword, page)
            if (result.isNotEmpty()) {
                if (result.any { it.isLastBook }) {
                    callback.onSuccess(result, -1)
                } else {
                    callback.onSuccess(result, page + 1)
                }
            } else {
                callback.onFailed()
            }
        }
    }
}
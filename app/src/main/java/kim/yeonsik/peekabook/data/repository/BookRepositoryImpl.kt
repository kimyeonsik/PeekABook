package kim.yeonsik.peekabook.data.repository

import kim.yeonsik.peekabook.data.source.RemoteBookDataSource
import kim.yeonsik.peekabook.domain.model.Book
import kim.yeonsik.peekabook.domain.repository.BookRepository


class BookRepositoryImpl(private val webDataSource: RemoteBookDataSource): BookRepository {
    override fun get(title: String, page: Int): List<Book> {
        return webDataSource.get(title, page)
    }

    override fun get(isbn: String): Book {
        return webDataSource.get(isbn)
    }
}
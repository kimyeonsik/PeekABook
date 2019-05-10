package kim.yeonsik.peekabook.domain.repository

import kim.yeonsik.peekabook.domain.model.Book

interface BookRepository {
    fun get(title: String, page: Int): List<Book>
    fun get(isbn: String): Book
}
package kim.yeonsik.peekabook.data.source

import kim.yeonsik.peekabook.domain.model.Book

interface LocalBookDataSource {
    fun get(title: String, page: Int): List<Book>
    fun get(isbn: String): Book
    fun set(books: List<Book>)
    fun set(book: Book)
}

interface RemoteBookDataSource {
    fun get(title: String, page: Int): List<Book>
    fun get(isbn: String): Book
}
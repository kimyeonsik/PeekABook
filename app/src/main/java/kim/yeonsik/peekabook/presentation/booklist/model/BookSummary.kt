package kim.yeonsik.peekabook.presentation.booklist.model

import kim.yeonsik.peekabook.domain.model.Book

data class BookSummary(val title: String, val isbn: String, val thumbnail: String)

fun List<Book>.mapToBookSummary(): List<BookSummary> {
    return this.map { book ->
        BookSummary(book.title, book.isbn.first { it.isNotEmpty() }, book.thumbnail)
    }
}
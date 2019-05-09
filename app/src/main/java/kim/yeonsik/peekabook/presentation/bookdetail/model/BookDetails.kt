package kim.yeonsik.peekabook.presentation.bookdetail.model

import kim.yeonsik.peekabook.domain.model.Book

data class BookDetails(
    val authors: String,
    val contents: String,
    val isbn: String,
    val price: Int,
    val publisher: String,
    val salePrice: Int,
    val status: String,
    val thumbnail: String,
    val title: String,
    val translators: String
)

fun Book.toBookDetails(): BookDetails {
    return BookDetails(authors.joinToString(", "), contents, isbn.joinToString(", "), price, publisher, salePrice, status, thumbnail, title, translators.joinToString(", "))

}
package kim.yeonsik.peekabook.data.source.web

import kim.yeonsik.peekabook.data.source.RemoteBookDataSource
import kim.yeonsik.peekabook.domain.model.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksWebDataSource: RemoteBookDataSource {

    private val bookApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/v3/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookApiService::class.java)
    }

    override fun get(title: String, page: Int): List<Book> {
        val response = bookApiService.queryBooks(title, Target.TITLE.value, page = page).execute()
        return if(response.isSuccessful) {
            val body = response.body()!!
            if(body.meta.isEnd) {
                body.mapToBook().markAsLastBooks()
            } else {
                body.mapToBook()
            }
        } else {
            listOf()
        }
    }

    override fun get(isbn: String): Book {
        val response = bookApiService.queryBooks(isbn, Target.ISBN.value).execute()
        return if(response.isSuccessful) {
            response.body()!!.mapToBook().first()
        } else {
            Book.empty()
        }
    }

    private fun List<Book>.markAsLastBooks(): List<Book> {
        return this.map { it.markAsLast() }
    }

    private fun BookResponse.mapToBook(): List<Book> {
        return this.documents.map { it.toBook() }
    }

    private fun Book.markAsLast(): Book {
        return Book(
            authors,
            contents,
            datetime,
            isbn,
            price,
            publisher,
            salePrice,
            status,
            thumbnail,
            title,
            translators,
            isLastBook = true
        )
    }

    private fun Document.toBook(): Book {
        return Book(
            authors,
            contents,
            datetime,
            isbn.split(" "),
            price,
            publisher,
            salePrice,
            status,
            thumbnail,
            title,
            translators
        )
    }
}
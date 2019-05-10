package kim.yeonsik.peekabook.util

import androidx.lifecycle.LiveData
import kim.yeonsik.peekabook.presentation.booklist.model.BookSummary

class BookListLiveData: LiveData<List<BookSummary>>() {
    private val list = mutableListOf<BookSummary>()

    init {
        value = list
    }

    fun add(item: BookSummary) {
        list.add(item)
        this.value = list
    }

    fun addAll(items: List<BookSummary>) {
        list.addAll(items)
        this.value = list
    }

    fun clear() {
        list.clear()
        this.value = list
    }

    fun get(index: Int): BookSummary {
        return list[index]
    }

    val size: Int
        get() = list.size
}
package kim.yeonsik.peekabook.domain.model


data class Book constructor(
    val authors: List<String> = listOf(),
    val contents: String = "",
    val datetime: String = "",
    val isbn: List<String> = listOf(),
    val price: Int = 0,
    val publisher: String = "",
    val salePrice: Int = 0,
    val status: String = "",
    val thumbnail: String = "",
    val title: String = "",
    val translators: List<String> = listOf(),
    val url: String = "",
    val isEmpty: Boolean = false,
    val isLastBook: Boolean = false
) {
    companion object {
        fun empty(): Book {
            return Book(isEmpty = true, isLastBook = true)
        }
    }
}

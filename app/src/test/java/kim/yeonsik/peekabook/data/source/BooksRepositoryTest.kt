//package kim.yeonsik.bookpeek.data.source
//
//import kim.yeonsik.peekabook.data.source.BooksMockDataSource
//import kim.yeonsik.peekabook.data.source.BooksRepository
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//
//class BooksRepositoryTest {
//
//    private lateinit var booksRepository: BooksRepository
//
//    @Before
//    fun setUp() {
//        booksRepository = BooksRepository(BooksMockDataSource())
//    }
//
//    @Test
//    fun getBookByISBN1161750711() {
//        booksRepository.getBooks("1161750711", Target.ISBN, 1) { books, isLastPage ->
//            with(books.first()) {
//                assertEquals("드미트리 제메로프", authors[0])
//                assertEquals("스베트라나 이사코바", authors[1])
//                assertEquals("코틀린이 안드로이드 공식 언어가 되면서 관심이 커졌다. 이 책은 코틀린 언어를 개발한 젯브레인의 코틀린 컴파일러 개발자들이 직접 쓴 일종의 공식 서적이라 할 수 있다. 코틀린 언어의 가장 큰 특징이라면 실용성을 들 수 있을 것이다. 이 책에서도 실용성을 강조하는 입장에서 쓰였다. 코틀린 기초를 소개하고, 고차함수, 객체지향, 제네릭스 등의 내용을 설명한다. 그리고 코틀린이 자바 언어를 어떻게 개선했고 기존 자바 프로젝트에서 코틀린을 함께 사용할 때", contents)
//                assertEquals("2017-10-31T00:00:00.000+09:00", datetime)
//                assertEquals("1161750711", isbn[0])
//                assertEquals("9791161750712", isbn[1])
//                assertEquals(36000, price)
//                assertEquals("에이콘출판", publisher)
//                assertEquals(32400, salePrice)
//                assertEquals("정상판매", status)
//                assertEquals("https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F1603005%3Ftimestamp%3D20190131052537", thumbnail)
//                assertEquals("Kotlin in Action(모바일 프로그래밍)(Paperback)", title)
//                assertEquals("오현석", translators)
//            }
//        }
//    }
//
//    @Test
//    fun getBooksByTitleKotlin() {
//        booksRepository.getBooks("android", Target.TITLE, 1) { books, isLastPage ->
//            assertEquals(3, books.size)
//            books.forEach { book ->
//                println(book.title)
//                assertEquals(false, book.isEmpty)
//            }
//        }
//    }
//}
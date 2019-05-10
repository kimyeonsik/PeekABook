//package kim.yeonsik.peekabook.data.source
//
//import com.google.gson.Gson
//import kim.yeonsik.peekabook.domain.model.Book
//import kim.yeonsik.peekabook.data.source.web.BookResponse
//import kim.yeonsik.peekabook.data.source.web.Document
//
//class BooksMockDataSource: BookDataSource {
//    override val priority: Int = 1
//
//    private val json = "{\"documents\":[{\"authors\":[\"엄민석\"],\"contents\":\"프로그래밍을 처음 배워도, 경험이 있어도 모두 도전!  이 책은 프로그래밍 입문자의 시선에서 코틀린을 설명한 입문서이다. 코틀린은 함수형 프로그래밍을 지원하는 언어이기 때문에 문제 접근 방식이 객체지향 언어인 자바와는 조금 다르다. 마치 C언어에서 Java로 넘어갈 때 객체지향이라는 패러다임을 받아들이는 것처럼, 코틀린을 배우려면 새로운 패러다임인 함수형 프로그래밍을 받아들여야 한다.  코틀린은 자바에서 지나치게 길었던 상용구 코드를 줄여주는 문법들\",\"datetime\":\"2018-05-20T00:00:00.000+09:00\",\"isbn\":\"8956747814 9788956747811\",\"price\":27000,\"publisher\":\"정보문화사\",\"sale_price\":24300,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F741977%3Ftimestamp%3D20190124180711\",\"title\":\"초보자를 위한 코틀린(Kotlin) 200제\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=741977\\u0026q=%EC%B4%88%EB%B3%B4%EC%9E%90%EB%A5%BC+%EC%9C%84%ED%95%9C+%EC%BD%94%ED%8B%80%EB%A6%B0%28Kotlin%29+200%EC%A0%9C\"},{\"authors\":[\"드미트리 제메로프\",\"스베트라나 이사코바\"],\"contents\":\"코틀린이 안드로이드 공식 언어가 되면서 관심이 커졌다. 이 책은 코틀린 언어를 개발한 젯브레인의 코틀린 컴파일러 개발자들이 직접 쓴 일종의 공식 서적이라 할 수 있다. 코틀린 언어의 가장 큰 특징이라면 실용성을 들 수 있을 것이다. 이 책에서도 실용성을 강조하는 입장에서 쓰였다. 코틀린 기초를 소개하고, 고차함수, 객체지향, 제네릭스 등의 내용을 설명한다. 그리고 코틀린이 자바 언어를 어떻게 개선했고 기존 자바 프로젝트에서 코틀린을 함께 사용할 때\",\"datetime\":\"2017-10-31T00:00:00.000+09:00\",\"isbn\":\"1161750711 9791161750712\",\"price\":36000,\"publisher\":\"에이콘출판\",\"sale_price\":32400,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F1603005%3Ftimestamp%3D20190131052537\",\"title\":\"Kotlin in Action(모바일 프로그래밍)(Paperback)\",\"translators\":[\"오현석\"],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=1603005\\u0026q=Kotlin+in+Action%28%EB%AA%A8%EB%B0%94%EC%9D%BC+%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%29%28Paperback%29\"},{\"authors\":[\"Soshin Alexey\"],\"contents\":\"\",\"datetime\":\"2018-11-29T00:00:00.000+09:00\",\"isbn\":\"1788998014 9781788998017\",\"price\":39000,\"publisher\":\"Packt Publishing\",\"sale_price\":38610,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F4819185%3Ftimestamp%3D20190302225933\",\"title\":\"Hands-On Design Patterns with Kotlin\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=4819185\\u0026q=Hands-On+Design+Patterns+with+Kotlin\"},{\"authors\":[\"Sp?h Peter\"],\"contents\":\"\",\"datetime\":\"2018-10-28T00:00:00.000+09:00\",\"isbn\":\" 9781484238196\",\"price\":68390,\"publisher\":\"\",\"sale_price\":54030,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F4840830%3Ftimestamp%3D20190303023528\",\"title\":\"Pro Android with Kotlin\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=4840830\\u0026q=Pro+Android+with+Kotlin\"},{\"authors\":[\"Igor Kucherenko\"],\"contents\":\"\",\"datetime\":\"2018-10-01T00:00:00.000+09:00\",\"isbn\":\"178899664X 9781788996648\",\"price\":35000,\"publisher\":\"Packt\",\"sale_price\":34650,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F3782745\",\"title\":\"Mastering High Performance with Kotlin\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=3782745\\u0026q=Mastering+High+Performance+with+Kotlin\"},{\"authors\":[\"Skeen Josh\"],\"contents\":\"\",\"datetime\":\"2018-07-05T00:00:00.000+09:00\",\"isbn\":\" 9780135161630\",\"price\":61550,\"publisher\":\"\",\"sale_price\":48620,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F4839715%3Ftimestamp%3D20190303022825\",\"title\":\"Kotlin Programming\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=4839715\\u0026q=Kotlin+Programming\"},{\"authors\":[\"Marcin Moskala\",\"Igor Wojda\"],\"contents\":\"\",\"datetime\":\"2018-03-01T00:00:00.000+09:00\",\"isbn\":\"1787123685 9781787123687\",\"price\":45000,\"publisher\":\"Packt Publishing\",\"sale_price\":44550,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F3631559\",\"title\":\"Android Development with Kotlin\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=3631559\\u0026q=Android+Development+with+Kotlin\"},{\"authors\":[\"Jemerov Dmitry\",\"Isakova Svetlana\"],\"contents\":\"from Manning Publications. About the Technology Developers want to get work done - and the less hassle, the better. Coding with Kotlin means less hassle. The Kotlin programming language offers an expressive syntax, a strong intuitive type system, and great tooling\",\"datetime\":\"2017-03-31T00:00:00.000+09:00\",\"isbn\":\"1617293296 9781617293290\",\"price\":55000,\"publisher\":\"Manning Publications\",\"sale_price\":46750,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F3577519\",\"title\":\"Kotlin in Action\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=3577519\\u0026q=Kotlin+in+Action\"},{\"authors\":[\"박중수\"],\"contents\":\"이 책은 자바에 대한 지식이 있는 사람이라면 예제를 통해 쉽고 빠르게 코틀린의 문법을 배울 수 있다. 또한 코틀린 1.1버전에 추가된 코루틴이나 typealias에 대한 내용도 접할 수 있다.  예제로 안드로이드 어플리케이션을 코틀린과 자바로 동시에 개발하며 둘의 차이를 비교해보고, 코틀린으로 Realm 데이터베이스를 사용하는 법도 익힐 수 있다. 그 후 ANKO 라이브러리를 사용해 개발해 놓은 예제코드를 개선해보며 세련된 안드로이드 개발을 경험해\",\"datetime\":\"2017-12-05T00:00:00.000+09:00\",\"isbn\":\"8960882151 9788960882157\",\"price\":20000,\"publisher\":\"디지털북스\",\"sale_price\":18000,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F841167%3Ftimestamp%3D20190125092122\",\"title\":\"자바 개발자를 위한 KOTLIN\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=841167\\u0026q=%EC%9E%90%EB%B0%94+%EA%B0%9C%EB%B0%9C%EC%9E%90%EB%A5%BC+%EC%9C%84%ED%95%9C+KOTLIN\"},{\"authors\":[\"Milos Vasic\"],\"contents\":\"\",\"datetime\":\"2018-02-01T00:00:00.000+09:00\",\"isbn\":\"1788473698 9781788473699\",\"price\":39000,\"publisher\":\"Packt Publishing\",\"sale_price\":38610,\"status\":\"정상판매\",\"thumbnail\":\"https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F3465554%3Ftimestamp%3D20190221025528\",\"title\":\"Mastering Android Development with Kotlin\",\"translators\":[],\"url\":\"https://search.daum.net/search?w=bookpage\\u0026bookId=3465554\\u0026q=Mastering+Android+Development+with+Kotlin\"}],\"meta\":{\"is_end\":false,\"pageable_count\":54,\"total_count\":54}}\n"
//    private val response by lazy {
//        Gson().fromJson(json, BookResponse::class.java)
//    }
//
//    override fun getBooks(queryWord: String, target: String, page: Int, onLoaded: (List<Book>, Boolean) -> Unit) {
//        onLoaded(response.getBooks(queryWord, target), false)
//    }
//
//    private fun BookResponse.getBooks(queryWord: String, target: String): List<Book> {
//        return when(target) {
//            Target.TITLE.value -> this.documents.filter { it.title.contains(queryWord, true) }.map { it.toBook() }
//            Target.ISBN.value -> this.documents.filter { it.isbn.contains(queryWord, true) }.map { it.toBook() }
//            Target.PERSON.value -> this.documents.filter {
//                var result = false
//                it.authors.forEach { author ->
//                    result = author.contains(queryWord)
//                }
//                result
//            }.map { it.toBook() }
//            else -> listOf()
//        }
//
//    }
//
//    private fun Document.toBook(): Book {
//        return Book(
//            authors,
//            contents,
//            datetime,
//            isbn.split(" "),
//            price,
//            publisher,
//            salePrice,
//            status,
//            thumbnail,
//            title,
//            translators.joinToString(", ")
//        )
//    }
//}
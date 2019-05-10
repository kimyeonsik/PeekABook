package kim.yeonsik.peekabook.data.source.web

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.*



interface BookApiService {
    @Headers("Authorization: KakaoAK 5efdae06922699c54cf5046a527e7233")
    @GET("book")
    fun queryBooks(@Query("query") query: String, @Query("target") target: String, @Query("size") size: Int = 50, @Query("page") page: Int = 1): Call<BookResponse>
}

enum class Target(val value: String) {
    TITLE("title"),
    ISBN("isbn")
}

data class BookResponse(val meta: Meta, val documents: List<Document>)

data class Meta(
    @SerializedName("is_end") val isEnd: Boolean,
    @SerializedName("pageable_count") val pageableCount: Int,
    @SerializedName("total_count") val totalCount: Int
)

data class Document(
    @SerializedName("authors") val authors: List<String>,
    @SerializedName("contents") val contents: String,
    @SerializedName("datetime") val datetime: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("price") val price: Int,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("sale_price") val salePrice: Int,
    @SerializedName("status") val status: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title") val title: String,
    @SerializedName("translators") val translators: List<String>,
    @SerializedName("url") val url: String
)
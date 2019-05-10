package kim.yeonsik.peekabook.domain

interface UseCase<R> {
    interface Callback<R> {
        fun onSuccess(result: R, nextPage: Int)
        fun onFailed()
    }
}

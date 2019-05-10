package kim.yeonsik.peekabook.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class MainThreadExecutor: Executor {
    private val mainThreadHandler = Handler(Looper.getMainLooper())

    override fun execute(runnable: Runnable) {
        mainThreadHandler.post(runnable)
    }
}
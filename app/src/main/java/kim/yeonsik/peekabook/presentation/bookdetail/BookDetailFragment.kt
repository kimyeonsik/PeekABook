package kim.yeonsik.peekabook.presentation.bookdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kim.yeonsik.peekabook.R
import kim.yeonsik.peekabook.databinding.FragmentBookdetailBinding
import kim.yeonsik.peekabook.util.fromUrl
import kotlinx.android.synthetic.main.fragment_bookdetail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookDetailFragment : Fragment() {

    companion object {

        const val BUNDLE_KEY_ISBN = "isbn"

        fun newInstance(isbn: String): Fragment {
            return BookDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_KEY_ISBN, isbn)
                }
            }
        }
    }

    private lateinit var dataBinding: FragmentBookdetailBinding
    private val bookDetailViewModel: BookDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate<FragmentBookdetailBinding>(inflater, R.layout.fragment_bookdetail, container, false).apply {
//            bookDetailViewModel = ViewModelProviders.of(this@BookDetailFragment).get(BookDetailViewModel::class.java).also { vm = it }
            vm = bookDetailViewModel
            lifecycleOwner = this@BookDetailFragment
        }
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bookDetailViewModel.book.observe(this, Observer {
            imageView_thumbnail.fromUrl(it.thumbnail)
            dataBinding.book = it
        })

        if (arguments != null) {
            val isbn = arguments!!.getString(BUNDLE_KEY_ISBN)
            bookDetailViewModel.loadBook(isbn)
            arguments = null
        }
    }
}

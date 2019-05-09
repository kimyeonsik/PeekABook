package kim.yeonsik.peekabook.presentation.booklist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kim.yeonsik.peekabook.R
import kim.yeonsik.peekabook.databinding.FragmentBooklistListBinding
import kim.yeonsik.peekabook.presentation.booklist.list.BookListRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_booklist_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookListFragment : Fragment() {

    companion object {
        private const val KEY_KEYWORD = "keyword"
        private const val KEY_CLEAR = "clear"

        fun newInstance(): BookListFragment {
            return BookListFragment()
        }

        fun newInstance(keyword: String, clear: Boolean): BookListFragment {
            return BookListFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_KEYWORD, keyword)
                    putBoolean(KEY_CLEAR, clear)
                }
            }
        }
    }

    private lateinit var dataBinding: FragmentBooklistListBinding
    private val viewModel: BookListViewModel by viewModel()
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate<FragmentBooklistListBinding>(
            inflater,
            R.layout.fragment_booklist_list,
            container,
            false
        ).apply {
            vm = viewModel
            lifecycleOwner = this@BookListFragment
        }
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(list_book) {
            adapter = BookListRecyclerViewAdapter(this@BookListFragment, listener)
            layoutManager = LinearLayoutManager(context)

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    viewModel.loadMoreBooksIfNeeded(moreItemNeeded)
                }
            })
        }

        if (arguments != null) {
            val keyword = arguments!!.getString(KEY_KEYWORD)!!
            val clear = arguments!!.getBoolean(KEY_CLEAR)
            viewModel.loadBooks(keyword, clear)
            arguments = null
        } else {
            viewModel.initListIsEmpty()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private val RecyclerView.moreItemNeeded
        get() = !this.canScrollVertically(1)

    interface OnFragmentInteractionListener {
        fun onListItemClick(isbn: String)
    }
}

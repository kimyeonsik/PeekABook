package kim.yeonsik.peekabook.presentation.booklist.list


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kim.yeonsik.peekabook.R
import kim.yeonsik.peekabook.presentation.booklist.BookListFragment.OnFragmentInteractionListener
import kim.yeonsik.peekabook.presentation.booklist.BookListViewModel
import kim.yeonsik.peekabook.util.MainThreadExecutor

class BookListRecyclerViewAdapter(
    fragment: Fragment,
    private val interactionListener: OnFragmentInteractionListener?
) : RecyclerView.Adapter<BookViewHolder>() {

    private val viewModel = ViewModelProviders.of(fragment).get(BookListViewModel::class.java)

    init {
        viewModel.books.observe(fragment, Observer {
            MainThreadExecutor().execute {
                this.notifyDataSetChanged()
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_booklist_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = viewModel.books.get(position)

        holder.bind(item)
        holder.view.setOnClickListener {
            interactionListener?.onListItemClick(item.isbn)
        }
    }

    override fun getItemCount(): Int = viewModel.books.size
}

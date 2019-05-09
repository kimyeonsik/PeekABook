package kim.yeonsik.peekabook.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kim.yeonsik.peekabook.R
import kim.yeonsik.peekabook.presentation.bookdetail.BookDetailFragment
import kim.yeonsik.peekabook.presentation.booklist.BookListFragment
import kim.yeonsik.peekabook.util.addFragment
import kim.yeonsik.peekabook.util.replaceFragment
import kim.yeonsik.peekabook.util.replaceFragmentWithoutBackStack
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity(), BookListFragment.OnFragmentInteractionListener {
    private lateinit var searchMenu: MenuItem
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            initListFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        searchMenu = menu?.findItem(R.id.action_search) as MenuItem
        searchView = searchMenu.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                moveToQueryFragment(query!!)
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onListItemClick(isbn: String) {
        moveToDetails(isbn)
        closeSearchMode()
    }

    private fun initListFragment() {
        addFragment(R.id.container, BookListFragment.newInstance())
    }

    private fun moveToQueryFragment(keyword: String) {
        replaceFragmentWithoutBackStack(R.id.container, BookListFragment.newInstance(keyword, true))
    }

    private fun moveToDetails(isbn: String) {
        replaceFragment(R.id.container, BookDetailFragment.newInstance(isbn))
    }

    private fun closeSearchMode() {
        searchView.clearFocus()
        searchMenu.collapseActionView()
    }
}

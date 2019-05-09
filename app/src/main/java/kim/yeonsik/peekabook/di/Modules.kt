package kim.yeonsik.peekabook.di

import kim.yeonsik.peekabook.data.repository.BookRepositoryImpl
import kim.yeonsik.peekabook.data.source.RemoteBookDataSource
import kim.yeonsik.peekabook.data.source.web.BooksWebDataSource
import kim.yeonsik.peekabook.domain.bookdetail.usecase.GetBookByIsbn
import kim.yeonsik.peekabook.domain.booklist.usecase.GetBooksByTitle
import kim.yeonsik.peekabook.domain.repository.BookRepository
import kim.yeonsik.peekabook.presentation.bookdetail.BookDetailViewModel
import kim.yeonsik.peekabook.presentation.booklist.BookListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BookDetailViewModel(get()) }
    viewModel { BookListViewModel(get()) }
}

val useCaseModule = module {
    factory { GetBookByIsbn(get()) }
    factory { GetBooksByTitle(get()) }
}

val repositoryModule = module {
    single<BookRepository> { BookRepositoryImpl(get()) }
}

val dataSourceModule = module {
    single<RemoteBookDataSource> { BooksWebDataSource() }
}
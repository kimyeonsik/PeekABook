package kim.yeonsik.peekabook.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun AppCompatActivity.addFragment(containerViewId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        add(containerViewId, fragment)
        commit()
    }
}

fun AppCompatActivity.replaceFragment(containerViewId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(containerViewId, fragment)
        addToBackStack(null)
        commit()
    }
}

fun AppCompatActivity.replaceFragmentWithoutBackStack(containerViewId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(containerViewId, fragment)
        commit()
    }
}


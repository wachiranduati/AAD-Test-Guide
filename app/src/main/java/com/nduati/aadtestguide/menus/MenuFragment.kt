package com.nduati.aadtestguide.menus

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.nduati.aadtestguide.R
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment(), PopupMenu.OnMenuItemClickListener {
    lateinit var crdVw : CardView
    lateinit var root : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        root = inflater.inflate(R.layout.fragment_menu, container, false)
        crdVw = root.findViewById(R.id.clickOnMeCardView)
        registerForContextMenu(crdVw)
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val infltr : MenuInflater = inflater
        infltr.inflate(R.menu.main_options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option1 -> {
                Toast.makeText(view?.context, "option 1", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.option2 -> {
                Toast.makeText(view?.context, "option 2", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        activity?.menuInflater?.inflate(R.menu.main_options_menu, menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option1 -> {
                Toast.makeText(view?.context, "option 1", Toast.LENGTH_SHORT).show()
            }
            R.id.option2 -> {
                Toast.makeText(view?.context, "option 2", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.popUpCardView.setOnClickListener {
            val popup = PopupMenu(view.context, popUpCardView)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.main_options_menu, popup.menu)
            popup.setOnMenuItemClickListener(this)
            popup.show()
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.option1 -> {
                Toast.makeText(view?.context, "option 1 popup", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.option2 -> {
                Toast.makeText(view?.context, "option 2 popup", Toast.LENGTH_SHORT).show()
                return true
            }
            else ->{
                return false
            }
        }
    }

}
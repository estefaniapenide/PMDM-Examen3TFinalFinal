package com.example.penide_estefania_examen3t

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.lifecycle.MutableLiveData
import androidx.navigation.navGraphViewModels
import com.example.penide_estefania_examen3t.databinding.FragmentCompuestoBinding

class CompuestoFragment : Fragment() {

    private var _binding: FragmentCompuestoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompuestoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val listadoRock: MutableList<Album> = ArrayList()
        listadoRock.add(
            Album(
                "Abbey Road",
                "The Beatles",
                R.drawable.abbeyroad,
                resources.getString(R.string.abbeyroad)
            )
        )
        listadoRock.add(
            Album(
                "Exile on Main Street",
                "The Rolling Stones",
                R.drawable.exileonmainst,
                resources.getString(R.string.exilesonmainstreet)
            )
        )
        listadoRock.add(
            Album(
                "The Velvet Underground",
                "The Velvet Underground and Nico",
                R.drawable.velvetunderground,
                resources.getString(R.string.velvetunderground)
            )
        )
        listadoRock.add(
            Album(
                "Are You Experienced",
                "Jimi Hendrix",
                R.drawable.areyouexperienced,
                resources.getString(R.string.areyouexperienced)
            )
        )
        listadoRock.add(
            Album(
                "Back in Black",
                "AC/DC",
                R.drawable.backinblack,
                resources.getString(R.string.backinblack)
            )
        )
        listadoRock.add(
            Album(
                "Appetite for Destruction",
                "Guns N’ Roses",
                R.drawable.appetitefordestruction,
                resources.getString(R.string.appetitefordestruction)
            )
        )
        listadoRock.add(
            Album(
                "Led Zeppelin IV",
                "Led Zeppelin",
                R.drawable.ledzeppeliniv,
                resources.getString(R.string.ledzeppeliniv)
            )
        )


        val listadoBlues: MutableList<Album> = ArrayList()
        listadoBlues.add(
            Album(
                "Lady Soul",
                "Aretha Franklin",
                R.drawable.ladysoul,
                resources.getString(R.string.ladysoul)
            )
        )
        listadoBlues.add(
            Album(
                "I Never Loved a Man the Way I Love You",
                "Aretha Franklin",
                R.drawable.neverloved,
                resources.getString(R.string.ineverloveda)
            )
        )
        listadoBlues.add(
            Album(
                "What's Going On",
                "Marvin Gaye",
                R.drawable.whatsgoingon,
                resources.getString(R.string.whatsgoingon)
            )
        )


        val listadoJazz: MutableList<Album> = ArrayList()
        listadoJazz.add(
            Album(
                "Kind of Blue",
                "Miles Davis",
                R.drawable.kindofblue,
                resources.getString(R.string.kindofblue)
            )
        )
        listadoJazz.add(
            Album(
                "Bitches Brew",
                "Miles Davis",
                R.drawable.bitchesbrew,
                resources.getString(R.string.bitchesbrew)
            )
        )
        listadoJazz.add(
            Album(
                "A Love Supreme",
                "John Coltrane",
                R.drawable.alovesupreme,
                resources.getString(R.string.alovesupreme)
            )
        )

        val listadoDiscos: MutableList<Album> = ArrayList()
*/
        val listas : ListasViewModel by navGraphViewModels<ListasViewModel>(R.id.nav_graph) {
            defaultViewModelProviderFactory
        }

        lateinit var l: MutableList<Album>

        fun chooseList(checked:Boolean,listadoGenero:MutableList<Album>){
            if (checked) {
                listas.listadoDiscos.value!!.addAll(listadoGenero)
                listas.listadoDiscos.observe(viewLifecycleOwner){
                    l=it
                }

                binding.tvBiblio.visibility = View.GONE
                binding.recyclerview
                    .apply { visibility = View.VISIBLE }
                    .apply { adapter = CustomAdapter(l) }
            } else {
                listas.listadoDiscos.value!!.removeAll(listadoGenero)
                listas.listadoDiscos.observe(viewLifecycleOwner){
                    l=it
                }
                binding.recyclerview
                    .apply { adapter = CustomAdapter(l) }
            }
        }


        binding.checkBoxRock.setOnCheckedChangeListener { compoundButton, checked ->
            chooseList(checked,listas.listadoRock)
        }

        binding.checkBoxBlues.setOnCheckedChangeListener { compoundButton, checked ->
            chooseList(checked,listas.listadoBlues)
        }

        binding.checkBoxJazz.setOnCheckedChangeListener { compoundButton, checked ->
            chooseList(checked,listas.listadoJazz)
        }

        /*fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked
                when (view.id) {
                    R.id.checkBoxRock -> {
                        chooseList(checked, listadoRock)
                    }
                    R.id.checkBoxBlues -> {
                        chooseList(checked, listadoBlues)
                    }
                    R.id.checkBoxJazz -> {
                        chooseList(checked, listadoJazz)
                    }
                }
            }
        }*/


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
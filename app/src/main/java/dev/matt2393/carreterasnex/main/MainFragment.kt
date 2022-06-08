package dev.matt2393.carreterasnex.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.matt2393.carreterasnex.databinding.FragmentMainBinding
import dev.matt2393.carreterasnex.solucion.SolucionActivity

class MainFragmente: Fragment() {
    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding?.cardClotoide?.setOnClickListener {
            startActivity(
                Intent(requireContext(), SolucionActivity::class.java)
            )
        }
        return binding?.root
    }
}
package com.example.ezbuyapplication.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ezbuyapplication.R

class FragmentContainerProfile : Fragment() {

    private var profileFrg = ProfileFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_container_profile, container, false)

        var trsFrg = childFragmentManager.beginTransaction()
        trsFrg.replace(R.id.fragmentContainerView, profileFrg).commit()

        return view
    }
}
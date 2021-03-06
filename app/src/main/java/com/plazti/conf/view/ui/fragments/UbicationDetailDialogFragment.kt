package com.plazti.conf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plazti.conf.R

/**
 * A simple [Fragment] subclass.
 * Use the [UbicationDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UbicationDetailDialogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication_detail_dialog, container, false)
    }
}
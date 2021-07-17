package com.plazti.conf.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.plazti.conf.R
/**
 * A simple [Fragment] subclass.
 * Use the [SpeakersDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeakersDetailDialogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialogragment, container, false)
    }
}
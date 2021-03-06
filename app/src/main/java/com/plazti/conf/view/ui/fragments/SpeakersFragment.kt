package com.plazti.conf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.plazti.conf.R
import com.plazti.conf.model.Speaker
import com.plazti.conf.view.adapter.SpeakerAdapter
import com.plazti.conf.view.adapter.SpeakerListener
import com.plazti.conf.viewmodel.SpeakerViewmodel
import kotlinx.android.synthetic.main.fragment_speakers.*

class SpeakersFragment : Fragment(),SpeakerListener {

    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel: SpeakerViewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(SpeakerViewmodel::class.java)
        viewModel.refresh()

        speakerAdapter = SpeakerAdapter(this)

        rvSpeakers.apply{
            layoutManager=GridLayoutManager(context,2)
            adapter = speakerAdapter
        }
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.listSpeaker.observe(this, Observer<List<Speaker>> { speakers ->
            speakers.let {
                speakerAdapter.updateData(speakers)
            }
        })
        viewModel.isLoading.observe(this, Observer<Boolean>{
            if(it != null)
                rlBase.visibility = View.INVISIBLE
        })
    }

    override fun onSpeakerClicked(speaker: Speaker, position: Int) {
        var bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.SpeakerDetailFragmentDialog, bundle)
    }
}
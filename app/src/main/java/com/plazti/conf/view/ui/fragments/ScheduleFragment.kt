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
import androidx.recyclerview.widget.LinearLayoutManager
import com.plazti.conf.R
import com.plazti.conf.model.Conference
import com.plazti.conf.view.adapter.ScheduleAdapter
import com.plazti.conf.view.adapter.ScheduleListener
import com.plazti.conf.viewmodel.ScheduleViewmodel
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment : Fragment(), ScheduleListener {
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var  viewModel: ScheduleViewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ScheduleViewmodel::class.java)
        viewModel.refresh()

        scheduleAdapter = ScheduleAdapter(this)

        rvSchedule.apply{
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = scheduleAdapter
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.listSchedule.observe(this, Observer<List<Conference>>{schedule ->
            scheduleAdapter.updateData(schedule)
        })
        viewModel.isLoading.observe(this, Observer<Boolean>{
            if(it != null)
                FSrlBaseSchedule.visibility = View.INVISIBLE
        })
    }

    override fun onconferenceClicked(conference: Conference, position: Int) {
        val bundle = bundleOf("conference" to conference)
        findNavController().navigate(R.id.ScheduleDetailFragmentDialog,bundle)
    }

}
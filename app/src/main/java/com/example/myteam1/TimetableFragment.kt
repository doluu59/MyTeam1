package com.example.myteam1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myteam1.databinding.FragmentTimetableBinding

class TimetableFragment : Fragment() {
    var binding: FragmentTimetableBinding?=null
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: TimetableRVA

    var timetableDataList=ArrayList<timetableData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimetableBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.apply {
            initRecyclerView()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun initRecyclerView() {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = TimetableRVA(timetableDataList)    //파라미터로 시간표 리스트의 배열 전달
        adapter.itemCLickListener = object :TimetableRVA.OnItemClickListener {
            override fun OnItemClick(holder: RecyclerView.ViewHolder, view: View, data: timetableData, position: Int) {    //data로 시간표 리스트 하나씩을 전체 객체로 받아야함
                //각 시간표 항목 눌렀을 때 사항.
                //해당 시간표 리스트에 대해 수정하거나 등등
            }

        }
        binding!!.apply {
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter

        }

    }

}
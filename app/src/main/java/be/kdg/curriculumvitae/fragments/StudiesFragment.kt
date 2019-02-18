package be.kdg.curriculumvitae.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import be.kdg.curriculumvitae.R
import be.kdg.curriculumvitae.adapters.StudyAdapter
import be.kdg.curriculumvitae.model.getStudies
import kotlinx.android.synthetic.main.fragment_studies.*
import kotlinx.android.synthetic.main.fragment_studies.view.*
import java.lang.RuntimeException
import kotlin.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 *
 */
class StudiesFragment : Fragment() {
    private lateinit var listener: StudyAdapter.OnStudySelectedListener
    private lateinit var rvStudies:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_studies, container, false)

        rvStudies = view.rvStudies
        rvStudies.adapter = StudyAdapter(getStudies(), context, listener)
        rvStudies.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is StudyAdapter.OnStudySelectedListener){
            listener = context
        } else{
            throw RuntimeException("context is not an instance of OnStudySelectedListener")
        }
    }
}

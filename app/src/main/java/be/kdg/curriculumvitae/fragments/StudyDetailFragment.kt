package be.kdg.curriculumvitae.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import be.kdg.curriculumvitae.R
import be.kdg.curriculumvitae.model.getStudies
import kotlinx.android.synthetic.main.fragment_study_detail.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

/**
 * A simple [Fragment] subclass.
 *
 */
class StudyDetailFragment : Fragment() {
    private lateinit var drawLogo:ImageView
    private lateinit var tvName:TextView
    private lateinit var tvFrom:TextView
    private lateinit var tvUntil:TextView
    private lateinit var tvInfo:TextView

    private var index:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_study_detail, container, false)
        drawLogo = view.ivLogo
        tvName = view.tvName
        tvFrom = view.tvFrom
        tvUntil = view.tvUntil
        tvInfo = view.tvInfo
        updateFields()
        return view
    }

    private fun updateFields(){
        if (this::tvName.isInitialized){
            var currentStudy = getStudies()[index]
            drawLogo.setImageDrawable(context?.getDrawable(currentStudy.imageResource))
            tvName.text = currentStudy.school
            tvFrom.text = currentStudy.startYear.toString()
            tvUntil.text = currentStudy.endYear.toString()
            tvInfo.text = currentStudy.comment
        }
    }

    fun setStudyIndex(studyIndex: Int) {
        index = studyIndex
        updateFields()
    }
}

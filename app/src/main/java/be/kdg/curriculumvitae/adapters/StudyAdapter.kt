package be.kdg.curriculumvitae.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import be.kdg.curriculumvitae.R
import be.kdg.curriculumvitae.model.Study
import kotlinx.android.synthetic.main.study_list_item.view.*

class StudyAdapter(
    private val studies: Array<Study>,
    private val context: Context?,
    private val listener: OnStudySelectedListener
) : RecyclerView.Adapter<StudyViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, layoutId: Int): StudyViewHolder {
        val inflater = LayoutInflater.from(vg.context)
        val view = inflater.inflate(R.layout.study_list_item, vg, false)
        return StudyViewHolder(view)
    }

    override fun getItemCount(): Int = studies.size

    override fun onBindViewHolder(vh: StudyViewHolder, index: Int) {
        val study = studies[index]
        vh.schoolImage.setImageDrawable(context?.getDrawable(study.imageResource))
        vh.yearsField.text = study.startYear.toString() + " - " + study.endYear.toString()
        vh.schoolField.text = study.school

        // Klikt er iemand op een study? -> dan spreken we 'listener' aan
        vh.itemView.setOnClickListener {
            listener.onStudySelected(index)
        }
    }

    // Deze interface moet geimplementeerd worden indien
    // je wil reageren op het selecteren van een study.
    interface OnStudySelectedListener {
        fun onStudySelected(studyIndex: Int)
    }
}

class StudyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val schoolImage: ImageView = view.school_image //because extension you don't need findViewById
    val schoolField: TextView = view.school_field
    val yearsField: TextView = view.years_field
}

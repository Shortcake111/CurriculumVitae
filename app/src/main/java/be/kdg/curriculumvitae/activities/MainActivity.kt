package be.kdg.curriculumvitae.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import be.kdg.curriculumvitae.R
import be.kdg.curriculumvitae.adapters.StudyAdapter

/**
 * Deze activity implementeert 'OnStudySelectedListener'!
 * Als er een study aangeklikt wordt dan zal deze klasse in actie moeten schieten.
 */
class MainActivity : AppCompatActivity(), StudyAdapter.OnStudySelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Hier reageren we op het feit dat een study aangeklikt wordt.
     */
    override fun onStudySelected(studyIndex: Int) {
        // TODO: aanvullen
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            val intent = Intent(this, StudyDetailActivity::class.java).apply {
                putExtra("index", studyIndex)
            }
            startActivity(intent)
        } else {
            //val fragment =
            //val detailFragment =
        }
    }
}

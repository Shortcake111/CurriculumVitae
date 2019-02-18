package be.kdg.curriculumvitae.model

data class Study (
    val school: String,
    val startYear: Int,
    val endYear: Int,
    val imageResource: Int,
    val comment: String
)

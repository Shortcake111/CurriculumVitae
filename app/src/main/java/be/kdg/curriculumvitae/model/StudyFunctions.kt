package be.kdg.curriculumvitae.model

import be.kdg.curriculumvitae.R

fun getStudies(): Array<Study> {
    return arrayOf(
        Study("Mariagaarde", 1978, 1982, R.drawable.mariagaarde, "Kleuterschool."),
        Study("Sint-Jan Berchmanscollege", 1983, 1991, R.drawable.sjb, "Basisschool en secundair: ASO, Latijn-wiskunde"),
        Study(
            "Karel de Grote Hogeschool",
            1992,
            1995,
            R.drawable.kdg,
            "Toegepaste Informatica, afstudeerrichting Applicatieontwikkeling. Mijn stage liep ik bij CRONOS."
        )
    )
}

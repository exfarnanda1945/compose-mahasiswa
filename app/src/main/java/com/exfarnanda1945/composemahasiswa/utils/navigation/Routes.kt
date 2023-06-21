package com.exfarnanda1945.composemahasiswa.utils.navigation

const val DETAIL_ARGUMENT_ID_KEY = "id"
const val DETAIL_ARGUMENT_NAME_KEY = "name"
const val DETAIL_ARGUMENT_LECTURER_KEY = "lecturerId"


sealed class Routes(val route: String) {
    object MainScreen : Routes("main_screen")
    object DetailScreen : Routes(
        "detail_screen/{${DETAIL_ARGUMENT_ID_KEY}}/{${DETAIL_ARGUMENT_NAME_KEY}}/{${DETAIL_ARGUMENT_LECTURER_KEY}}"
    ) {
        fun passObject(
            id: Int,
            name: String,
            lecturerId: String
        ): String {
            return "detail_screen/$id/$name/$lecturerId"
        }
    }
}

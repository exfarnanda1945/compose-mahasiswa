package com.exfarnanda1945.composemahasiswa.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exfarnanda1945.composemahasiswa.data.model.Course
import com.exfarnanda1945.composemahasiswa.presentation.detail.DetailScreen
import com.exfarnanda1945.composemahasiswa.presentation.main.MainScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.MainScreen.route) {
        composable(Routes.MainScreen.route) {
            MainScreen(navHostController)
        }
        composable(
            route = Routes.DetailScreen.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_ID_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_NAME_KEY) {
                    type = NavType.StringType
                    defaultValue=""
                },
                navArgument(DETAIL_ARGUMENT_LECTURER_KEY) {
                    type = NavType.StringType
                    defaultValue = ""
                },
            )
        ) {
            val course = Course(
                requireNotNull(it.arguments).getInt(DETAIL_ARGUMENT_ID_KEY),
                requireNotNull(it.arguments).getString(DETAIL_ARGUMENT_NAME_KEY).toString(),
                requireNotNull(it.arguments).getString(DETAIL_ARGUMENT_LECTURER_KEY).toString(),
            )
            DetailScreen(navHostController, course)
        }
    }

}
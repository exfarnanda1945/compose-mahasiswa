package com.exfarnanda1945.composemahasiswa.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.exfarnanda1945.composemahasiswa.R
import com.exfarnanda1945.composemahasiswa.data.model.Course
import com.exfarnanda1945.composemahasiswa.utils.UiEvent
import com.exfarnanda1945.composemahasiswa.utils.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navHostController: NavHostController) {
    val viewModel = hiltViewModel<MainViewModel>()
    val listCourse: List<Course> by viewModel.state.collectAsStateWithLifecycle(listOf())

    LaunchedEffect(key1 = true) {
        viewModel.mainChannel.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.NavigateToDetail -> {
                    navHostController.navigate(
                        Routes.DetailScreen.passObject(
                            uiEvent.course.id,
                            uiEvent.course.name,
                            uiEvent.course.lecturerId
                        )
                    )
                }

                else -> {}
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.course), color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(MaterialTheme.colorScheme.primary)
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .fillMaxSize()
            ) {
                items(count = listCourse.size, itemContent = { index ->
                    val course = listCourse[index]
                    CourseItem(course = course, onClick = {
                        viewModel.onEvent(MainScreenEvent.OnItemClick(course))
                    })
                })
            }
        }
    )

}
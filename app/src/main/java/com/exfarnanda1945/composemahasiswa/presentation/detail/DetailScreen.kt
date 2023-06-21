package com.exfarnanda1945.composemahasiswa.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.exfarnanda1945.composemahasiswa.R
import com.exfarnanda1945.composemahasiswa.data.model.Course
import com.exfarnanda1945.composemahasiswa.utils.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navHostController: NavHostController,
    course: Course
) {
    val viewModel = hiltViewModel<DetailViewModel>()

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(DetailScreenEvent.OnFind(course.lecturerId, course.id))
    }
    val detailState = viewModel.detailScreenState
    val searchState = viewModel.searchState

    LaunchedEffect(key1 = true) {
        viewModel.detailChannel.collect { uiEvent ->
            when (uiEvent) {
                UiEvent.OnBack -> navHostController.popBackStack()
                else -> {}
            }
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.detail_course),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.onEvent(DetailScreenEvent.PopBackStack)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            tint = Color.White,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        },

        content = { padding ->
            Column(
                Modifier
                    .padding(padding)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.course_field) + course.name)
                Text(text = stringResource(R.string.nid_field) + detailState.lecturer.nid)
                Text(text = stringResource(R.string.lecturer_field) + detailState.lecturer.name)

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(value = searchState.nim, onValueChange = {
                            viewModel.onEvent(DetailScreenEvent.OnSearchNimChange(it))
                        }, label = {
                            Text(text = stringResource(R.string.nim))
                        })
                        OutlinedTextField(value = searchState.name, onValueChange = {
                            viewModel.onEvent(DetailScreenEvent.OnSearchNameChange(it))
                        }, label = {
                            Text(text = stringResource(R.string.nama))
                        })
                    }
                    Button(
                        onClick = {
                            viewModel.onEvent(
                                DetailScreenEvent.OnFind(
                                    course.lecturerId,
                                    course.id
                                )
                            )
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text(text = stringResource(R.string.find))
                    }
                }
                StudentItem(students = detailState.students)
            }
        }
    )
}
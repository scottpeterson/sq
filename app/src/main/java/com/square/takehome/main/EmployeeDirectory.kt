package com.square.takehome.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.square.takehome.main.theme.SquareColors

@Composable
fun EmployeeDirectoryScreen(
    viewModel: EmployeeDirectoryViewModel = hiltViewModel()
) {
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    val state by viewModel.state.collectAsState()

    val employeeData = viewModel.employeeData.value

    when (state) {
        SquareState.Loading -> LoadingScreenComposable()
        SquareState.Empty -> EmptyStateComposable()
        SquareState.Error -> ErrorStateComposable()
        SquareState.Loaded -> SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = { viewModel.refresh() }) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                items(
                    items = employeeData!!
                ) {
                    Employee(
                        fullName = it.fullName,
                        phoneNumber = it.phoneNumber,
                        emailAddress = it.emailAddress,
                        biography = it.biography,
                        photoUrlSmall = it.photoUrlSmall,
                        team = it.team,
                        employeeType = it.employeeType,
                    )
                    Divider(
                        color = SquareColors.Gray,
                        thickness = 0.5.dp,
                        startIndent = 16.dp
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingScreenComposable() {
    Box(
        contentAlignment = Alignment.Center
    ) {
     Text(text = "Loading")
    }
}

@Composable
fun EmptyStateComposable() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = "No data")
    }
}

@Composable
fun ErrorStateComposable() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error")
    }
}

@Composable
fun Employee(
    fullName: String,
    phoneNumber: String,
    emailAddress: String,
    biography: String,
    photoUrlSmall: String,
    team: String,
    employeeType: String
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 16.dp, bottom = 44.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(photoUrlSmall),
                contentDescription = null,
                modifier = Modifier
                    .size(140.dp)
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp, 16.dp, 18.dp)
            )
            // full name
            Text(
                text = fullName,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 16.dp, bottom = 44.dp)
        ) {
            // Team
            Text(
                text = team,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // Biography
            Text(
                text = biography,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // emailAddress
            Text(
                text = emailAddress,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // phoneNumber
            Text(
                text = phoneNumber,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            // employeeType
            Text(
                text = employeeType,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

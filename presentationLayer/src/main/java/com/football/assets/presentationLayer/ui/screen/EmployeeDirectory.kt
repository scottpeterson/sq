package com.football.assets.presentationLayer.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.football.assets.model.SeahawkItem
import com.football.assets.presentationLayer.R
import com.football.assets.presentationLayer.ui.theme.SquareColors

@Composable
fun EmployeeDirectoryScreen(
    viewModel: EmployeeDirectoryViewModel = hiltViewModel()
) {
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    val state by viewModel.state.collectAsState()

    val employeeData = viewModel.employeeData.value

    val seahawksData = viewModel.seahawksData.value

    // Filters
    // Position
    // Position Group
    // 2023 Roster Status
    // Roster Type

    // Sort
    // Roster Asset Rank
    // Age
    // Height
    // Weight

    when (state) {
        SquareState.Loading -> LoadingScreenComposable()
        SquareState.Empty -> EmptyStateComposable()
        SquareState.Error -> ErrorStateComposable()
        SquareState.Loaded -> TheLazyColumn(data = seahawksData!!)
    }
}

@Composable
fun TheLazyColumn(data: List<SeahawkItem>) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        items(
            items = data
        ) {
            Seahawk(
                name = it.name,
                rosterAssetRank = it.roster_asset_rank,
                position = it.position,
                positionGroup = it.position_group,
                positionGroupDepth = it.position_group_depth,
                height = it.height,
                weight = it.weight,
                experience = it.experience,
                college = it.college,
                collegeConference = it.college_conference,
                rosterType = it.roster_type,
                age = it.age,
                capNumber = it.cap_number,
                nextYearRosterStatus = it.next_year_status,
                groupAge = it.group_age,
                offenseDefense = it.offense_defense,
                ability = it.ability,
                overallStatistic = it.overall_statistic
            )
            Divider(
                color = SquareColors.Gray,
                thickness = 0.5.dp,
                startIndent = 16.dp
            )
        }
    }
}

@Composable
fun LoadingScreenComposable(
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Text(
            text = stringResource(id = R.string.state_loading),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun EmptyStateComposable(
    viewModel: EmployeeDirectoryViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Text(
            text = stringResource(id = R.string.state_no_data),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primary
        )
        Button(onClick = { viewModel.refresh() }) {
            Text(text = stringResource(id = R.string.state_no_data_cta))
        }
    }
}

@Composable
fun ErrorStateComposable(
    viewModel: EmployeeDirectoryViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {
        Text(
            text = stringResource(id = R.string.state_error),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primary
        )
        Button(onClick = { viewModel.refresh() }) {
            Text(text = stringResource(id = R.string.state_no_data_cta))
        }
    }
}

@Composable
fun Seahawk(
    name: String,
    rosterAssetRank: Int,
    position: String,
    positionGroup: String,
    positionGroupDepth: String,
    height: String,
    weight: Int,
    experience: String,
    college: String,
    collegeConference: String,
    rosterType: String,
    age: Double,
    capNumber: String,
    nextYearRosterStatus: String,
    groupAge: Double,
    offenseDefense: String,
    ability: Int,
    overallStatistic: Double,
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
//            AppTopBar(
//                title = { Text(text = "Seahawks")},
//                color = MaterialTheme.colors.primary,
//                navigationIcon = {
//                    IconButton(onClick = { /*TODO*/ }) {
//
//                    }
//                }
//            ) {
//
//            }

            Image(painter = painterResource(id = R.mipmap.logo_action_green_foreground), contentDescription = null )
            Text(
                text = name,
                style = MaterialTheme.typography.h2,
                color = SquareColors.SeahawksNavy,
                modifier = Modifier.padding(end = 4.dp, bottom = 4.dp)
            )
            SeahawkRow(
                text_one = stringResource(id = R.string.roster_asset_rank),
                text_two = rosterAssetRank.toString()
            )
            SeahawkRow(
                text_one = "Position: ",
                text_two = position
            )
            SeahawkRow(
                text_one = "Position Group: ",
                text_two = positionGroup
            )
            SeahawkRow(
                text_one = "Position Group Depth Chart: ",
                text_two = positionGroupDepth
            )
            SeahawkRow(
                text_one = "2022 Cap Number: ",
                text_two = capNumber
            )
            SeahawkRow(
                text_one = "2023 Roster Status: ",
                text_two = nextYearRosterStatus
            )
            SeahawkRow(
                text_one = "Height: ",
                text_two = height
            )
            SeahawkRow(
                text_one = "Weight: ",
                text_two = "$weight lbs"
            )
            SeahawkRow(
                text_one = "Experience: ",
                text_two = experience
            )
            SeahawkRow(
                text_one = "College: ",
                text_two = college
            )
            SeahawkRow(
                text_one = "Conference: ",
                text_two = collegeConference
            )
            SeahawkRow(
                text_one = "Age: ",
                text_two = age.toString()
            )
            SeahawkRow(
                text_one = "Roster Type: ",
                text_two = rosterType
            )
        }
    }
}

@Composable
fun SeahawkRow(
    text_one: String,
    text_two: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 4.dp, bottom = 4.dp)
    )  {
        Text(
            text = text_one,
            style = MaterialTheme.typography.h4,
            color = SquareColors.SeahawksActionGreen
        )
        Text(
            text = text_two,
            style = MaterialTheme.typography.h5,
            color = SquareColors.SeahawksNavy
        )
    }
}

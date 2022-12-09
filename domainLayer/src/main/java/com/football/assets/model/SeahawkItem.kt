package com.football.assets.model

data class SeahawkItem(
    val cap_number: String,
    val next_year_status: String,
    val ability: Int,
    val age: Double,
    val birthdate: String,
    val college: String,
    val college_conference: String,
    val experience: String,
    val group_age: Double,
    val height: String,
    val name: String,
    val offense_defense: String,
    val overall_statistic: Double,
    val position: String,
    val position_group: String,
    val position_group_depth: String,
    val roster_asset_rank: Int,
    val roster_type: String,
    val weight: Int
) {
    fun toSeahawk(): SeahawkItem {
        return SeahawkItem(
            cap_number = cap_number,
            next_year_status = next_year_status,
            ability = ability,
            age = age,
            birthdate = birthdate,
            college = college,
            college_conference = college_conference,
            experience = experience,
            group_age = group_age,
            height = height,
            name = name,
            offense_defense = offense_defense,
            overall_statistic = overall_statistic,
            position = position,
            position_group = position_group,
            position_group_depth = position_group_depth,
            roster_asset_rank = roster_asset_rank,
            roster_type = roster_type,
            weight = weight
        )
    }
}
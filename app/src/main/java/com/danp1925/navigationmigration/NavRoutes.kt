package com.danp1925.navigationmigration

import kotlinx.serialization.Serializable

object NavRoutes {
    @Serializable
    data object First

    @Serializable
    data class Second(val stringArgument: String)

    @Serializable
    data class Third(val numberArgument: Int)
}
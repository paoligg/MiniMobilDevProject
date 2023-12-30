package com.example.miniprojectpaoligblan

import com.example.miniprojectpaoligblan.model.DisneyCharacter

data class DisneyApiResponse(
    val data: List<DisneyCharacter>,
    val infos: DisneyApiInfos
)

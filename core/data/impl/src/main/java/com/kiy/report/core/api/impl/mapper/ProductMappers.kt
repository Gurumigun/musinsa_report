package com.kiy.report.core.api.impl.mapper

import com.kiy.report.core.api.impl.api.model.MusinsaProductsResponse
import com.kiy.report.core.model.MusinsaProducts


fun MusinsaProductsResponse.toDomain(): MusinsaProducts {
    return MusinsaProducts()
}
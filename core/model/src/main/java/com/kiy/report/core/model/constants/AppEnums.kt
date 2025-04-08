package com.kiy.report.core.model.constants

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 8.
 */

enum class ContentType(val type: String) {
    BANNER("BANNER"),
    GRID("GRID"),
    SCROLL("SCROLL"),
    STYLE("STYLE");

    companion object {
        fun findByType(type: String): ContentType? {
            return entries.firstOrNull { it.type == type }
        }
    }
}

package ru.altarix.mnature_androi_kotlin.base.utils

/**
 * Created by Trunks on 01.06.2017.
 */
class AppTextUtils {
    companion object {
        fun isEmpty(target: String): Boolean {
            return "null".equals(target, ignoreCase = true) || target.isNullOrBlank()
        }
    }
}
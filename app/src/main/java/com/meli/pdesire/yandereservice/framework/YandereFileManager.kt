package com.meli.pdesire.yandereservice.framework

import java.io.File

/**
 * Created by PDesire on 8/17/17.
 */

object YandereFileManager {

    fun fileCheck(filepath : String): Boolean {
        val file = File(filepath)

        return file.exists()
    }
}
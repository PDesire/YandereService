package com.meli.pdesire.yandereservice.framework

import android.app.AlertDialog
import android.content.Context

/**
 * Created by PDesire on 8/16/17.
 */
object YandereOutputWrapper {

    // If you use hardcoded strings, use that
    fun outputMessageString (title : String, message : String, context : Context) {
        val messageOutput = AlertDialog.Builder(context)
        messageOutput.setTitle(title)
        messageOutput.setMessage(message)
        messageOutput.create()
        messageOutput.show()
    }

    // If you use R strings, use that
    fun outputMessageInt (title : Int, message : Int, context : Context) {
        val messageOutput = AlertDialog.Builder(context)
        messageOutput.setTitle(title)
        messageOutput.setMessage(message)
        messageOutput.create()
        messageOutput.show()
    }
}
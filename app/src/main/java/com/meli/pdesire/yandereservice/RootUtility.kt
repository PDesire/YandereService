package com.meli.pdesire.yandereservice

import java.io.DataOutputStream
import java.io.IOException

/**
 * Created by PDesire on 26.05.2017.
 */

object RootUtility {

    var rootfsIsRW : Boolean = false;
    var systemIsRW : Boolean = false;

    fun mount_rw_rootfs() {
        sudo("mount -o remount,rw /");
        sudo("mount -o remount,rw rootfs");
        rootfsIsRW = true;
    }

    fun mount_ro_rootfs() {
        sudo("mount -o remount,ro /");
        sudo("mount -o remount,ro rootfs");
        rootfsIsRW = false;
    }

    fun mount_rw_system() {
        sudo("mount -o remount,rw /system");
        systemIsRW = true;
    }

    fun mount_ro_system() {
        sudo("mount -o remount,ro /system");
        systemIsRW = false;
    }

    fun security_harden() {
        if (systemIsRW)
            mount_ro_system()

        if (rootfsIsRW == true)
            mount_ro_rootfs()
    }

    fun sudo(strings: String) {
        try {
            val su = Runtime.getRuntime().exec("su")
            val outputStream = DataOutputStream(su.outputStream)

            for (s in strings) {
                outputStream.writeBytes(s + "\n")
                outputStream.flush()
            }

            outputStream.writeBytes("exit\n")
            outputStream.flush()
            try {
                su.waitFor()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            outputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}
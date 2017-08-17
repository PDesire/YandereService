package com.meli.pdesire.yandereservice.framework

/**
 * Created by PDesire on 8/17/17.
 */
object YanderePDesireAudioAPI {

    fun getPDesireAudio() : String {
        var pdesireaudio_path : String = ""

        val apiLists : Int = 4;
        val pdesireaudio_arrayed_paths = arrayOf("/sys/module/snd_soc_wcd9330/uhqa_mode_pdesireaudio",
                                                "/sys/module/snd_soc_wcd9330/PDesireAudio",
                                                "/sys/module/snd_soc_wcd9320/uhqa_mode_pdesireaudio",
                                                "/sys/module/snd_soc_wcd9320/PDesireAudio")

        var count : Int = 0
        while (count != apiLists) {
            if(YandereFileManager.fileCheck(pdesireaudio_arrayed_paths[count])) {
                pdesireaudio_path = pdesireaudio_arrayed_paths[count]
                break
            }
            count++
        }

        return pdesireaudio_path
    }

    fun getPDesireAudioStatic() : String{
        var pdesireaudio_path : String = ""

        val apiLists : Int = 2;
        val pdesireaudio_arrayed_paths = arrayOf("/sys/module/snd_soc_wcd9320/pdesireaudio_static_mode",
                                                        "/sys/module/snd_soc_wcd9330/pdesireaudio_static_mode")

        var count : Int = 0
        while (count != apiLists) {
            if(YandereFileManager.fileCheck(pdesireaudio_arrayed_paths[count])) {
                pdesireaudio_path = pdesireaudio_arrayed_paths[count]
                break
            }
            count++
        }

        return pdesireaudio_path
    }
}
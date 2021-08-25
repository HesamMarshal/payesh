package ir.hesammarshal.payesh.utils

object Constants {

    const val HEART_SYSTOLIC : String = "HeartSystolic"
    const val HEART_DIASTOLIC: String = "HeartDiastolic"
    const val HEART_PULSE:String = "HeartPulse"

    fun heartSystolic():ArrayList<String>{
        val list = ArrayList<String>()
        for (i in 30..300) {
            list.add(i.toString())
        }
        return list
    }
    fun heartDiastolic():ArrayList<String>{
        val list = ArrayList<String>()
        // TODO: add by for
        for (i in 20..300) {
            list.add(i.toString())
        }
        return list
    }
    fun heartPulse():ArrayList<String>{
        val list = ArrayList<String>()
        // TODO: add by for
        for (i in 10..200) {
            list.add(i.toString())
        }
        return list
    }
}
package ir.hesammarshal.payesh.utils

object Constants {

    const val HEART_SYSTOLIC : String = "HeartSystolic"
    const val HEART_DIASTOLIC: String = "HeartDiastolic"
    const val HEART_RATE:String = "HeartRate"

    fun heartSystolic():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("30")
        list.add("40")
        list.add("50")
        list.add("60")
        list.add("70")
        list.add("80")
        list.add("90")
        list.add("100")
        list.add("110")
        list.add("120")
        list.add("130")
        list.add("140")
        list.add("150")
        list.add("160")
        list.add("170")
        list.add("180")
        list.add("300")

        return list
    }
    fun heartDiastolic():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("20")
        list.add("30")
        list.add("40")
        list.add("50")
        list.add("60")
        list.add("70")
        list.add("80")
        list.add("90")
        list.add("100")
        list.add("110")
        list.add("120")
        list.add("130")
        list.add("140")
        list.add("150")
        list.add("160")
        list.add("170")
        list.add("180")
        list.add("300")

        return list
    }
    fun heartRate():ArrayList<String>{
        val list = ArrayList<String>()
        list.add("10")
        list.add("40")
        list.add("50")
        list.add("60")
        list.add("70")
        list.add("80")
        list.add("90")
        list.add("100")
        list.add("110")
        list.add("120")
        list.add("130")
        list.add("140")
        list.add("150")
        list.add("160")
        list.add("170")
        list.add("180")
        list.add("200")

        return list
    }

}
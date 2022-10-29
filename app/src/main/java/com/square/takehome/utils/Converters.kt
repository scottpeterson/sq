package com.square.takehome.utils

class Converters {

    fun toFormattedPhoneNumber(phoneNumber: String): String {
        return "(" + phoneNumber.substring(0,3) + ")" + phoneNumber.substring(3,7) + "-" + phoneNumber.substring(7,11)
    }

}
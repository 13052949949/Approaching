package com.gc.ktx

import java.util.regex.Pattern

/**
 * Determine whether a string is a valid phone number
 */
fun String.isValidPhoneNumber(): Boolean {
    if (isNullOrEmpty()) {
        return false
    }
    val p = Pattern.compile("^1([358][0-9]|4[579]|66|7[0135678]|9[589])[0-9]{8}$")
    val m = p.matcher(this)
    return m.matches()
}

/**
 * Encrypt the phone number by replacing the middle 4 digits with asterisk
 */
fun String.encryptPhoneNumberMiddle(): String {
    if (isValidPhoneNumber()) {
        return this.replace("(\\d{3})\\d{4}(\\d{4})".toRegex(), "$1****$2")
    }
    return this
}

/**
 * Determine whether a string is a valid email address
 */
fun String.isValidEmail(): Boolean {
    if (containsChineseCharacters()) {
        return false
    }
    if (isNullOrEmpty()) {
        return false
    }
    val mailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")
    return mailer.matcher(this).matches()
}

/**
 * Determine whether a string contains Chinese characters
 */
fun String.containsChineseCharacters(): Boolean {
    val pattern = Pattern.compile("[\u4e00-\u9fa5]")
    val matcher = pattern.matcher(this)
    return matcher.find()
}

/**
 * Determine whether the string is pure Chinese
 */
fun String.isPureChinese(): Boolean {
    val chars = toCharArray()
    for (char in chars) {
        if (char.code < 0x4E00 || char.code > 0x9FA5) {
            return false
        }
    }
    return true
}
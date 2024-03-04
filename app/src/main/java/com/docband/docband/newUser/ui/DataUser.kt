package com.docband.docband.newUser.ui

data class DataUser(val name: String = "",
                    val cedula: String = "",
                    val gender: String = "",
                    val placeB: String = "",
                    val religion: String = "",
                    val address: String = "",
                    val usualAddress: String = "",
                    val phoneNumber: String = "",
                    val fPhoneNumber: String = "",
                    val occupation: String = "",
                    val etnia: String = "",
                    val typeBlood: String = "")

data class HabitsUser (val food: String = "",
                       val drunk: String = "",
                       val smoke: String = "",
                       val coffee: String = "")

data class AccountUser (val email: String = "",
                        val password: String = "",
                        val cedula: String = "")

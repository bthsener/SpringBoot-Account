package com.batuhansener.account.dto

import java.math.BigDecimal

data class CreateAccountRequest(
        val customer_id: String,
        val initialCredit: BigDecimal
)

package com.batuhansener.account.dto

data class UpdateCustomerNameRequest (
        val customer_id: String,
        val customer_name: String
)
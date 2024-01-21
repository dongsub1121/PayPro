package com.nicepayment.paypro.ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nicepayment.paypro.R
import com.nicepayment.paypro.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
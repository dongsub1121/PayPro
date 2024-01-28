package com.nicepayment.paypro.ui.payment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.findNavController
import com.nicepayment.paypro.R
import com.nicepayment.paypro.databinding.ActivityPaymentBinding
import com.nicepayment.paypro.model.argument.PaymentArgument
import com.nicepayment.paypro.model.argument.PaymentMethod

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}
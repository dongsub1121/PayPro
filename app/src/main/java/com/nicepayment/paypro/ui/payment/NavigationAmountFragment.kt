package com.nicepayment.paypro.ui.payment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.nicepayment.paypro.R
import com.nicepayment.paypro.databinding.FragmentHomeBinding
import com.nicepayment.paypro.databinding.FragmentNavigationAmountBinding
import com.nicepayment.paypro.model.argument.PaymentArgument
import com.nicepayment.paypro.model.argument.PaymentMethod
import kotlinx.coroutines.flow.distinctUntilChanged

class NavigationAmountFragment : Fragment() {
    private var _binding: FragmentNavigationAmountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val args: NavigationAmountFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNavigationAmountBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root
        val next: Button = _binding!!.next

        next.setOnClickListener {
            Log.e("Model","next")
            //viewModel.setAmount(amount)
            //findNavController().navigate(R.id.action_navigationAmountFragment_to_navigationCodeFragment)

            val amount = _binding!!.editTextAmount.text.toString().toInt()
            if ( amount >0 ) {
                val paymentArgument = PaymentArgument(PaymentMethod.PayPro,amount)
                toCodeFragment(paymentArgument)
            } else {
                Toast.makeText(requireContext(),"결제 금액을 입력해 주세요", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    private fun toCodeFragment(paymentArgument: PaymentArgument) {
        this@NavigationAmountFragment.findNavController().navigate(
            NavigationAmountFragmentDirections
                .actionNavigationAmountFragmentToNavigationCodeFragment(
                    paymentArgument
                )
        )
    }
}